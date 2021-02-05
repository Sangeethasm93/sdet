numbers = list(input("Enter the list of numbers: "))
#numbers = ["1","2","3","4"]
print("The numbers are" ,numbers)
sum=0
for x in numbers:
    sum=sum+int(x)
print("The sum of numbers: ",sum)