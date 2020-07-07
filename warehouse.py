def main():
    testCases = int(input())
    for i in range(testCases):
        solve()

def solve():
    items = int(input())
    lst = []
    d = dict()
    for i in range(items):
        line = list(input().split(" "))
        item = line[0]
        qty = int(line[1])
        if item in d:
            d[item] += qty
        else:
            lst.append(item)
            d[item] = qty
    lst = sorted(sorted(lst), key = lambda x: d[x], reverse = True)
    print(len(d))
    for i in lst:
        print(i + " " + str(d[i]))

main()