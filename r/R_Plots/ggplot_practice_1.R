library("ggplot2")
mpg <- mpg

##### Pie Chart Shaped Bar Chart #####
ggplot(mpg, aes(class, fill = drv)) + 
  geom_bar() + 
  coord_polar(theta = "y") # 将y轴作θ, 极坐标化扭曲 (默认原最高的柱子扭曲后正好填满一圈)

ggplot(mpg, aes(class, fill = drv)) + 
  geom_bar() +
  coord_polar(theta = "x") # 将x轴作θ, 极坐标化扭曲 (用扇形高度表示值, 不由圆心角表示)



##### True Pie Chart #####
# 把所有柱子堆在一起, 统一按y轴扭曲即可
ggplot(mpg, aes(x = 1, fill = class)) + 
  geom_bar(position = "stack") + 
  coord_polar(theta = "y") + 
  geom_text(stat = "count", aes(label = scales::percent(..count../100)), size = 3, position = position_stack(vjust = 0.5))

ggplot(mpg, aes(x = 1, fill = class)) + 
  geom_bar(position = "stack") + 
  coord_polar(theta = "y") + 
  # 使用scales包中的percent函数格式化小数为百分数
  # position = position_stack(vjust = ...) 可以直接调整每个标签在堆叠中的位置: 0指标签中心在柱底线, 1指标签中心在柱顶线
  geom_text(stat = "count", aes(label = scales::percent(..count../sum(..count..))), size = 3, position = position_stack(vjust = 0.5)) +
  theme(
    panel.grid = element_blank(), # 去掉坐标轴
    axis.text = element_blank(), # 去掉坐标轴数字
    axis.ticks = element_blank(), # 去掉y轴刻度
  ) +
  theme_void() # 去除背景色
  labs(
    title = NULL,
    x = NULL,
    y = NULL
  )
