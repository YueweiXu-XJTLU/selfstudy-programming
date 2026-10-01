# re for regex
import re


# 预加载regex，`flags=re.S`，允许`.`匹配`\n`
regex_obj = re.compile(r"\d+", re.S)

# findall(): 匹配所有可能内容，返回列表
rs_list: list = regex_obj.findall("phone number a: 18888888888; phone number b: 16666666666")
print(rs_list)

print("==========")

# finditer(): 匹配所有可能内容，返回迭代器，迭代器内元素是Match对象，用group()取出数据
rs_iterator = regex_obj.finditer("phone number a: 18888888888; phone number b: 16666666666")
for i in rs_iterator:
    print(i)
    print(i.group())
    print("=====")

print("==========")

# search(): 匹配第一个内容，返回Match对象，用group()取出数据
rs_search = regex_obj.search("phone number a: 18888888888; phone number b: 16666666666")
print(rs_search)
print(rs_search.group())

print("==========")

# match(): 从字符串首字符开始，匹配第一个内容，返回Match对象，用group()取出数据
rs_match = regex_obj.match("666, phone number a: 18888888888; phone number b: 16666666666")
print(rs_match)
print(rs_match.group())


