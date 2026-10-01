# fonts
# install.packages("showtext", repos = "https://mirrors.ustc.edu.cn/CRAN/")
library("showtext")

# --------------------

# system fonts

# Linux 字体在 `/usr/share/fonts` 下，用 `fc-list` 命令查看
# Windows 字体在 `C:\Windows\Fonts\` 文件下
# mac OS 字体在 `/System/Library/Fonts` 和 `/Library/Fonts` 目录下

# check all sytem fonts
font_files()

# --------------------

# register fonts

# show all registered files
font_families()

# register fonts into R: `font_add(alia, path)`
# system fonts
font_add("heiti", "C:/Windows/Fonts/simhei.ttf")

# cusomized fonts
# unload font packages: .ttf/.otf (more advanced .ttf)
# eg: 思源黑体 (from Abobe and Google): https://source.typekit.com/source-han-serif/cn/
# we choose: SourceHanSerifSC-Bold.oft, just put it in the project directory
font_add("SyHei", "SourceHanSerifSC-Bold.otf")

# --------------------

# use fonts
showtext_auto()

# ----------------------------------------------------------------------------------------------------

# basic plot

# data
sigmoid <- function (x) {
  result <- 1 / (1 + exp(x))
  return(result)
}
x <- seq(0, 10, 0.1)
y <- sigmoid(x)

# plot
# type:
  # p：点图
  # l：线图
  # b：同时绘制点和线
plot(
  x, y,
  xlim = c(-5, 15),
  xlab = "x label", ylab = "y label",
  type = "o",
  main = "Plot",
  col = 'red',
)

# legend
legend(x = "topright", legend = "y = sigmoid(x)", cex = 0.8, bty = 'o', lty = 2, col = "red")

# ----------------------------------------------------------------------------------------------------

# pie plot

# data
data <-  c(1, 2, 4, 8)
labels_1 <- c("Google", "Runoob", "Taobao", "Weibo")
labels_2 <- paste(round(100 * data/sum(data)), '%')
labels <- paste(labels_1, labels_2, sep = ": ")
colors <- c("#ED1C24","#22B14C","#FFC90E","#3f48CC")
borders <- c("red", "blue", "green", "black")

# prepare
dev.new()
showtext_auto()
png(file="test_pie.png", height = 800, width = 800)
# jpeg(file="test_pie.jpeg", height = 800, width = 800)
# pdf(file="test_pie.pdf", height = 800, width = 800)
# svg(file="test_pie.svg", height = 800, width = 800)

# plot
# x: 数值，每个扇形的面积
# labels: 设置各扇形面积标签
# edges: 设置多边形（圆饼）的边数
# radius: 设置饼图的半径
# main: 设置饼图的标题
# clockwise: 按顺时针做分割
# angle: 设置底纹的斜率
# density: 设置底纹的密度，默认值为 NULL（填充色块）
# init.angle: 设置第一个数据扇形的左边界（起始）角度，默认90（从正上方开始）
# col: 设置每个扇形的颜色
# border: 设置饼图每个扇形（sector）的边框颜色
# lty: 设置扇形边界的线型
  # 1 或 "solid"：实线（默认）
  # 2 或 "dashed"：虚线
  # 3 或 "dotted"：点线
  # 4 或 "dotdash"：点划线
  # 5 或 "longdash"：长虚线
  # 6 或 "twodash"：双划线
# family: 设置字体
pie(
  data,
  labels = labels,
  edges = 200,
  radius = 1,
  main = "网站投票",
  clockwise = TRUE,
  angle = 45,
  density = NULL,
  init.angle = 0,
  col = colors,
  border = borders,
  lty = c(1,2,3,4),
  family = "SyHei"
)

# legend
# x: 设置图例位置（如 "topright"、"bottomleft"、"center"、坐标对等）
# legend: 设置图例内容
# cex: 设置图例字体缩放倍数
# fill: 设置图例前面的色块颜色
# border: 设置色块边框颜色
# bty: 设置图例边框（"o"为有，"n"为无）
legend(x = "topright", legend = labels_1, cex = 0.8, fill = colors,  border = "red", bty = 'o')

# close output stream
dev.off()

# 3D pie chart
# install.packages("plotrix", repos = "https://mirrors.ustc.edu.cn/CRAN/")
library("plotrix")
dev.new()
showtext_auto()
# start: 设置起始角度（以弧度为单位）（替代pie()的init.angle）
# explode: 设置每个扇形分离程度
# height: 设置饼图的厚度
# theta: 设置饼图倾斜角度
# labelcex: 设置标签字体大小
# mar: 设置图像边距，调整整个图片留白
png(file="test_pie_3D.png", height = 800, width = 800)
pie3D(
  data,
  labels = labels,
  main = "网站投票",
  start = 0,
  col = colors,
  border = "black",
  lty = c(1,2,3,4),
  family = "SyHei",
  explode = 0.1,
  height = 0.1,
  theta = pi/6,
  labelcex = 1,
  mar = c(4,4,4,4),
)
legend(x = "topright", legend = labels_1, cex = 0.8, fill = colors,  border = "red", bty = 'o')
dev.off()

# ----------------------------------------------------------------------------------------------------

# bar plot

# data
data <- matrix(c(83017, 83534, 1794546, 2640626, 190535, 585493), 2, 3)
colnames(data) <- c("中国", "美国", "印度")
rownames(data) <- c("6月", "7月")

# prepare
dev.new()
showtext_auto()
png(file="test_bar_beside.png", height = 800, width = 800)
# jpeg(file="test_bar.jpeg", height = 800, width = 800)
# pdf(file="test_bar.pdf", height = 800, width = 800)
# svg(file="test_bar.svg", height = 800, width = 800)

# plot
# height: 向量或矩阵，每个数值表示矩形条的高度
# xlab & ylab: 坐标轴轴标签
# names.arg: 每个bar的名称
# beside: 控制条形图是堆积还是并列
# legend: 自动图例
barplot(height = data,
        xlab = "国家",
        ylab = "人数",
        names.arg = c("中国","美国","印度"),
        beside = FALSE,
        legend = TRUE,
        main = "新冠疫情条形图",
        col = c("#ED1C24","#22B14C"),
        family = "SyHei"
)

# close output stream
dev.off()

# `beside = FALSE`
showtext_auto()
png(file="test_bar_stack.png", height = 800, width = 800)
barplot(height = data,
        xlab = "国家",
        ylab = "人数",
        names.arg = c("中国","美国","印度"),
        beside = FALSE,
        legend = TRUE,
        main = "新冠疫情条形图",
        col = c("#ED1C24","#22B14C"),
        family = "SyHei"
)
dev.off()

# ----------------------------------------------------------------------------------------------------

# curve plot

# prepare
dev.new()
showtext_auto()
png(file="test_curve.png", height = 800, width = 800)
# jpeg(file="test_curve.jpeg", height = 800, width = 800)
# pdf(file="test_curve.pdf", height = 800, width = 800)
# svg(file="test_curve.svg", height = 800, width = 800)

# plot
# expr = sin(x): expresion/function
# n = 101: sample-dot numbers in the graph (larger n ~ smoother line)
# from = 0 & to = 2*pi: domain
# xlab = "x (rad)", y= "y = sin(x)": x/y axes label names
# xlim, ylim = c(lower_bound, upper_bound): x/y axes limits
# axes = TRUE: 显示坐标轴及边框
# add = TRUE: add this line into previous canvas
# type = 'b': line type:
  # p：点图
  # l：线图
  # b：同时绘制点和线
  # c：仅绘制参数 b 所示的线
  # o：同时绘制点和线，且线穿过点
  # h：绘制出点到横坐标轴的垂直线
  # s：阶梯图，先横后纵
  # S：阶梯图，先纵后竖
  # n： 空图
# pch: 点型
  # 0: 方框
  # 1: 圆圈
  # 2: 上三角
  # 3: 加号
  # 4: 叉号
  # 5: 菱形
  # 6: 下三角
  # 7: 实心正方形
  # 8: 星号
  # 9: 菱形加竖线
  # 10: 加号菱形
  # 16: 实心圆
  # 17: 实心上三角
  # 15: 实心方块
  # 18: 菱形实心
# log = 'x'/'y'/'xy': (x/y/x&y must strictly > 0)
curve(
  expr = sin(x) + 2,
  n = 101,
  from = 0, to = 2*pi,
  xlab = "x label", y= "y label",
  xlim = c(-1, 10), ylim = c(0.5, 3),
  axes = TRUE,
  add = FALSE,
  type = 'p',
  pch = 2,
  log = 'y',
  main = "Curve Plot",
  family = "SyHei",
  col = "blue"
)

# legend
# col: 图例线条/点的颜色
# lty: 线型
  # 1: 实线
  # 2: 虚线
  # 3: 点线
  # 4: 点划线
  # 5: 长划线
  # 6: 双点划线
# pch: 点型
legend(x = "topright", legend = "y = sin(x)", cex = 0.8, bty = 'o', col = "blue", lty = 2, pch = 2)

# close output stream
dev.off()

# ----------------------------------------------------------------------------------------------------

# pairs matrix (散点图矩阵)
# 一个大的图形方阵:
  # 每一个非主对角元素的位置上是对应行的变量与对应列的变量的散点图
  # 主对角元素位置上是各变量名
# 展示多个变量两两之间的相关关系（关于主对角线对称的每两张图互为镜像）

# data
n <- 50
height <- rnorm(n, mean = 170, sd = 7)
age <- sample(20:50, n, replace = TRUE)
weight <- height * 0.4 + rnorm(n, mean = 0, sd = 5)
group <- sample(c("A", "B"), n, replace = TRUE)
df <- data.frame(
  height = round(height, 1),
  weight = round(weight, 1),
  age = age,
  group = group
)
cols <- ifelse(df$group == "A", "blue", "red") # 三元运算符

# prepare
dev.new()
showtext_auto()
png(file="test_pairs.png", height = 800, width = 800)
# jpeg(file="test_pairs.jpeg", height = 800, width = 800)
# pdf(file="test_pairs.pdf", height = 800, width = 800)
# svg(file="test_pairs.svg", height = 800, width = 800)

# plot
# formular = ~var1 + var2 + ...: 研究的变量（主对角线上的变量）
# data = df: 输入数据
pairs(
  ~height + weight + age,
  data = df,
  main = "Scatterplot Matrix",
  pch = 16,
  col = cols,
  family = "SyHei"
)

# close output stream
dev.off()
