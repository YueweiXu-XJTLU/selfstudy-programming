# design patterns

# single instance design pattern
import StrTools
s1 = StrTools.strTools
s2 = StrTools.strTools
print(s1)
print(s2)
# same address == single instance



# factory instance design pattern
class Person:
    pass

class Student(Person):
    pass

class Teacher(Person):
    pass

class Factory:
    def get_person(self, p_type: str):
        if p_type == 's':
            return Student()
        else:
            return Teacher()

factory = Factory()
s = factory.get_person('s')
t = factory.get_person('t')
print(type(s))
print(type(t))