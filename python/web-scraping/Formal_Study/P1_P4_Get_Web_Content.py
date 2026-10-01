from urllib.request import urlopen

# get contents of a website
url = 'YOUR_TARGET_URL'
response = urlopen(url)
content = response.read().decode('utf-8')
# print(content)

# write into a file
with open("P1_P4_Get_Web_Content.html", mode='w', encoding='utf-8') as f:
    f.write(content)
print("success!")
