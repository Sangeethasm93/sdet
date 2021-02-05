numberList = [12, 13, 14, 15, 16]

result = sum(numberList)

def sum(numbers):
	sum = 0
	for number in numbers:
		sum = sum+number
	return sum

print("The sum of all the numbers is: " , result)