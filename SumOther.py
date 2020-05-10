def main():
    string = input()
    try:
        while True:
            if string == "":
                break
            string = list(map(int, string.split(" ")))
            back = string[-1]
            total = sum(string[0:-1])
            if total == back:
                print(back)
            else:
                print(int((total + back )/ 2))
            string = input()
    except:
        pass

main()