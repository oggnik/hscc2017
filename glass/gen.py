import random
M = random.randint(10, 1000)
print(M)
V = [[0 for i in range(M)] for j in range(M)]
max_so_far = 1
for i in range(0, M):
	for j in range(0, i):
		maxValue = int((1000000 - max_so_far) ** 0.1 + max_so_far)
		max_so_far = random.randint(max_so_far, maxValue)
		V[i][j] = max_so_far
		V[j][i] = max_so_far
for i in range(0, M):
	s = ''
	for j in range(0, M):
		s += str(V[i][j]) + ' '
	print(s)
T = random.randint(100, 1000)
print(T)
for i in range(0, T):
	print(random.randint(1, M))
	print(random.randint(1, M))