#/usr/bin/env python3

(r, c) = map(int, input().split(' '))

board = []

for i in range(r):
    board.append(list(input()))

eaten = 0

# eat rows
for i in range(r):
    ghosts = 0
    for j in range(c):
        if board[i][j] == 'G':
            ghosts += 1
    if ghosts == 0:
        for j in range(c):
            if board[i][j] == '.':
                eaten += 1
                board[i][j] = '0'

# eat cols
for j in range(c):
    ghosts = 0
    for i in range(r):
        if board[i][j] == 'G':
            ghosts += 1
    if ghosts == 0:
        for i in range(r):
            if board[i][j] == '.':
                eaten += 1
                board[i][j] = '0'

print(eaten)
