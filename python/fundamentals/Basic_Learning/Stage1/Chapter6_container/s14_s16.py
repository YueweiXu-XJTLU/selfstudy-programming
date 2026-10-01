# data container - dict
# non-repeatable key (cover); repeatable value
# {key1: value1, key2: value2}

# define
my_dict =  {"A": 1, "B": 2, "C": 3}
print(my_dict, type(my_dict))

# get value
print(my_dict["A"])

# key can not be any changeable data type (list, set, dict), value can be any data type
scores = {"A":
              {"Chinese": 100, "Math": 99}
          }
print(scores["A"]["Math"])

# alter & add
scores["A"]["Math"] = 100 # if have this key alter its value
scores["B"] = {"Chinese": 50, "Math": 55} # if no such key, add one
print(scores)

# remove
scores.pop("B")
print(scores)

# get all keys
keys = my_dict.keys()
print(keys, type(keys))

# iterate
# method 1: manually get all keys
for key in my_dict.keys():
    print(key, ":", my_dict[key])

# method 2: automatically get all keys
for key in my_dict:
    print(key, ":", my_dict[key])