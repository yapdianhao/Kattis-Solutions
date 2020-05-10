def main():
    cmd = input().split(" ")
    h = int(cmd[0])
    d = {'A': 11, 'K': 4, 'Q': 3, 'J': 20, 'T': 10, '9': 14, '8': 0, '7': 0}
    nd = {'A': 11, 'K': 4, 'Q': 3, 'J': 2, 'T': 10, '9': 0, '8': 0, '7': 0}
    res = 0
    for i in range(4 * h):
        string = input()
        if string[-1] == cmd[1]:
            res += d[string[0]]
        else:
            res += nd[string[0]]
    return res


print(main())