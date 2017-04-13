import random

N = 80

tweetsPerMinute = range(1, 101)
names = []
with open('names.txt', 'r') as f:
    for name in f:
        names.append(name.strip())

random.shuffle(names)


print(N)
random.shuffle(tweetsPerMinute)
for i in range(0, N):
    print('{} {}'.format(names[i], tweetsPerMinute[i]))
random.shuffle(tweetsPerMinute)
for i in range(0, N):
    print('{} {}'.format(names[i], tweetsPerMinute[i]))