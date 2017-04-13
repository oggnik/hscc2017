import sys

# Read input
line = sys.stdin.readline().strip().split()
N, M = int(line[0]), int(line[1])

heights = []

for i in range(0, N):
    l = sys.stdin.readline().strip().split()
    heights.append(map(int, l))

def onEdge(i, j):
    return i==0 or j==0 or i==N-1 or j==M-1

# Function to determine if there is a path from a location to the edge with height <= h
def pathToEdge(i, j, h, visitedMap):
    visitedMap[i][j] = True
    if onEdge(i, j): return True
    locationsToExamine = [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]
    for loc in locationsToExamine:
        if heights[loc[0]][loc[1]] <= h and visitedMap[loc[0]][loc[1]] == False:
            if pathToEdge(loc[0], loc[1], h, visitedMap):
                return True
    return False

# We use a separate array to keep track of locations we have visited.  This function
# creates a new array
def createCleanVisitedMap():
    m = []
    for i in range(0, N):
        m.append([])
        for j in range(0, M):
            m[i].append(False)
    return m


# For each location determine if there is a path from it to the edge without going
# uphill (21 -> 17 -> 18 has a non uphill path).  If there exists a path, then the
# location will not flood. 
for i in range(0, N):
    lineOut = []
    for j in range(0, M):
        if not onEdge(i, j) and not pathToEdge(i, j, heights[i][j], createCleanVisitedMap()):
            lineOut.append('W')
        else:
            lineOut.append('D')
    print(''.join(lineOut))