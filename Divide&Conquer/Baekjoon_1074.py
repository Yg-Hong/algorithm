def quadSegmentation(length: int, r: int, c: int):
	global cnt
	half_len = length // 2

	if r < half_len and c < half_len:
		if half_len == 1:
			return
		quadSegmentation(half_len, r, c)

	elif r < half_len and c >= half_len:
		if half_len == 1:
			cnt += 1
			return

		cnt += pow(half_len, 2)
		quadSegmentation(half_len, r, c - half_len)

	elif r >= half_len and c < half_len:
		if half_len == 1:
			cnt += 2
			return

		cnt += pow(half_len, 2) * 2
		quadSegmentation(half_len, r - half_len, c)

	elif r >= half_len and c >= half_len:
		if half_len == 1:
			cnt += 3
			return

		cnt += pow(half_len, 2) * 3
		quadSegmentation(half_len, r - half_len, c - half_len)

N, r, c = map(int, input().split())
length = pow(2, N)
quadSegmentation(length, r, c)
cnt = 0
print(cnt)

