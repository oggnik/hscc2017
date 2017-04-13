import random

N = 80
M = 63
print(N)

for i in range(0, N):
    sequence = ''.join(random.choice(['A', 'C', 'T', 'G']) for _ in range(M))
    print(sequence)