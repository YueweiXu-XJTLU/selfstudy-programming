# class
class Student:
    # variables
    name = None
    age = None
    gender = None

    # magic methods
    # constructor method - constructor
    def __init__(self, name=None, age=None, gender=None): # pseudo-overloading
        self.name = name
        self.age = age
        self.gender = gender

    # toString
    def __str__(self):
        return f"Student - name: {self.name}, age: {self.age}, gender: {self.gender}"

    # less/larger than & less/larger than or equals to - comparable
    def __lt__(self, other):
        return self.age < other.age

    def __le__(self, other):
        return self.age <= other.age

    # equals to - equals
    def __eq__(self, other):
        return self.name == other.name and self.age == other.age and self.gender == other.gender


    # methods (a function in a class is called a method)(must use self as the first parameter)
    def print_info(self):
        print("Name:", self.name)
        print("Age:", self.age)
        print("Gender:", self.gender)



if __name__ == '__main__':
    stu_1 = Student()
    stu_1.name = 'san.zhang'
    stu_1.age = 18
    stu_1.gender = 'male'
    print(stu_1.name, stu_1.age, stu_1.gender)

    # __init__
    stu_2 = Student("si.li", 19, "male")
    stu_2.print_info()

    # __str__
    print(str(stu_2))
    print(stu_2)

    # __lt__
    print(stu_1 < stu_2)

    # __le__
    print(stu_1 <= stu_2)

    # __eq__
    print(stu_1 == stu_2)