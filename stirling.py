import math

def stirling(n):
    return math.sqrt(2 * math.pi * n) * (n ** n) / (math.e ** n)

def fact(n):
    return sum(math.log(ii) for ii in range(1, n + 1))

def run():
    while True:
        n = int(input())
        if n == 0:
            break
        else:
            print((1 / stirling(n) * fact(n)))

run()