from generated.plugin_pb2 import Version
from generated.plugin_pb2_grpc import add_ExportPluginServicer_to_server
from .types import ExportCommand, ExportPlugin
from grpc import server as _server
from concurrent.futures import ThreadPoolExecutor
from grpc_health.v1.health_pb2_grpc import add_HealthServicer_to_server
from grpc_health.v1.health import HealthServicer
import os
from .net import get_listener

MAGIC_COOKIE_NAME = "TF_EXPORTER"
MAGIC_COOKIE_VALUE = "exporter-plugin"

PROVIDED_PLUGIN_VERSION = "3"
PLUGIN_VAR = "PLUGIN_PROTOCOL_VERSIONS"

REQUIRED_ENV_VARS = [
    MAGIC_COOKIE_NAME,
    PLUGIN_VAR
]


def validatePreconditions() -> None:
    """
    Ensures that environment variables that are set by the terraform-exporter
    CLI are present and set to the correct value.
    """
    for name in REQUIRED_ENV_VARS:
        if os.getenv(name) is None:
            raise f"This application is designed to be started indirectly by the terraform-exporter CLI. Environment variables it sets are missing"

    if os.getenv(MAGIC_COOKIE_NAME) != MAGIC_COOKIE_VALUE:
        raise f"Environment variable {MAGIC_COOKIE_NAME} does not equal expected value {MAGIC_COOKIE_VALUE}"

    allowedPluginVersions = os.getenv(PLUGIN_VAR).split(",")
    if PROVIDED_PLUGIN_VERSION not in allowedPluginVersions:
        raise f"Plugin provides version {PROVIDED_PLUGIN_VERSION} but the exporter CLI requires versions {allowedPluginVersions}"


def ServePlugin(version: Version, blocking: bool = True, *args: ExportCommand) -> None:
    """
    ServePlugin takes a plugin Version and a list of classes that subclass ExportCommand and 
    launches a GRPC Server that can serve requests from the terraform-exporter CLI. This
    is designed to be run as a __main__ function. NOTE: Due to requirements from the
    terraform-exporter CLI and its underlying libraries, you MUST ensure that NOTHING is 
    written to sys.stdout before this function runs. This is a blocking function, by default.

    :param Version version: The semver-compatible version of the plugin
    :param blocking: Whether or not this should be a blocking call. Defaults to True
    :type blocking: bool or None
    :param *args: one or more instances of a class that is a subclass of ExportCommand
    :return: None
    """
    plugin = ExportPlugin(version, *args)

    server = _server(ThreadPoolExecutor(max_workers=3))
    add_ExportPluginServicer_to_server(plugin, server)
    add_HealthServicer_to_server(HealthServicer(), server)

    validatePreconditions()

    listener = get_listener()
    server.add_insecure_port(listener.address)
    server.start()
    print(f"1|{PROVIDED_PLUGIN_VERSION}|{listener.family}|{listener.address}|grpc\n")
    if blocking:
        server.wait_for_termination()
