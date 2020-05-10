def main():
    start = list(map(int, input().split(" ")))
    end = list(map(int, input().split(" ")))
    batt = int(input())
    total = abs(start[0] - end[0]) + abs(start[1] - end[1])
    if batt < total:
        return False
    else:
        batt -= total
        if batt % 2 == 0:
            return True
        else:
            return False

if main():
    print("Y")
else:
    print("N")