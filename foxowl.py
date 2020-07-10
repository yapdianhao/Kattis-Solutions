def main():
    cases = int(input())
    for i in range(cases):
        print(solve())

def solve():
    curr = int(input())
    target = calc(curr)
    while calc(curr) != target - 1:
        curr -= 1
    return curr


def calc(x):
    s = str(x)
    s = list(map(lambda x: int(x), s))
    return sum(s)

main()