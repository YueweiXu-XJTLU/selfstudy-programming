# xpath(lxml.etree对象的一个方法)用于在xml中搜索内容(html是xml的一个子集)
# 可以直接在网页-检查中`Copy Xpath`(相对位置)/`Copy full Xpath`(绝对位置,从<html>开始)
from lxml import etree


# 1. 创建lxml.etree对象
# 用`XML(xml)`/`HTML(html)`直接解析字符串
xml = '''
<library>
    <title>一号图书馆</title>>
    <book id="b1">
        <title>Python 数据分析</title>
        <author>张三</author>
        <year>2022</year>
        <price currency="CNY">88.50</price>
    </book>
    <book id="b2">
        <title>机器学习导论</title>
        <author>李四</author>
        <year>2021</year>
        <price currency="USD">39.99</price>
    </book>
    <book id="b3">
        <title>深度学习进阶</title>
        <author>王五</author>
        <year>2023</year>
        <price currency="CNY">128.00</price>
    </book>
</library>
'''
tree_1 = etree.XML(xml)
# 用`parse`解析文件
html_file = "P33_P36_Xpath.html"
tree_2 = etree.parse(html_file)

# 2. 取子节点
node_library: list = tree_1.xpath("/library")
print(node_library)

# 3. 取叶节点的具体数据
# 在某层结点取数据: 可以用`[idx]`/`[@attr="value"]`选择某些节点
node_title_book_1: list = tree_1.xpath("/library/book[1]/title/text()") # xpath的索引从1开始
print(node_title_book_1)
node_title_book_2: list = tree_1.xpath("/library/book[@id='b2']/title/text()") # xpath的索引从1开始
print(node_title_book_2)
# 在某层结点所有下级取数据: 通配符`*` -- `.../*/...`
node_title_2nd_level: list = tree_1.xpath("/library/*/title/text()")
print(node_title_2nd_level)
# 在某层结点所有下级至叶节点取数据: `...//...`
node_title_all: list = tree_1.xpath("/library//title/text()")
print(node_title_all)

# 4. iterate
web_list = tree_2.xpath("/html/body/ul/li")
for web in web_list:
    web_name: list[str] = web.xpath("./a/text()") # 这里进行相对查找, li为新的根节点, 从`./`开始继续查找
    web_url: list[str] = web.xpath("./a/@href") # `@attr`取属性值
    print(web_name[0], "-", web_url[0])
