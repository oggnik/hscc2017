n = int(input())
n_cube_rooted = round(n ** (1.0 / 3.0))
n_potential = n_cube_rooted ** 3
if n == n_potential:
	print("YES")
else:
	print("NO")