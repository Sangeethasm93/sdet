# Get user's name
user1_name = input("user1 name is: ")
user2_name = input("user2 name is: ")

while True:
#Get User's choice
    User1_answer = input(user1_name + " option is : ").lower()
    User2_answer = input(user2_name + " option is : ").lower()

    if User1_answer == User2_answer:
        print("It's a tie")
    elif User1_answer == 'rock':
        if User2_answer == 'paper':
            print("paper Wins!")
        else:
            print("rock Wins!")
    elif User1_answer == 'paper':
        if User2_answer == 'rock':
            print("paper Wins!")
        else:
            print("scissor Wins!")
    elif User1_answer == 'scissor':
        if User2_answer == 'paper':
            print("scissor Wins!")
        else:
            print("rock Wins!")
    else:
        print("Invalid Input")

 # Ask them if they want to play again
    repeat = input("Do you want to play another round? Yes/No: ").lower()
 # If they say yes, don't do anything
    if(repeat == "yes"):
       True
 # If they say no, exit the game
    elif(repeat == "no"):
        raise SystemExit
# If they say anything else, exit with an error message.
    else:
        print("You entered an invalid option. Exiting now.")
        raise SystemExit

