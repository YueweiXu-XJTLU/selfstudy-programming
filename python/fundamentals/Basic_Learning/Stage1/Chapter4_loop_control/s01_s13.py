# while
i = 1
while i < 10:
    j = 1
    while j <= i:
        print(f"{i} * {j} = {i * j}\t", end = " ")
        j = j + 1
    print()
    i = i + 1



# for

# iterate str
letters = "abcde"
for i in letters:
    print(i)

# range
# range(num) ---> [0, num)
# range(num1, num2) ---> [num1, num2)
# range(num1, num2, step) ---> [num1, num2), in step
for i in range(2, 10, 2):
    print(i, end="")
print()



# break & continue


#case
balance = 10000
import random
for emp_index in range(1, 21):
    if balance <= 0:
        print("No money left")
        break

    performance = random.randint(1, 10)
    if performance < 5:
        print("Employee", emp_index, ", Performance", performance, ", Salary: 0")
        continue

    print("Employee", emp_index, ", Performance", performance, ", Salary: 1000")
    balance -= 1000