def main():
    lst = []
    strs = int(input())
    for i in range(strs):
        lst.append(input())
    ans = 0
    for i in lst:
        if "rose" in i.lower() or "pink" in i.lower():
            ans += 1
    if ans != 0 :
        print(ans)
    else:
        print("I must watch Star Wars with my daughter")

main()