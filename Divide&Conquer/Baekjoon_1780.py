def check(x: int, y: int, N: int):
	global query

	tmp = query[y][x]
	for y_pos in range(y, y + N):
		for x_pos in range(x, x + N):
			if query[y_pos][x_pos] != tmp:
				return False
	return True


def segmentation(x: int, y: int, N: int):
	global cnt_zero, cnt_one, cnt_mione, query

	if check(x, y, N):
		tmp = query[y][x]
		if tmp == 0:
			cnt_zero += 1
		elif tmp == 1:
			cnt_one += 1
		elif tmp == -1:
			cnt_mione += 1

	else:
		unit = N // 3

		for i in range(3):
			for j in range(3):
				segmentation(x + i * unit, y + j * unit, unit)


import sys

cnt_zero, cnt_one, cnt_mione = 0, 0, 0
query = []

N = int(input())
for _ in range(N):
	query.append(list(map(int, sys.stdin.readline().split())))

x, y = 0, 0
segmentation(x, y, N)

print(cnt_mione)
print(cnt_zero)
print(cnt_one)
