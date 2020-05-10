def main():
    dataset = int(input())
    for i in range(dataset):
        inputs = list(map(int, input().split(" ")))
        ans = ssqd(conv(inputs[1], inputs[2]))
        print(str(inputs[0]) + " " + str(ans))


def conv(b, n):
    lst = []
    while n > 0:
        lst.append(n % b)
        n = n // b
    return lst

def ssqd(n):
    total = 0
    while n:
        curr = n[0]
        total += curr * curr
        n = n[1:]
    return total

main()