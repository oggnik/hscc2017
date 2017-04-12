import sys

N = int(sys.stdin.readline())

for i in range(0, N):
    dna = sys.stdin.readline().strip()
    # Count the occurrences of each letter
    counts = {}
    maxSoFar = 'A'
    tie = False
    for char in ['A', 'G', 'C', 'T']:
        counts[char] = dna.count(char)
        if counts[char] > counts[maxSoFar]:
            maxSoFar = char
            tie = False
        elif counts[char] >= counts[maxSoFar] and char != maxSoFar:
            tie = True
    if not tie:
        print(maxSoFar)
    else:
        print('N/A')