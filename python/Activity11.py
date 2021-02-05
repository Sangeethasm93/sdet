fruits = {
    "apple":"100",
    "banana":"200",
    "pineapple":"300",
    "orange":"400"
}
print("Fruits and their prices are: ", fruits)

fruit_search = input("Enter the fruit: ").lower()
if(fruit_search in fruits):
    print("The fruit is available")
else:
    print("The fruit is not available")