import sys
sys.setrecursionlimit(10 ** 8)


def makePre(in_start: int, in_end: int, post_start: int, post_end: int):
	global in_order, post_order, pre_order

	if in_start > in_end or post_start > post_end:
		return

	root = post_order[post_end]
	pre_order.append(root)
	root_idx = pos[root]
	size = root_idx - in_start

	makePre(in_start, root_idx - 1, post_start, post_start + size - 1)
	makePre(root_idx + 1, in_end, post_start + size, post_end - 1)


N = int(input())
in_order = list((map(int, sys.stdin.readline().split())))
post_order = list((map(int, sys.stdin.readline().split())))

# 인오더 자꾸 탐색해서 시간초과... 미리 위치를 저장.
pos = [-1] * (N + 1)
for i in range(N):
	pos[in_order[i]] = i

pre_order = []
makePre(0, N - 1, 0, N - 1)
for a in pre_order:
	print(a, end=" ")
