library("ggplot2")

BOD <- BOD
mtcars <- mtcars
pressure <- pressure
ToothGrowth <- ToothGrowth
my_fun <- function(var) {
  1 / ( 1 + exp(10 + var) )
}
my_fun_2 <- function(var) {
  1 - ( 1 / ( 1 + exp(10 + var) ) )
}

####################################################################################################

# Scatter Plot

# basic
plot(mtcars)

# qplot (quick plot, a method of ggplot)
qplot(mtcars$wt, mtcars$mpg)
qplot(wt, mpg, data = mtcars) # 指定数据集

# ggplot
ggplot(mtcars, aes(x=wt, y=mpg)) + geom_point() # 指定数据集 + 指定图类型

####################################################################################################

# Line Plot

# basic
plot(pressure$temperature, pressure$pressure, type = "l") # type = "line"
points(pressure$temperature, pressure$ pressure/2, col = "red") # 追加点
lines(pressure$temperature, pressure$ pressure/3, col = "blue") # 追加线

#qplot
qplot(pressure$temperature, pressure$pressure, geom = c("line", "point"))

# ggplot
ggplot(pressure, aes(x=temperature, y=pressure)) + geom_point() + geom_line()

####################################################################################################

# Bar Plot

# 频次图
# basic
mtcars_cyl_count <- table(mtcars$cyl) # table()自动统计频次表
mtcars_cyl_count
barplot(mtcars_cyl_count) # 画频次表可以只传一个表参数

# qplot
qplot(mtcars$cyl) # 默认画频次图，直接传一列就行，默认画连续型变量(histogram)
mtcars_cyl <- factor(mtcars$cyl) # 用factor()转为分类变量
qplot(mtcars_cyl)

# ggplot
ggplot(mtcars, aes(cyl)) + geom_bar() # 默认画频次图(stat = "count")，直接传一列就行，默认画连续型变量
ggplot(mtcars, aes(factor(cyl))) + geom_bar()

# 指定y轴
# basic
barplot(BOD$demand, names.arg = BOD$Time) # barplot(y, names.arg = x)

# ggplot
ggplot(BOD, aes(x=factor(Time), y=demand)) + geom_bar(stat = "identity")

####################################################################################################

# Histogram Plot (连续分布的概率分布估计，将最大最小值平均划分为n个连续不重叠区间)

# basic
hist(mtcars$mpg)
hist(mtcars$mpg, breaks = 10)

# qplot
qplot(mtcars$mpg)
qplot(mtcars$mpg, binwidth = 3) # binwidth调整组距(柱宽)

# ggplot
ggplot(mtcars, aes(x=mpg)) + geom_histogram(binwidth = 2)

####################################################################################################

# Box Plot

# 普通箱线图
# basic
plot(ToothGrowth$supp, ToothGrowth$len) # x轴为因子型变量，y轴为数值型变量
boxplot(ToothGrowth$len ~ ToothGrowth$supp) # y ~ x

# qplot
qplot(ToothGrowth$supp, ToothGrowth$len, geom = "boxplot")

# ggplot
ggplot(data = ToothGrowth, aes(x = supp, y = len)) + geom_boxplot()

# 分组箱线图
# basic
boxplot(len ~ supp + dose, data = ToothGrowth) # y ~ x1 + x2, 唯一组合(x1, x2)

# qplot
qplot(interaction(supp, dose), len, data = ToothGrowth, geom = "boxplot") # interaction(x1, x2), y

# ggplot
ggplot(data = ToothGrowth, aes(x = interaction(supp, dose), y = len)) + geom_boxplot()

####################################################################################################

# Function Curve

# basic
curve(my_fun(x), from = -100, to = 100) # 注意这里my_fun(x)要传参
# add another curve
curve(1 - my_fun(x), from = -100, to = 100, add = TRUE, col = "blue")

# ggplot
# 画x轴 + add a curve + add another curve
# 注意这里my_fun不要传参; fun只能传函数, 不能做运算
ggplot(data = data.frame(x=c(-100:100)), aes(x=x)) + stat_function(fun = my_fun,  geom = "line") + stat_function(fun = my_fun_2,  geom = "line")
