library("ggplot2")
library("gcookbook")

tophit <- tophitters2001[1:25, ]

##### Cleveland's Dot Plot (克利夫兰点图) #####
ggplot(tophit, aes(x = avg, y = reorder(name, -avg), colour = lg)) + # 排序
  geom_point(size = 3) + # 修改点的大小
  theme_bw() + # 主题
  theme( # 网格/图例
    panel.grid.major = element_blank(), 
    panel.grid.minor = element_blank(), 
    legend.position = c(0.99, 0.99), 
    legend.justification = c(1, 1)
  ) + 
  scale_color_brewer(palette = "Set2") + # 填色
  geom_segment(aes(x = 0.31, xend = avg), color = "black", linetype = "solid") + # 截线
  geom_segment(aes(y = 0, yend = name), color = "grey80", linetype = "dashed") # 截线
  
# 先分类, 再排序, 再画图
tophit$name <- factor(tophit$name, levels = tophit$name[order(tophit$lg, tophit$avg)])

ggplot(tophit, aes(x = avg, y = name, colour = lg)) + # 排序
  geom_point(size = 3) + # 修改点的大小
  theme_bw() + # 主题
  theme( # 网格/图例
    panel.grid.major = element_blank(), 
    panel.grid.minor = element_blank(), 
  ) + 
  scale_color_brewer(palette = "Set2") + # 填色
  geom_segment(aes(x = 0.31, xend = avg), color = "black", linetype = "solid") + # 截线
  geom_segment(aes(y = 0, yend = name), color = "grey80", linetype = "dashed") # 截线

##### 分块/Sub Plot #####
# facet_grid(x~y, scales = "free_y", space = "free_y")
# 作x行y列, 给个格子放一张sub-plot; “.”代表多行/列
# scales = "free_y": 调整分块内布局
# space = "few_y": 调整分块间布局
ggplot(tophit, aes(x = avg, y = name, colour = lg)) + # 排序
  geom_point(size = 3) + # 修改点的大小
  theme_bw() + # 主题
  theme( # 网格/图例
    panel.grid.major = element_blank(), 
    panel.grid.minor = element_blank(), 
  ) + 
  scale_color_brewer(palette = "Set2") + # 填色
  geom_segment(aes(x = 0.31, xend = avg), color = "black", linetype = "solid") + # 截线
  geom_segment(aes(y = 0, yend = name), color = "grey80", linetype = "dashed") + # 截线
  facet_grid(lg~., scales = "free_y", space = "free_y")

# facet_wrap(a ~ b): 做a行b列的矩阵, 每格放一张小图
p <- ggplot(mpg, aes(displ, hwy)) + geom_point()
# facet_wrap
p + facet_wrap(drv ~ cyl)
# facet_grid
p + facet_grid(drv ~ cyl)
