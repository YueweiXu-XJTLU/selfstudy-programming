# sort

# sorted()
my_list = [["B", 33], ["A", 55], ["C", 11]]
print(sorted(my_list)) # sort using 0-th element (unmodifiable)

# list.sort(key=function, reverse=True|False)
my_list.sort(key=lambda x:x[1], reverse=False) # sort using n-th element (modifiable)
print(my_list)