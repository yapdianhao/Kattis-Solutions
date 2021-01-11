import collections
import sys

q1 = collections.deque()
q2 = collections.deque()

def balance(q1, q2):
    if len(q1) - 1 > len(q2):
        q2.appendleft(q1.pop())
    elif len(q2) > len(q1):
        q1.append(q2.popleft())

def pushBack(num):
    q2.append(num)
    balance(q1, q2)

def pushFront(num):
    q1.appendleft(num)
    balance(q1, q2)

def pushMiddle(num):
    q2.appendleft(num)
    balance(q1, q2)

def get(idx):
    length = len(q1) + len(q2)
    med = length >> 1
    if idx > med:
        return q2[idx - len(q1)]
    elif idx == med and length % 2 == 0:
        return q2[0]
    elif idx == med and length % 2 == 1:
        return q1[-1]
    else:
        return q1[idx]

for line in sys.stdin:
    if ' ' not in line:
        continue
    instruction, n = line.split(" ")
    if instruction == 'push_back':
        pushBack(int(n))
    elif instruction == 'push_front':
        pushFront(int(n))
    elif instruction == 'push_middle':
        pushMiddle(int(n))
    elif instruction == 'get':
        print(get(int(n)))