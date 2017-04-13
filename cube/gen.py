import random
if random.randint(1,2) == 1:
	print(random.randint(1, 100000))
else:
	n = random.randint(1,100)
	n_cubed = n * n * n
	print(n_cubed)