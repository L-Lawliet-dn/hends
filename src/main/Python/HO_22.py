import random

print("Lets play rock paper scissors\n")
vals = ["R","P","S"]

while True:
    uVal = input("Enter R for rock, P for paper, S for scissors\n").upper()

    while(uVal not in vals):
        uVal = input("Enter a valid value\nEnter R for rock, P for paper, S for scissors\n").upper()

    cVal = vals[random.randint(0,2)]

    if cVal == "R":
        if uVal == "P":
            print("You Win")
        else:
            print("You Lose")
    elif cVal == "P":
        if uVal == "S":
            print("You Win")
        else:
            print("You Lose")
    else:
        if uVal == "R":
            print("You Win")
        else:
            print("You Lose")
            

    redo = input("Do you want to play again (Y/N)").upper()

    if redo != "Y":
        break
    