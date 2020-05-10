def main():
    lst = list(map(int, input().split(" ")))
    count = 0
    curr = lst[0] + lst[1]
    swap = lst[2]
    while curr >= swap:
        #print(curr)
        if curr % swap == 0:
            count += (curr // swap)
            curr //= swap
        else:
            count += (curr // swap)
            curr = curr // swap + curr % swap
    return count

def run():
    e, f, c = map(int, input().split(" "))
    empty = e + f
    total = 0
    while empty >= c:
        empty -= c
        total += 1
        empty += 1
    return total

print(run())