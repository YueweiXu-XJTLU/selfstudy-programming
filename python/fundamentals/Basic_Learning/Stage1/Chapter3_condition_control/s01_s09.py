import random
random_num = random.randint(1, 2) # [1, 2]
print(random_num)

bool_1 = True # 'T' in upper case
print(type(bool_1))

age  = int(input("What is your age:"))
if age <= 18:
    print("half ticket for children") # 4 space before statements
elif age >= 60:
    print("half ticket for elderly")
else:
    if int(input("What is your VIP level:")) >= 5:
        print("free ticket for VIP5 or above")
    else:
        print("full ticket")