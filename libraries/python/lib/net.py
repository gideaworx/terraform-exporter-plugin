import tempfile
import socket
import os
from contextlib import closing
from collections import namedtuple

addrinfo = namedtuple('addrinfo', ['family', 'address'])

def build_tcp() -> addrinfo:
    with closing(socket.socket(socket.AF_INET, socket.SOCK_STREAM)) as s:
        s.bind(('', 0))
        s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        port = s.getsockname()[1]
        return addrinfo("tcp", f"127.0.0.1:{port}")

def build_uds() -> addrinfo:
    tf = tempfile.mkstemp(dir=tempfile.gettempdir())
    filename = tf[1]
    os.unlink(filename)
    sock = socket.socket(socket.AF_UNIX, socket.SOCK_STREAM)
    sock.bind(filename)
    return addrinfo("unix", f"unix://{filename}")

def get_listener() -> addrinfo:
    try:
        return build_uds()
    except BaseException as e:
        print(f"error building unix domain socket, falling back to tcp: {e}")
        return build_tcp()
   
    