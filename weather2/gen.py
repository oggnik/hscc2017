import random

N = 40
M = 45

print('{} {}'.format(N, M))
for i in range(0, N):
    heightLine = []
    for j in range(0, M):
        heightLine.append(str(random.randint(0, 100)))
    print(' '.join(heightLine))