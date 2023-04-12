import tempfile
import socket
import os
from contextlib import closing
from collections import namedtuple

addrinfo = namedtuple('addrinfo', ['family', 'address'])

def build_tcp() -> addrinfo:
    """
    Finds an open TCP port on localhost
    """
    with closing(socket.socket(socket.AF_INET, socket.SOCK_STREAM)) as s:
        s.bind(('', 0))
        s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        port = s.getsockname()[1]
        return addrinfo("tcp", f"127.0.0.1:{port}")

def build_uds() -> addrinfo:
    """
    Creates a UNIX domain socket for communication betwen the CLI and the
    plugin
    """
    tf = tempfile.mkstemp(dir=tempfile.gettempdir())
    filename = tf[1]
    os.unlink(filename)
    sock = socket.socket(socket.AF_UNIX, socket.SOCK_STREAM)
    sock.bind(filename)
    return addrinfo("unix", f"unix://{filename}")

def get_listener() -> addrinfo:
    """
    Gets info about an open listener on localhost for communications between
    the CLI and the plugin. For performance and reliability, it prefers to 
    create a UNIX domain socket. If one cannot be created for any reason (e.g.
    the OS doesn't support them or the calling user does not have permissions
    to create one), it returns TCP connection info instead
    """
    try:
        return build_uds()
    except BaseException as e:
        print(f"error building unix domain socket, falling back to tcp: {e}")
        return build_tcp()
   
    