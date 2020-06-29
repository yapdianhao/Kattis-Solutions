def main():
    length = int(input())
    ans = input()
    A = 'ABC'
    B = 'BABC'
    G = 'CCAABB'
    while len(A) < length:
        A += A
    while len(B) < length:
        B += B
    while len(G) < length:
        G += G
    best = 0
    idx = 0
    adrain, bruno, goran = 0, 0, 0
    while idx < length:
        if A[idx] == ans[idx]:
            adrain += 1
            best = max(best, adrain)
        if B[idx] == ans[idx]:
            bruno += 1
            best = max(best, bruno)
        if G[idx] == ans[idx]:
            goran += 1
            best = max(best, goran)
        idx += 1
    print(best)
    if adrain == best:
        print("Adrian")
    if bruno == best:
        print("Bruno")
    if goran == best:
        print("Goran")


main()