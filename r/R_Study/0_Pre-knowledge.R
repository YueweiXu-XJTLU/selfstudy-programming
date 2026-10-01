# annotation

# shortcut keys
# `Ctrl + L` clear console
# `Ctrl + Up_Arrow` history cmd

# work directory
setwd(dir = "YOUR_WORKING_DIRECTORY")
getwd()

# show files under current directory
list.files()
# OR
dir()

# packages
# install directory of packages
.libPaths()
# installed packages
library()
# libraried packages
search()
# install packages (using specified repository)
install.packages("pkgs", repos = "https://mirrors.ustc.edu.cn/CRAN/")
# library packages
library("pkgs")
# remove packages
remove.packages("pkgs")