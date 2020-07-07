def main():
    lines = int(input())
    while lines != 0:
        solve(lines)
        print("\n")
        lines = int(input())

def solve(lines):
    durations = []
    for i in range(lines):
        durations.append(input().split(" "))
    durations.sort(key = lambda x: int(x[0].split(":")[1]))
    durations.sort(key = lambda x: int(x[0].split(":")[0]) % 12)
    durations.sort(key = lambda x: x[1])
    for duration in durations:
        print(" ".join(duration))

main()