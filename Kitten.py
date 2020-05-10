def main():
    start = int(input())
    d = {}
    next = list(map(int, input().split(" ")))
    end = -1
    while next[0] != -1:
        if not d:
            end = next[0]
        for i in range(1, len(next)):
            d[next[i]] = next[0]
        next = list(map(int, input().split(" ")))
    while start != end:
        print(start)
        start = d[start]
    print(start)

main()
