import socket

# server
# create server object
socket_server = socket.socket()

# bind server to IP & port
socket_server.bind(("localhost", 8888))

# start monitoring
socket_server.listen(2) # allow maximum 2 client linkage

# wait until accept information from client
result: tuple = socket_server.accept()
conn = result[0] # a conn object link server & client
address = result[1] # address of client
print("client info: ", address)

while True:
    # receive information from client
    data: str = conn.recv(1024).decode("utf-8")  # buffer area size == 1024 bytes
    print(data)

    # send reply
    msg = input("send to client (\"e\" to break):")
    if msg == "e":
        break
    conn.send(msg.encode("utf-8"))

# close linkage
conn.close()

# close server
socket_server.close()