import requests


# Proxy 代理：通过第三方代理发从请求，防止IP被封但是访问速度会变慢
# 自行查找所需协议的IP
# 在proxies里写入`"协议类型": "协议类型://IP地址:端口"`
proxies = {
    "http": "YOUR_PROXY_URL",
}

resp = requests.get("YOUR_TARGET_URL", proxies=proxies)
resp.encoding = "utf-8"
print(resp.text)
resp.close()
