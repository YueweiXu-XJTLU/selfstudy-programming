# data container - str
# define
str = "python study"

# query
print(str[-1])
print(str.index(" "))
print(str.count("python"))

# str is non-modifiable:

# replace
new_str = str.replace("python", "java")
print(new_str)

# split
str_list = str.split(" ")
print(str_list)

# strip
str = "  python study pythonpy  \n "
print(str.strip().strip("python")) # (): remove space & \n in head and tail; (str): split str to char, remove every char appear in head and tail

# exercise
str = "Basic_Learning itcast boxuegu"
print(str.count("it"))
print(str.replace(" ", "|"))
print(str.split(" "))