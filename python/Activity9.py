list_one = [1,2,3,4,5]
list_two = [10,25,30,45,50]

print("List one contains: ", list_one)
print("List two contains: ", list_two)

list_three =[]
print("List three contains: ", list_three)

for num in list_one:
    if (num % 2 != 0):
        list_three.append(num)

for num in list_two:
    if (num % 2 == 0):
        list_three.append(num)

print("List three contains: ", list_three)
