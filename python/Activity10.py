numbers = tuple(input("Enter numbers: "))
print("The numbers are: " , numbers)

print("Numbers divisible by 5 are: ")
for x in numbers:
    if (int(x) % 5 == 0):
        print(x)


