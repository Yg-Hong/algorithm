def star_printing(x: int, y: int, size: int):
	global star
	if size == 3:
		pattern = [[" ", " ", "*", " ", " "],
				   [" ", "*", " ", "*", " "],
				   ["*", "*", "*", "*", "*"]]
		for i in range(3):
			for j in range(5):
				star[y + i][x + j] = pattern[i][j]

	else:
		half_size = size // 2
		star_printing(x + half_size, y, half_size)
		star_printing(x, y + half_size, half_size)
		star_printing(x + size, y + half_size, half_size)

		return


num = int(input())
star = [[" "] * (2 * num - 1) for _ in range(num)]

star_printing(0, 0, num)
for line in star:
	print("".join(line))
