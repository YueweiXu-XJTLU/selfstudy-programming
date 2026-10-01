library("ggplot2")
library("gcookbook")
library("plyr")
pg_mean <- pg_mean
cabbage_exp <- cabbage_exp
upc <- subset(uspopchange, rank(Change)>40)
csub <- subset(climate, Source == "Berkeley" & Year >= 1900)

# Bar Plot

##### 基础 #####
# 计数方式: stat: count自动计数频次; identity直接画y轴指定的数据
# 分组位置: position: identity前后图层重叠; stack按绝对数值上下堆叠; fill按比例上下堆叠; dodge各柱分开



##### 调色 #####
# 修改填充: fill: scale_fill_brewer(palette = "...") / scale_fill_manual(values = c(...))
# 修改描边: color: scale_color_brewer(palette = "...") / scale_color_manual(values = c(...))
# guide = FALSE: 不画图例
RColorBrewer::display.brewer.all() # 查看调色板

ggplot(pg_mean, aes(x = group, y = weight)) + geom_bar(stat = "identity", fill = "lightblue", color = "blue")

# 分行写命令“+”放在本行结尾处
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar, color = Cultivar)) + # 横轴放Date(分组), 纵轴画Weight(identity), 每组内fill Cultivar,  每组内color Cultivar 
  geom_bar(stat = "identity", position = "dodge") +
  scale_fill_brewer(palette = "YlGnBu", limits = c("c52", "c39"), guide = FALSE) + # 按系列调色板填充柱子内部, limits设定颜色应用顺序
  scale_color_brewer(palette = "Reds", limits = c("c52", "c39"), guide = FALSE) # 按系列调色板填充柱子边框



##### 分组 #####
# 按柱子值大小排序: aes(x = reorder(a, ±b)): 按照b的大小排序a的柱子, ±b指定升序/降序
ggplot(upc, aes(x = reorder(Abb, -Change), y = Change, fill = Region, color = Region)) + 
  geom_bar(stat = "identity", position = "dodge") + 
  scale_fill_manual(values = c("red", "blue")) +
  scale_color_manual(values = c("blue", "red"))

# 按柱子值正负填充: 创建新的一列逻辑变量, 按该逻辑变量填充
csub$isPositive <- csub$Anomaly10y > 0
ggplot(csub, aes(x = Year, y = Anomaly10y, fill = isPositive)) + 
  geom_bar(stat = "identity", position = "dodge")



##### 柱宽 #####
# width = ...: default = 0.9, max = 1: 代表 第n根柱子左边 到 第n根柱子右边 的距离
ggplot(pg_mean, aes(x = group, y = weight)) + geom_bar(stat = "identity", width = 1)

# 分组时的组内柱子间距调整
# position = position_dodge(...): default = width: 代表 第n根柱子右边 到 第(n+1)根柱子右边 的距离
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar, color = Cultivar)) +
  geom_bar(stat = "identity", position = position_dodge(-0.3), width = 0.5)



##### 堆积柱状图 #####
# 更改图例色框上下顺序: guides(fill = guide_legend(reverse = TRUE))
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "stack", width = 0.5) +
  guides(fill = guide_legend(reverse = TRUE))

# 更改同柱中堆积的上下顺序: 更改原数据集中的因子水平: data_set$col <- factor(data_set$col, level = c("...", "..."))
cabbage_exp$Cultivar <- factor(cabbage_exp$Cultivar, level = c("c52", "c39"))
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "stack", width = 0.5)



##### 调整坐标轴范围 ####
# ylim(a, b) : from a to b
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  ylim(0, max(cabbage_exp$Weight) * 1.1)



##### 标签 #####
# geom_text(aes(label = a), position = position_dodge(b), vjust = c, color = "...", size = ...)
# a: 标签的具体内容
# b: 标签的水平位置: 同组内不同柱子对应标签间的距离, 与geom_bar/width一致即可
# c: 标签的垂直位置(相对): 0代表 文字下边缘 与 柱子上边缘 重叠, 1代表 文字上边缘 与 柱子上边缘 重叠: b越小标签位置越往上
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  geom_text(aes(label = paste(Weight, "kg")), position = position_dodge(0.8), vjust = -0.5, color = "black", size = 2)

# geom_text(aes(y = d, label = a), position = position_dodge(b), color = "...")
# d: 标签的垂直位置(绝对): 给定一个y轴对应的值, 将标签的中心置于该值处, y轴范围将自动调整 
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  geom_text(aes(y = Weight + 0.1, label = Weight), position = position_dodge(0.8), color = "black")

# 堆积图标签: 用plyr预处理数据集
ce <- arrange(cabbage_exp, Date, Cultivar) # 按Date then Cultivar的顺序重新排序
ce <- ddply(ce, "Date", transform, label_y=cumsum(Weight)) # 对ce操作, 用“Date”分类, 做列操作(transdorm), 添加一列label_y, cumsum(cumulative sum)用于做累加
# ggplot针对因子水平画图, 以上均为修改下, 下面一行进行因子操作
ce$Cultivar <- factor(ce$Cultivar, levels = c("c52", "c39"))
# 用label_y做绝对水平位置, 画图即可
ggplot(ce, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "stack", width = 0.8) + 
  geom_text(aes(y = label_y - 0.15, label = Weight), color = "black")
# OR
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "stack", width = 0.8) + 
  geom_text(aes(label = Weight), color = "black", position = position_stack(vjust = 0.9))


##### 主题 #####
# theme_...()

#	theme_gray()（默认）
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  theme_grey()

# theme_bw()（黑白风格，去掉灰背景）
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  theme_bw()

# theme_linedraw()（线条较细）
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  theme_linedraw()

# theme_light()（浅色背景）
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  theme_light()

# theme_dark()（深灰背景，适合深色系展示）
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  theme_dark()

# theme_minimal()（极简，只有坐标轴）
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  theme_minimal()

# theme_classic()（经典风格，没有网格，只有轴线）
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  theme_classic()

# theme_void()（空白主题，完全去掉坐标轴、背景、网格）
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  theme_void()


##### 底纹/网格 #####
#theme(
#  panel.grid.major = element_blank(),  # 去掉主网格线
#  panel.grid.minor = element_blank()   # 去掉次网格线
#)
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  theme(
    panel.grid.major = element_blank(), # 去掉主网格线
    panel.grid.minor.x = element_blank(), # 去掉x = m次网格线
    panel.grid.major.y = element_line(colour = "black", linetype = "dashed") # 设置y = n主网格线颜色&样式
  )

# 样式: "solid", "dashed", "dotted", "dotdash", "longdash", "twodash"
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  theme(
    panel.grid.major = element_blank(), # 去掉主网格线
    panel.grid.minor.x = element_blank(), # 去掉x = m次网格线
    panel.grid.major.y = element_line(colour = "black", linetype = "solid") # 设置y = n主网格线颜色&样式
  )

ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  theme(
    panel.grid.major = element_blank(), # 去掉主网格线
    panel.grid.minor.x = element_blank(), # 去掉x = m次网格线
    panel.grid.major.y = element_line(colour = "black", linetype = "dashed") # 设置y = n主网格线颜色&样式
  )

ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  theme(
    panel.grid.major = element_blank(), # 去掉主网格线
    panel.grid.minor.x = element_blank(), # 去掉x = m次网格线
    panel.grid.major.y = element_line(colour = "black", linetype = "dotted") # 设置y = n主网格线颜色&样式
  )

ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  theme(
    panel.grid.major = element_blank(), # 去掉主网格线
    panel.grid.minor.x = element_blank(), # 去掉x = m次网格线
    panel.grid.major.y = element_line(colour = "black", linetype = "dotdash") # 设置y = n主网格线颜色&样式
  )

ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  theme(
    panel.grid.major = element_blank(), # 去掉主网格线
    panel.grid.minor.x = element_blank(), # 去掉x = m次网格线
    panel.grid.major.y = element_line(colour = "black", linetype = "longdash") # 设置y = n主网格线颜色&样式
  )

ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  theme(
    panel.grid.major = element_blank(), # 去掉主网格线
    panel.grid.minor.x = element_blank(), # 去掉x = m次网格线
    panel.grid.major.y = element_line(colour = "black", linetype = "twodash") # 设置y = n主网格线颜色&样式
  )



##### 图例 #####
# theme(legend.justification = c(..., ...), legend.position = c(..., ...)): 
# legend.justification = c(..., ...): 指定图例的参考点
# legend.position = c(..., ...): 指定图例参考点与图中哪个点对齐
# 以上两个位置均为相对位置, 如(0, 0)指左下角, (1, 1)指右上角, (0.5, 0.5)指中心点
ggplot(cabbage_exp, aes(x = Date, y = Weight, fill = Cultivar)) +
  geom_bar(stat = "identity", position = "dodge", width = 0.8) + 
  theme(
    legend.justification = c(1, 1), 
    legend.position = c(1, 1), 
  )



##### 截线 #####
# geom_segment(aes(x = ..., xend = ..., y = ..., yend = ...), color = ..., linetype = ...)
ggplot(tophit, aes(x = avg, y = reorder(name, -avg), colour = lg)) +
  geom_point(size = 3) +
  geom_segment(aes(x = 0.31, xend = avg), color = "black", linetype = "solid") +
  geom_segment(aes(y = 0, yend = name), color = "grey80", linetype = "dashed")
