def main():
    string = input()
    f = int(string, 2)
    ans = ''
    while f > 0:
        r = f % 8
        ans = str(r) + ans
        f //= 8
    return ans


print(main())