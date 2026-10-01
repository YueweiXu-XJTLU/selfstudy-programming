# vector
v <- c(1:10)
v

# length
length(v) # return numnber of element

# calculation
v * v # element-based calculate

# slice
v[1] # !!!!! start from 1 !!!!!
v[1:5] # get index in [1, 5]
v[c(1, 3, 5, 2, 4, 6)] # get index in c(...), order sensitive
v[c(-1, -3, -5, -7, -9)] # get index except for c(...)

# sort
sort(v)
rev(v)
order(v) # 输出排序后各元素对应的原始索引

# statistic
sum(v)
mean(v)
var(v) # sd ^ 2
sd(v)
min(v)
max(v)
range(v) # min & max

# generation
a <- seq(0, 100, 10)
a
b <- seq(0, 100, length.out=3)
b
c <- rep(666, 10) # repeat 666 for 10 times
c

# --------------------------------------------------------------------------------------------------------------

# matrix
v <- seq(1, 6)
row_names <- c('row1', 'row2')
col_names <- c('col1', 'col2', 'col3')
m <- matrix(v, nrow = 2, ncol = 3, byrow = TRUE, dimnames = list(row_names, col_names)) # default: `byrow = FALSE, dimnames = NULL`
m

# length
length(m) # return numnber of elements

# get element(s)
m <- matrix(v, 2, 3)
m[1, 2]
m[1,]
m[,1]

# set row & col names
col_names <- c('col1', 'col2', 'col3')
row_names <- c('row1', 'row2')
colnames(m) <- col_names
rownames(m) <- row_names
m

# calculation
a <- matrix(c(1:3), 1, 3, byrow = TRUE)
b <- matrix(c(4:6), 3, 1, byrow = TRUE)
# multiply
a * a
# dot
a %*% b

# transpose
m_tranpose <- t(m)
m_tranpose

# solve linear equation sets
# x + 2y = 3
# 4x + 2y = 6
A <- matrix(c(1, 2, 4, 2), 2, 2, byrow = TRUE)
b <- c(3, 6)
x <- solve(A, b) # A %*% x = b
x
# find the reverse of a matrix
# A %*% A^-1 = I
A_reverse <- solve(A)
A_reverse

# apply functions to matrix by row/col
m <- matrix(seq(1, 9), 3, 3, byrow = TRUE)
m
apply(m, 1, sum) # 1 means apply by row
apply(m, 2, function(x) any(x > 4)) # 1 means apply by row

# --------------------------------------------------------------------------------------------------------------

# array
# create
arr <- array(data = c(1:24), dim = c(2, 3, 4), dimnames = list(c("row1", "row2"), c("col1", "col2", "col3"),  c("matrix1", "matrix2", "matrix3", "matrix4")))
arr

# get element(s)
arr[1, 2, 3]
arr[1,,4]
arr[c(1, 2), c(1, 3), c(1, 4)] # get element in (row 1 & 2); (col 1 & 3); (matrix 1 & 4)
arr[arr >= 12] # get a vector

# get matrix from array
m <- arr[,,1]

# apply functions to array
arr
apply(arr, c(1), sum) # by dim-1
apply(arr, c(2), sum) # by dim-2
apply(arr, c(3), sum) # by dim-3
apply(arr, c(1, 2), sum) # by dim-1 & dim-2
apply(arr, c(1, 3), sum) # by dim-1 & dim-3
apply(arr, c(2, 3), sum) # by dim-1 & dim-3

# --------------------------------------------------------------------------------------------------------------

# factors
# create factors
sex_data <- c('f', 'f', 'm', 'f', 'm', 'f', NA, 'f', 'm', NA, 'f', 'm')
sex_calssifyication <- factor(sex_data, levels = c('m', 'f'), labels = c('Male', 'Female'), exclude = NA, ordered = TRUE) # `ordered`不是指肉眼观察的有序，是几个level是否创建为有序值
sex_calssifyication

# more detailed explanation
stages <- c("1st", "2nd", "3rd", "4th", "5th")

# default factor (levels are automatically formed using alphabetical order)
stages_factor_1 <- factor(stages)
stages_factor_1

# specify levels (levels are just visual order, not intrinsic order among categories)
stages_factor_2 <- factor(stages, levels = c("5th", "4th", "3rd", "2nd", "1st"))
stages_factor_2

# specify order (give levels intrinsic order, connect categories using `<`) 
# nominal factor --> ordinal factor
stages_factor_3 <- factor(stages, levels = c("5th", "4th", "3rd", "2nd", "1st"), ordered = TRUE)
stages_factor_3
is.ordered(stages_factor_3)

# visualize integer storage
stages_factor_4 <- factor(c("1st", "2nd", "3rd", "4th", "5th", "3rd", "4th", "1st"))
stages_factor_4
as.integer(stages_factor_4)

# --------------------------------------------------------------------------------------------------------------

# levels (want a classification framework without data)
# gl == generate levels
level_1 <- gl(3, 5, labels = c('item1', 'item2', 'item3'), ordered = TRUE) # 3 items, each repeats 5 times
level_1

# --------------------------------------------------------------------------------------------------------------

# list
list_1 <- list(1.234e5, 'word', TRUE, c(1:10)) # list remains original data types for all data
list_1
vector_2 <- c(1.234e5, 'word', TRUE, c(1:10)) # vector converts all data into string if string(s) exists
vector_2

# length
length(list_1)

# name elements of list
names(list_1) <- c("This is a number", "This is a string", "This is a boolean", "This is a vector")
list_1

# get element(s)
list_1[1]
list_1$`This is a number`
# get element in 2nd-level or deeper: use `list[[x]][[y]][[z]]...`
list_1[4]
list_1[[4]]
list_1[[4]][[10]]

# modify elements
list_1[5] <- list(matrix(c(1:9), nrow = 3, byrow = TRUE)) # as a matrix is recognized as n elements, we need to wrap it into a whole using list()
list_1
names(list_1)[5] <- 'This is a matrix' # name(list_1) is a new list, use `names(list_1)[5]` instead of `names(list_1[5])`
list_1

# delete elements
list_1 <- list_1[-5]
# OR
list_1[5] <- NULL
list_1

# merge
list_3 <- list('element in list_3')
merged_list <- c(list_3, list_1)
merged_list
# !!! 注意上面的c()合并df时会把df展开为数据, 用下面的方法合并整个object !!!
merged_list[["new element"]] <- list_1 # 一定要[[]], 选中element本身
str(merged_list)

# iterate - 1
for (element in list_1) {
  print(element) # `element` is just a temporary variable, not the direct element in the list
}

# iterate - 2
lapply(list_1, function(x) print(x))

# list -> vector
merged_vector <- unlist(merged_list)
merged_vector

# --------------------------------------------------------------------------------------------------------------

# data frame
# create df
df_1 <- data.frame(emp = c("emp1", "emp2"), formal = c(FALSE, TRUE), salary = c(1000, 1500), row.names = NULL)
df_1

# row/col number
ncol(df_1)
nrow(df_1)

# get summary
summary(df_1)

# get partial info
data.frame(df_1$salary)
df_1[1] # same as `df_1[, 1]`, omit comma is permitted
df_1[[1]] # get col1 as a vector (only values)
df_1[1:2,]
df_1[c(1, 2), c(1, 3)]

# retrival (like SELECT in SQL)
subset(df_1, salary > 1000 & formal == TRUE)

# add col
df_1$gender <- c('m', 'f')
df_1

# bind with vector
# col-bind: cbind()
age <- c(29, 26) # new col
df_2 <- cbind(df_1, age)
df_2
# row-bind/; rbind()
emp3 <- data.frame(emp = "emp3", formal = TRUE, salary = 2000, gender = 'm', age = 40) # use `data.frame()` instead of `c()` to avoid data type casting
df_3 <- rbind(df_2, emp3)
df_3

# merge dfs (like JOIN tables in SQL)
df1 <- data.frame(SiteId = c(1:6), Site = c("Google", "Runoob", "Taobao", "Facebook", "Zhihu", "Weibo"))
df2 <- data.frame(SiteId = c(2, 4, 6, 7, 8), Country = c("CN","USA","CN","USA","IN"))
df1
df2
# NATURAL JOIN
df3 <- merge(x = df1, y = df2, by = 'SiteId')
df3
# INNER JOIN
df4 <- merge(x = df1, y = df2, by.x = 'SiteId', by.y = 'SiteId')
df4
# FULL JOIN
df5 <- merge(x = df1, y = df2, by = 'SiteId', all = TRUE)
df5
# LEFT OUTER JOIN
df6 <- merge(x = df1, y = df2, by = 'SiteId', all.x = TRUE)
df6
# RIGHT OUTER JOIN
df7 <- merge(x = df1, y = df2, by = 'SiteId', all.y = TRUE)
df7
# other params
# `sort`: sort by `by` col
# `no.dups`: don't allow duplicated cols after merging
# `suffixs`: give suffixes to duplicated cols after merging
df8 <- merge(x = df1, y = df2, by = 'SiteId', sort = TRUE, no.dups = TRUE, suffixes = c('.x', '.y'))
df8

# long format (1 row ~ 1 object) <-> wide format (1 row * 1 col ~ 1 object)
# install.packages("MASS", repos = "https://mirrors.ustc.edu.cn/CRAN/")
# install.packages("reshape2", repos = "https://mirrors.ustc.edu.cn/CRAN/")
# install.packages("reshape", repos = "https://mirrors.ustc.edu.cn/CRAN/")
library(MASS)
library(reshape2)
library(reshape)
df_original <- data.frame('ID' = c(1, 2, 3), 'Name' = c('Tom', 'Ann', 'Lee'), 'Score1' = c(90, 85, 78), 'Score2' = c(92, 88, 80))

# melt 整合: wode format -> long format
# `id`: cols that not change
# `variable.name`&`value.name`: col names for melted variables&values
# `na.rm`: remove NA
df_long <- reshape2::melt(df_original, id.vars = c('ID', 'Name'), variable.name = 'Score_Index', value.name = 'Score', na.rm = FALSE)
# colnames(df_long) <- c("col1", "col2", ...)

# cast 拆分: long format -> wide format
# `dcast`: output a data frame
# `acast`: output an array
# `formula = A+B~C+D`: (A, B)组合，(C, D)组合，输出结果每行为一个(A, B)，每列为一个(C, D)
# `value.var = "Score"`: 输出结果每个单元格内填充的数据
# `fun.aggregate` 对value.var使用聚合函数
df_wide_1 <- reshape2::dcast(df_long, formula = ID+Name~Score_Index, value.var = "Score")
df_wide_1
df_wide_2 <- reshape2::dcast(df_long, formula = Score_Index~1, value.var = "Score", fun.aggregate = mean)
colnames(df_wide_2)[2] <- 'Class_Average_Score'
df_wide_2
arr_wide_3 <- reshape2::acast(df_melt, formula = Score_Index~1, value.var = "Score", fun.aggregate = mean)
str(df_wide_3)



##################################################
# apply家族函数
# 函数;       主要处理对象;               输出类型;                   典型用途
# apply();    矩阵（matrix）或数据框;     向量或矩阵;                 对矩阵的行或列应用函数
# lapply();   列表（list）或向量;         列表 (list);                对每个元素应用函数，结果保留为 list
# sapply();   列表（list）或向量;         简化结果（vector/matrix;    对每个元素应用函数，并尽可能简化结构
# vapply();   列表或向量;                 严格定义输出类型;           类似 sapply()，但更安全（必须指定输出类型）
# tapply();   向量 + 分组因子;            向量或数组;                 按组应用函数（常用于分组统计）
# mapply();   多输入向量;                 向量或列表;                 对多个输入同时应用函数（多变量版本）
# rapply();   嵌套列表（recursive list;   向量或列表;                 递归地对每个元素应用函数
