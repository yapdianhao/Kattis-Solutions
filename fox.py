
def solve():
    words = input().split()
    animals = []
    sound = input()
    while sound != 'what does the fox say?':
        animals.append(sound.split())
        sound = input()
    lines = []
    for animal in animals:
        lines.append(animal[-1])
    words = filter(lambda x : x not in lines, words)
    s = ''
    for word in words:
        s += (word)
        s += (' ')
    print(s)

cases = int(input())
for i in range(cases):
    solve()
