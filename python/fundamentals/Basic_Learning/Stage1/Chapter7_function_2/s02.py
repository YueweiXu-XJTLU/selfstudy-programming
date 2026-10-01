# parameter delivering methods
def user_1(name, age, gender='male'):
    print(f"name: {name}, age: {age}, gender: {gender}")

def user_2(*args):
    print(args, type(args))

def user_3(**kwargs):
    print(kwargs, type(kwargs))

# 1. position
user_1("zhang san", 18, "male")

# 2. keyword (no constrains for order)
user_1(name="li si", age=20, gender="female")

# 3. default (gender in user()) (these variables with default value must at tail of parameter list)
user_1("wang wu", 17)

# 4.1. changeable variables - position changeable delivering (deliver variables as a tuple)
user_2("zhang san", 18)

# 4.2. changeable variables - keyword changeable delivering (deliver variables as a dict)
user_3(name="li si", age=20, gender="female")