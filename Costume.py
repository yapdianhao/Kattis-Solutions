def main():
    d = {}
    n = int(input())
    for i in range(n):
        string = input()
        if string not in d:
            d[string] = 1
        else:
            d[string] += 1
    biggest = 1000
    for i in d.values():
        if i < biggest:
            biggest = i
    lst = []
    for string in d.keys():
        if d[string] == biggest:
            lst.append(string)
    lst.sort()
    for string in lst:
        print(string)

main()