import sys

def main():
    for line in sys.stdin:
        line = line.lower()
        if ('problem') in line:
            print('yes')
        else:
            print('no')
    
main()