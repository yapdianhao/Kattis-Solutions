def main():
    num = int(input())
    strings = []
    total = 0
    for i in range(num):
        strings.append(input())
    for string in strings:
        if 'CD' in string:
            continue
        total += 1
    return total

print(main())