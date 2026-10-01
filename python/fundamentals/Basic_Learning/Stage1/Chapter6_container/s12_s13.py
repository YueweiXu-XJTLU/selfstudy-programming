# data container - set
# not sequential, not repeatable

# define
my_set = {1, 2, 3, 3, "3"}
print(my_set, type(my_set))

# add
my_set.add(4)
print(my_set)

# remove
my_set.remove("3")
print(my_set)

# set operations
set1 = {1, 2, 3}
set2 = {2, 3, 4}

set3 = set1.difference(set2)
print(set3) # {1}

set1.difference_update(set2)
print(set1) # {1}
print(set2) # {2, 3, 4}

set4 = set1.union(set2)
print(set4) # {1, 2, 3, 4}