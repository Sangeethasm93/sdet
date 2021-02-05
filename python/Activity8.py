numbers = list(input("Enter the list of numbers: "))
#numbers = ["10","20","30","40","10"]
print("The numbers are" ,numbers)
first = numbers[0]
last = numbers[-1]
if (first==last):
    print(True)
else:
    print(False)