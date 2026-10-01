# input
# read files by lines
file_contents <- readLines("0_Pre-knowledge.R")

# output
# directly output
print(5e-2)

# concatenate string & output
cat(1, "+", 2, "=", 1+2)

# output into files
cat("# This is an appended line by cat()!", file = "1_Basic.R", append = TRUE)

# output into file NO(split = FALISE)|AND(split = TRUE) console
sink("1_Basic.R", append = TRUE, split = TRUE)
print("# This is an appended line by sink()!")
# cancel former sink(...)
sink()
