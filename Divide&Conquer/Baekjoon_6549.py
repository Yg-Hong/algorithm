import math

# idx 기준 주변 사각형의 넓이를 미리 구해놓자.
# 따라서 segment tree 활용
def segmentTree(start, end, idx):
	global seg, box

	if start == end:
		seg[idx] = box[start]
		return seg[idx]

	mid = (start + end) // 2
	left = segmentTree(start, mid, idx * 2)
	right = segmentTree(mid + 1, end, idx * 2 + 1)
	seg[idx] = min(left, right)

	return seg[idx]


def boxArea(start: int, end: int):
	global seg, box
	# degenerate case
	if start == end:
		return box[start]

	# divide
	mid = (start + end) // 2
	left = boxArea(start, mid)
	right = boxArea(mid + 1, end)

	max_value = max(left, right)

	# 구간의 경계 부분을 포함하는 가장 큰 직사각형의 넓이도 구한다.
	height = min(box[mid], box[mid + 1])
	width = 2
	square = width * height
	i, j = mid, mid + 1
	while start < i or j < end:  # i==frm and j==to 가 되면 종료
		if j == end or start < i and box[i - 1] >= box[j + 1]:
			i -= 1
			width += 1
			height = min(height, box[i])
			square = max(square, width * height)
		else:
			j += 1
			width += 1
			height = min(height, box[j])
			square = max(square, width * height)

	max_val = max(max_value, square)

	return max_val


while True:
	box = list(map(int, input().split()))
	N = box.pop(0)
	if N == 0: break

	b = math.ceil(math.log2(N)) + 1
	node_n = 1 << b
	seg = [0] * node_n
	segmentTree(0, len(box) - 1, 1)

	print(boxArea(0, len(box) - 1))
