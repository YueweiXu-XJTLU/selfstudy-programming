import requests


keywords = input('输入关键词以搜索：')
url = f'YOUR_SEARCH_URL?query={keywords}'
headers = {"User-Agent": "YOUR_USER_AGENT"}
response = requests.get(url=url, headers=headers) # `verify=False`取消证书校验，请求收不到内容时可以试试，但是不安全而且有警告
response.encoding = "utf-8"
if response.ok:
    print(response)
    print(response.request)
    print(response.text)
    response.close() # 记得关！！！或者在headers里加一下`'Connection': 'close'`
else:
    print('failed: ', response.status_code)

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
