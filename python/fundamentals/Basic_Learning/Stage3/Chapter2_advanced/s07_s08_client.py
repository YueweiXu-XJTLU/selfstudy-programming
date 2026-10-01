import socket

# client
# create client object
socket_client = socket.socket()

# link client to server's IP & port
socket_client.connect(("localhost", 8888))

while True:
    # send information to server
    msg= input("send to server (\"e\" to break): ")
    if msg == "e":
        break
    socket_client.send(msg.encode("utf-8"))

    # receive information from server
    data = socket_client.recv(1024)
    print(data.decode("utf-8"))

# close client
socket_client.close()