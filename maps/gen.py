import random
C = random.randint(100, 1000)
R = random.randint(C, round(C ** 1.1))
print(str(C) + ' ' + str(R))
for i in range(0, R):
	A = random.randint(1, C)
	B = random.randint(1, C - 1)
	if A == B:
		B = C
	T = random.randint(1, 100)
	line = str(A) + ' ' + str(B) + ' ' + str(T)
	print(line)
X = random.randint(1, C)
Y = random.randint(1, C - 1)
if X == Y:
	Y = C
print(str(X) + ' ' + str(Y))