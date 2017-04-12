import random

N = 30

heights = range(0, 101)
random.shuffle(heights)
print(N)
print(' '.join(str(x) for x in heights[:N]))