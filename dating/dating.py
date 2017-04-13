import sys

N = int(sys.stdin.readline().strip())

poolA = []
poolB = []

for i in range(0, N):
    poolA.append(sys.stdin.readline().strip())
for i in range(0, N):
    poolB.append(sys.stdin.readline().strip())

# Sort both pools
poolASorted = sorted(poolA, key=lambda x: int(x.split()[2]), reverse=True)
poolBSorted = sorted(poolB, key=lambda x: int(x.split()[2]), reverse=True)

for i in range(0, N):
    poolASplit = poolASorted[i].split()
    poolBSplit = poolBSorted[i].split()
    print('{} {} - {} {}'.format(poolASplit[0], poolASplit[1], poolBSplit[0], poolBSplit[1]))