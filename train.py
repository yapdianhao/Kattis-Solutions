def main():
    lst = list(map(int, input().split(" ")))
    capac = lst[0]
    lines = lst[1]
    vac = 0
    for i in range(lines):
        line = list(map(int, input().split(" ")))
        if i == lines - 1 and line[2] != 0:
            return "impossible"
        else:
            if line[0] > vac:
                return "impossible"
            vac += line[1] - line[0]
            if vac != capac and line[2] > 0:
                return "impossible"
            if vac > capac:
                return "impossible"
            if vac < 0:
                return "impossible"
    if vac != 0:
        return "impossible"
    return "possible"



print(main())