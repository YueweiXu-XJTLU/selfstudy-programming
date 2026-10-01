# verdict
# if
x <- 1000
if (x < 100) {
  cat(x, "< 100")
} else if (x > 100000) {
  cat(x, "> 100000")
} else {
  cat("100 < ", x, " < 100000")
}

# switch
option_to_choose <- 2
x <- switch (option_to_choose, "option_1", "option_2", "option_3")
x # "option_2"

option_to_choose <- 8
x <- switch (option_to_choose, "option_1", "option_2", "option_3")
x # NULL

chars_to_match <- "baidu"
y <- switch (chars_to_match, baidu = "www.baidu.com", taobao = "www.taobao.com", "www.google.com") # give parameters by keywords, allow one default value without keyword
y # "www.baidu.com"

chars_to_match <- "jingdong"
y <- switch (chars_to_match, baidu = "www.baidu.com", taobao = "www.taobao.com", "www.google.com") # give parameters by keywords, allow one default value without keyword
y # "www.google.com"

# loop
# repeat
i <- 10
repeat {
  print(i)
  i <- i - 1
  if (i <= 0) {
    break
  }
}

# while
i <- 10
while (i > 0) {
  print(i)
  i <- i - 1
}

# for
for (i in c(10:1)) {
  print(i)
}

# break & next
i = 100
while (TRUE) {
  if (i < 0) {
    break
  }
  
  if (i %% 10 != 0) {
    i <- i - 1
    next
  }
  
  print(i)
  i <- i - 1
}
