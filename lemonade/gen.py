import random
L = random.randint(100, 100000)
print(L)
max_so_far = 1
for i in range(0, L):
	maxValue = int((1000000 - max_so_far) ** 0.1 + max_so_far)
	max_so_far = random.randint(max_so_far, maxValue)
	print(max_so_far)
T = random.randint(100, 100000)
print(T)
for i in range(0, T):
	print(random.randint(1, L))