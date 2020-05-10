def main():
    lines = int(input())
    for i in range(lines):
        solve()

def solve():
    nums = list(map(int, input().split(" ")))
    total = calc(nums[0], nums[1], nums[2])
    print(total)

def calc(root, factor, most):
    count = 0
    while root <= most:
        count += 1
        root *= factor
    return count

main()