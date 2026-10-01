# encapsulation
class Phone:
    # private member variable/method (only accessible inside class): __xxx
    __current_voltage = None

    def __keep_single_core(self):
        print("CPU run in singlea core mode - current voltage: ", self.__current_voltage)



# inheritance (allow for multiple inheritance)
class Phone2:
    producer = "Apple"

    def basic_info(self):
        print("This is a mobile phone")

class Phone3(Phone, Phone2):
    pass # used to avoid syntax error if nothing to write here, no any effects

class Phone4(Phone, Phone2):
    def basic_info(self):
        Phone2.basic_info(self) # OR `super().basic_info()`

        producer = Phone2.producer  # OR `producer = super().producer`
        print(f"designed by {producer}")

if __name__ == "__main__":
    phone3 = Phone3()
    print(phone3.producer)

    phone4 = Phone4()
    phone4.basic_info()



# polymorphism
class Animal: # abstract class/interface
    def __init__(self):
        pass

    def speak(self):
        pass

class Cat(Animal): # implementation abstract class/interface
    def __init__(self):
        super().__init__()

    def speak(self):
        print("I am a cat")

def speak(animal: Animal):
    animal.speak()

if __name__ == "__main__":
    cat = Cat()
    speak(cat)