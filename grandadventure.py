def main():
    lines = int(input())
    for i in range(lines):
        if solve():
            print("YES")
        else:
            print("NO")

def solve():
    line = input()
    stack = []
    for c in line:
        if c == '$' or c == '|' or c == '*':
            stack.append(c)
        elif c == '.':
            continue
        elif c == 'j':
            if not stack:
                return False
            elif stack[-1] != '*':
                return False
            else:
                stack.pop()
        elif c == 'b':
            if not stack:
                return False
            elif stack[-1] != '$':
                return False
            else:
                stack.pop()
        elif c == 't':
            if not stack:
                return False
            elif stack[-1] != '|':
                return False
            else:
                stack.pop()
    return True if not stack else False

main()