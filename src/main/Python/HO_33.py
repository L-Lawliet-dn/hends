def sum(a,b):
    return a+b

def difference(a,b):
    return a-b

def product(a,b):
    return a*b

def quotient(a,b):
    if b == 0:
        print("Denominator cannot be 0")
        return None
    else:
        return a/b