
# basic calculation operators
# 10 / 3 = 3 ... 1
print(10 %% 3)  # 1
print(10 %/% 3) # 3

# logical comparison operators
print(1 == 1)
print(1 != 1)
print(1 == 1 && 1 != 1)
print(1 == 1 || 1 != 1)

# special operators
# : - range
v <- 1:10
print(v)
# %in% - is in
print(1 %in% v)
print(11 %in% v)
# %*% - dot matrices
A <- matrix(c(1, 2, 3, 4), nrow=2)
print(A %*% A)

# math functions
print(sqrt(4356) - exp(0) + log(2, 64) * log10(10000) + sin(pi/2) + asin(0))

# round methods
print(round(987.654))
print(round(987.654, 2)) # remain 2 digits
print(ceiling(987.654))
print(floor(987.654))

# normal distribution
# 计算正态分布在某点x处的概率密度值（查看分布曲线在某点的高低）
dnorm(0, mean=0, sd=1)
# 计算正态分布在某点q左侧的累计概率（即P(X ≤ q)）
pnorm(0, mean=0, sd=1)
# 已知概率p，反推出对应的分位点（即P(X ≤ x) = p时的x）
qnorm(0.95, mean=0, sd=1)
# 随机生成 n 个服从指定正态分布的随机数
rnorm(100, mean=0, sd=1)
