# mean(x, trim = 0.1, na.rm = TRUE)
a <- c(1:10)
b <-  c(1, 2.9, 3, 4, 5, 6, 7, 8, 9.9, 10)
c <- c(1, 2, NA)
# common
mean(a)
# trim = 0.2: first sort y; then remove [length(y)*0.2] elements in head of y & [length(y)*0.2] elements in tail of y; finally calculate mean
# NA is not considered in trim
mean(b)
mean(b, trim = 0.2)
# na.rm = TRUE
mean(c)
mean(c, na.rm = TRUE)

# ----------------------------------------------------------------------------------------------------

# median(x, na.rm = FALSE): 奇数个数取中位数直接取；偶数个数取中位数取中间两数平均值
d <- c(1, 2, 3, 4, 5, 6, NA)
median(d)
median(d,na.rm = TRUE)

# ----------------------------------------------------------------------------------------------------

# mode (众数)
# define a new function
get_mode <- function(v) { # 解决tabulate只能统计整数整数的问题：用match把变量（任何类型）转位置（整数）， 再用位置做掩码返回原变量
uniq_v <- unique(v) # 取v中的unique元素各一个
# pipe的`.`只能用于一次性下一个命令, 要是想用多次`.`的话要用`{}`包围下一个命令
v %>% 
    match(., uniq_v) %>% # 对于向量 v 的每个元素，返回它在向量 uniq_v 中第一次出现的位置（下标）
    tabulate(.) %>%  # 制表，统计每个数字（限整数）在输入中出现了几次
    {uniq_v[. == max(.)]} %>% # 如果某元素出现的数量最多，用整数掩码返回输入中的元素
    return(.)  
}
# use
int_v <- c(3, 2, 1, 1, 2, 3, 1, 2)
float_v <- c(3, 1, 1, 2.3, 2.3, 3, 1, 2.3)
char_v <- c("google","runoob","taobao","runoob","runoob","taobao","taobao")
get_mode(int_v)
get_mode(float_v)
get_mode(char_v)

# ----------------------------------------------------------------------------------------------------

# Linear Regression (利用线性回归方程的最小平方函数, 对一个或多个自变量和因变量之间关系进行建模的一种回归分析)
# 一元线性回归分析 (一个自变量 ~ 一个因变量)

# 1. 数据准备
height_list <- c(151, 174, 138, 186, 128, 136, 179, 163, 152, 131)
weight_list <- c(63, 81, 56, 91, 47, 57, 76, 72, 62, 48)
data_list <- data.frame(y = height_list, x = weight_list)

# 2. 拟合linear model: `lm(formula, data)`
relation <- lm(y~x, data_list)
# OR
relation <- lm(height_list~weight_list)
relation

# 3. 作图
x <- weight_list
y <- height_list
plot(
    x, y, 
    col = "red", 
    pch = 16, 
    abline(
        relation, 
        col = "blue", 
        lwd = 2, 
        pch = 19
        ), 
    xlab = "Weight in Kg", ylab = "Height in cm", main = "Height & Weight Regression"
    )

# 4. 查看总结
summary(relation)

# 5. 将拟合模型用于新数据的预测: `predict(object, newdata)`
weight_pred <- data.frame(x = c(50, 56, 76))
height_pred <- predict(relation, weight_pred)
height_pred
