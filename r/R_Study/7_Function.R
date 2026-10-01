# define functions
divide_numbers <- function (x = 12, y = 2) {
  result <- x / y
  return(result)
}

# invoke functions
rs <- divide_numbers(555, 111) # give parameters by order
rs

rs <- divide_numbers(y = 555, x = 111) # give parameters by keywords
rs

rs <- divide_numbers() # use default parameters
rs
