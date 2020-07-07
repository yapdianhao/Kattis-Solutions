import sys

def main():
    lastName = dict()
    names = []
    for line in sys.stdin:
        names.append(line)
        line = line[:-1]
        line = line.split(" ")
        if line[0] not in lastName:
            lastName[line[0]] = False
        else:
            lastName[line[0]] = True
    names.sort(key = lambda x: x.split(" ")[0])
    names.sort(key = lambda x: x.split(" ")[-1])
    for name in names:
        name = name[:-1]
        name = name.split(" ")
        if lastName[name[0]]:
            print(" ".join(name))
        else:
            print(name[0])
    
main()