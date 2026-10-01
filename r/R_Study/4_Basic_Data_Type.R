# number
1.234e56

# --------------------------------------------------------------------------------------------------------------

# missing value
# NA: value available here, but miss
# NULL: not value here
c(NA, NA, NULL, NA)

# --------------------------------------------------------------------------------------------------------------

# logic (boolean)
a <- seq(1, 10)
b <- a >= 5
b
which(b)
all(b)
any(b)

# --------------------------------------------------------------------------------------------------------------

# text (string)
print('hello' == "hello")

toupper("Runoob") # 转换为大写
tolower("Runoob") # 转换为小写

nchar("中文", type="bytes") # 统计字节长度
nchar("中文", type="char") # 总计字符数量

substring("98765432123456789", 1, 5) # 截取字符串，从index = 1到index = 5
substring("98765432123456789", 5) # 截取字符串，从index = 5到结束

as.numeric("12") # 将字符串转换为数字
as.character(12.34) # 将数字转换为字符串

strsplit("2019;10;1", ";") # 分隔符拆分字符串

gsub("/", "-", "2019/10/1") # 替换所有匹配的字符串(global substitution)

paste('abc', 'def', sep = "") # 将多个字符串连接成一个字符串，seq指定分隔符
paste(LETTERS[1:3], c(1:3), sep = "-") # 将多个向量按索引逐一连成字符串，返回新向量
paste(LETTERS[1:3], c(1:3), sep = "-", collapse = "&") # 将多个向量按索引逐一连成字符串，用collapse连接新向量

strsplit("hello world", " ")

str(c(1:5)) # 显示对象的结构和内容摘要

num <- 9.8765
# format() always output a string
format(num, digits = 3) # 数字呈现总位数
format(num, nsmall = 10) # 最少保留小数位数，最后一位四舍五入
format(num, scientific = TRUE) # 设置为科学计数法
format(num, width = 10, justify = "left") # 指定输出字符串总位数，并指定内容在字符串中的对齐方式，justify = "left" / "right" / "centre" / "none"
