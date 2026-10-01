# CSV File
# read
test_csv <- read.csv("test.csv", encoding = "UTF-8")
test_csv

# use
# use as df
summary(test_csv)
retrival <- subset(test_csv, ANNO == "WCc")

# write
write.csv(retrival, "test_subset.csv", row.names = FALSE) # do not need row names added by R

# ----------------------------------------------------------------------------------------------------

# Excel File
# install.packages("xlsx", repos = "https://mirrors.ustc.edu.cn/CRAN/")
library("xlsx")

# read
test_xlsx <- read.xlsx("test.xlsx", sheetIndex = 1)
test_xlsx

# ----------------------------------------------------------------------------------------------------

# XML File
# install.packages("XML", repos = "https://mirrors.ustc.edu.cn/CRAN/")
library("XML")

# read
# as xml
test_xml <- xmlParse("test.xml")
test_xml
# as list
test_xml_list <- xmlToList("test.xml")
test_xml_list
# as df
test_xml_dataframe <- xmlToDataFrame("test.xml")
test_xml_dataframe

# use
# get root nodes
rootnode <- xmlRoot(test_xml)
rootnode
# get size (number) of nodes
rootsize <- xmlSize(rootnode)
rootsize
# get data
# get node1
rootnode[1]
#get node1 - data2
rootnode[[1]][[2]]
test_xml_list[[1]][[2]]
test_xml_dataframe[1]

# ----------------------------------------------------------------------------------------------------

# JSON File
# install.packages("rjson", repos = "https://mirrors.ustc.edu.cn/CRAN/")
library("rjson")

# read
test_json <- fromJSON(file = "test.json")
test_json

# use
# cast list into df
test_json_dataframe <- as.data.frame(test_json)
# get element(s)
test_json[2]
test_json[[2]][[1]]
test_json_dataframe[1, 2]
