import sys

# Skip size lines, we calculate dynamically
sys.stdin.readline()
header = sys.stdin.readline().strip().split()
starting_coords = (int(header[0]), int(header[1]))
replacement_color = header[2]
original_color = ''
canvas = []
queue = []

for line in sys.stdin:
    canvas.append(line.strip().split())    

MAX_ROW = len(canvas) 
MAX_COL = len(canvas[0])
original_color = canvas[starting_coords[0]][starting_coords[1]]
queue.append(starting_coords)

while queue:
    coords = queue.pop(0) #Dequeue first neighbor
    cur_r = coords[0]
    cur_c = coords[1]
    canvas[cur_r][cur_c] = replacement_color #Mark current as visited
    #Check neighbors to the left, right, above and below, enqueue matches
    if cur_r - 1 > -1 and canvas[cur_r - 1][cur_c] == original_color:
        queue.append((cur_r - 1, cur_c))
    if cur_r + 1 < MAX_ROW and canvas[cur_r + 1][cur_c] == original_color:
        queue.append((cur_r + 1, cur_c))
    if cur_c - 1 > -1 and canvas[cur_r][cur_c - 1] == original_color:
        queue.append((cur_r, cur_c - 1))
    if cur_c + 1 < MAX_COL and canvas[cur_r][cur_c + 1] == original_color:
       queue.append((cur_r, cur_c + 1))

for line in canvas:
    print ' '.join(line)
