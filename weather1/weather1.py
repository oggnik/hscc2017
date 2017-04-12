import sys

N = int(sys.stdin.readline().strip())

heightLine = sys.stdin.readline().strip()

heights = []
for h in heightLine.split():
    # We store [height, maxHeightFromLeft, maxHeightFromRight]
    heights.append([int(h), 0, 0])

maxLeft = 0
for i in range(0, N):
    maxLeft = max(maxLeft, heights[i][0])
    heights[i][1] = maxLeft
maxRight = 0
for i in range(0, N):
    maxRight = max(maxRight, heights[N-i-1][0])
    heights[N-i-1][2] = maxRight

floodAmount = 0
for i in range(1, N-1):
    minSideHeight = min(heights[i][1], heights[i][2])
    if heights[i][0] < minSideHeight:
        floodAmount += minSideHeight - heights[i][0]

print(floodAmount)