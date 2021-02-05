def fibonacci(number):
    if number<=1:
        return number
    else:
        return(fibonacci(number-1) + fibonacci(number-2))

user_value = int(input("Enter the number: "))

if user_value<=0:
    print("Enter positive value")
else:
    print("Fibonacci series: ")
    for i in range(user_value):
        print(fibonacci(i))