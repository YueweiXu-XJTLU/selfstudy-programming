import requests

url = 'YOUR_API_URL'
headers = {'user-agent': 'YOUR_USER_AGENT', 'Connection': 'close'}
kw = input('Enter your word to translate: ')
data = {'kw': kw}
resp = requests.post(url=url, data=data, headers=headers)
print(resp.json()) # 直接转成json，防止编码不兼容
