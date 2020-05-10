import math

def nCr(n, r):
    return math.factorial(n) // (math.factorial(r) * math.factorial(n - r))

def main():
    nums = list(map(int, input().split(" ")))
    numer = nums[1]
    arr = list(map(int, input().split(" ")))
    d = {}
    total = 0
    for i in arr:
        if i // numer not in d:
            d[i // numer] = 1
        else:
            d[i// numer] += 1
    for i in d.values():
        if i == 1:
            continue
        total += nCr(i, 2)
    return total

print(main())
