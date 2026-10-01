# send requests
import requests


# head 用于伪装请求为正常浏览器请求
headers = {"User-Agent": "YOUR_USER_AGENT"}
response = requests.get("YOUR_TARGET_URL", headers=headers)
print(response)
print(response.status_code)
'''
status codes:
200 OK 客户端请求成功
301 Moved Permanently 资源被永久移动到新地址
400 Bad Request 客户端不能被服务器所理解
401 Unauthorized 请求未经授权
403 Forbidden 服务器拒绝提供服务
404 Not Found 请求资源不存在
500 Internal Server Error 服务器发生不可预期的错误
503 Service Unavailable 服务器当前不能处理客户端的请求
'''

if response.ok: # response.status_code == 200
    print(response.text)
else:
    print("request failed")