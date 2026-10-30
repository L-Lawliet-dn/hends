def numCheck(numTuple):
    for num in numTuple:
        if num%5 == 0:
            print(num)

numCheck((1,5,10,6,8,15))