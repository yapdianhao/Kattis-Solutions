def main():
    k = int(input())
    count = 0
    n = 1
    while n < k:
        n *= 2
        count += 1
    print(str(n) + " " + str(times(0, k, 0, n)))

def times(c, target, have, remain):
    if isPower(target):
        return 1
    if have == target or remain <= 1:
        #print(str(have) + " " + str(remain))
        return c
    elif have + remain // 2 > target:
        #print(str(have) + " " + str(remain) + str(c) + "shit")
        return times(c + 1, target, have, remain // 2)
    else:
        #print(str(have) + " " + str(remain) + str(c) + "shit 2")
        return times(c + 1, target, have + remain // 2, remain // 2)

def isPower(n):
    if n == 1:
        return True
    elif n < 2:
        return False
    else:
        return isPower(n / 2)

main()