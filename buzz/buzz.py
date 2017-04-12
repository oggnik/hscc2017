
for i in range(1, 201):
    if i % 3 == 0 and i % 5 == 0 and i % 11 == 0:
        print('BizzFuzzBuzz')
    elif i % 5 == 0 and i % 11 == 0:
        print('FuzzBuzz')
    elif i % 3 == 0 and i % 11 == 0:
        print('BizzBuzz')
    elif i % 3 == 0 and i % 5 == 0:
        print('BizzFuzz')
    elif i % 11 == 0:
        print('Buzz')
    elif i % 5 == 0:
        print('Fuzz')
    elif i % 3 == 0:
        print('Bizz')
    else:
        print(i)