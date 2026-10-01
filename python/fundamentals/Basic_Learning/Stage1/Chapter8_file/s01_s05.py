# files
# open files: open("location", "mode", encoding="encoding_format")
# modes:
# r - read
# w - overwrite, if not exist, create file
# a -  append, if not exist, create file
file = open("test_1.txt", "r", encoding="utf-8")
print(type(file))



# close files: close()
file.close()

# auto open
with open("test_1.txt", "r", encoding="utf-8") as file:
    print(type(file))
    # ...



# read files
# read()/read(num): read num_bytes of file, if no num, read whole file
file = open("test_1.txt", "r", encoding="utf-8")
content_whole = file.read()
print(content_whole)
file.close()

file = open("test_1.txt", "r", encoding="utf-8")
content_5_bytes = file.read(5)
print(content_5_bytes)
file.close()

# readline(): read one line
file = open("test_1.txt", "r", encoding="utf-8")
content_line = file.readline()
print(content_line)
file.close()

# readlines(): return a list, each line is an element
file = open("test_1.txt", "r", encoding="utf-8")
content_lines = file.readlines()
print(content_lines)
file.close()

# for loop
for line in open("test_1.txt", "r", encoding="utf-8"):
    print(line)
file.close()



# write into files:
# overwrite
# write() & flush()
file = open("test_2.txt", "w", encoding="utf-8")
file.write("Hello World!\n")
# file.flush()
file.close() # when close(), automatically flush()

# append
file = open("test_2.txt", "a", encoding="utf-8")
file.write("Hello World Again!")
file.close()