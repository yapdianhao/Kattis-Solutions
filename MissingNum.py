def main():
    times = int(input())
    lst = []
    for i in range(times):
        lst.append(int(input()))
    missing = []
    for i in range(1, max(lst)):
        if i not in lst:
            missing.append(i)
    if not missing:
        print("good job")
    else:
        missing.sort()
        for i in missing:
            print(i)

main()