def main():
    times = int(input())
    first = input()
    sec = input()
    if times % 2:
        for i in range(len(first)):
            if first[i] == sec[i]:
                return "Deletion failed"
    else:
        for i in range(len(first)):
            if first[i] != sec[i]:
                return "Deletion failed"
    return "Deletion succeeded"

print(main())