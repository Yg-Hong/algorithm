# idx 기준 주변 사각형의 넓이를 미리 구해놓아야 시간 초과가 안날 듯.
# segment tree 활용 안하고 풀기 -> 시간 제한 때문에 idx로만 조작하기

def boxS(start: int, end: int):
	global box
	# degenerate case
	if start == end:
		return box[start]

	# divide
	mid = (start + end) // 2
	max_value = max(boxS(start, mid), boxS(mid + 1, end))

	low, high = mid, mid + 1
	height = min(box[low], box[high])
	max_value = max(max_value, height * 2)
	# 	low = mid -> i
	# 	high = mid + 1 -> j

	while start < low or high < end:
		if high < end and (low == start or box[low - 1] < box[high + 1]):
			high += 1
			height = min(height, box[high])
		else:
			low -= 1
			height = min(height, box[low])
	max_val = max(max_value, height * (high - low + 1))

	return max_val


N = int(input())
box = []
for _ in range(N):
	box.append(int(input()))

print(boxS(0, N - 1))
