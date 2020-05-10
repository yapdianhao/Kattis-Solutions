def main():
    n = int(input())
    lst = list(map(int, input().split(" ")))
    smallest = max(lst)
    idx = -1
    for i in range(n):
        if smallest > lst[i]:
            smallest = lst[i]
            idx = i
    return idx

print(main())