def poker():
    d = {}
    strings = input().split(" ")
    m = 0
    for s in strings:
        if s[0] not in d:
            d[s[0]] = 1
        else:
            d[s[0]] += 1
        if d[s[0]] > m:
            m = d[s[0]]
    print(m)

poker()
