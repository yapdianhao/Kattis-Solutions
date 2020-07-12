def main():
    lines = int(input())
    inputs = []
    for i in range(lines):
        inputs.append(list(map(int, input().split(" "))))
    calc = recursive(inputs, 1, 0)
    ans = 1000000001
    for i in calc:
        if i == (1, 0):
            continue
        ans = min(ans, abs(i[0] - i[1]))
    return ans
    
def recursive(inputs, sour, bitter):
    if not inputs:
        return [(sour, bitter)]
    else:
        return recursive(inputs[1:], sour * inputs[0][0], bitter + inputs[0][1]) + recursive(inputs[1:], sour, bitter)
            
print(main())