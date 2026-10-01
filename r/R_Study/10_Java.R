# 将java于R连接, 使用R作为计算工具, 如高效计算逆矩阵
# install.packages("Rserve", repos = "https://mirrors.ustc.edu.cn/CRAN/")
library("Rserve")

# 在`YOUR_RSERVE_LIBRARY_PATH`里找到两个jar文件(REngine.jar & Rserve.jar)
# 把这两个jar作为java的lib加载

# 启动Rserve
Rserve()