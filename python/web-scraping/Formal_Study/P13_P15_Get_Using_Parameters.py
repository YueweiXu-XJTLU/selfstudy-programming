import requests

# Set the target endpoint and its parameters
url = 'YOUR_API_URL'
headers = {'user-agent':'YOUR_USER_AGENT', 'Connection': 'close'}
# url中`?`前为网址，后为参数，参数可以如下方式传入（在Payload中找到）
params = {
    'YOUR_PARAMETER': 'YOUR_VALUE'
}
resp = requests.get(url=url, params=params, headers=headers)

print(resp.text)
