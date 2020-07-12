def main():
    lines = int(input())
    lst = []
    for i in range(lines):
        lst.append(int(input()))
    total = 0
    for i in range(lines):
        total += lst[i] * ((4 / 5) ** i)
    total /= 5
    print(total)
    avg = 0
    for i in range(len(lst)):
        avg += calc(lst, i)
    print(avg / len(lst))

def calc(lst, idx):
    seen = False
    ans = 0
    for i in range(len(lst)):
        if i == idx:
            seen = True
            continue
        if not seen:
            ans += lst[i] * ((4 / 5) ** i)
        else:
            ans += lst[i] * ((4 / 5) ** (i - 1))
    return ans / 5

main()