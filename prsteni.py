from fractions import Fraction


def main():
    trash = input()
    lst = list(map(int, input().split(" " )))
    for i in range(1, len(lst)):
        f = Fraction(lst[0], lst[i])
        print(str(f.numerator) + "/" + str(f.denominator))


main()