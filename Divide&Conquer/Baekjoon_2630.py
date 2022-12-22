def check(query: list):
	query_temp = ""
	for line in query:
		for char in line:
			query_temp += char
	if "1" in query_temp and "0" not in query_temp:
		return 1

	elif "1" not in query_temp and "0" in query_temp:
		return 0

	else:
		return -1


def quadtree(query: list, N: int):
	global cnt_white, cnt_blue

	if check(query) == 1:
		cnt_blue += 1
		return

	elif check(query) == 0:
		cnt_white += 1
		return

	else:
		query1 = [query[line_num][0:N // 2] for line_num in range(N // 2)]
		query2 = [query[line_num][N // 2:] for line_num in range(N // 2)]
		query3 = [query[line_num + N // 2][0:N // 2] for line_num in range(N // 2)]
		query4 = [query[line_num + N // 2][N // 2:] for line_num in range(N // 2)]

		quadtree(query1, N // 2)
		quadtree(query2, N // 2)
		quadtree(query3, N // 2)
		quadtree(query4, N // 2)


N = int(input())
query = [str(input().strip()).replace(" ", "") for _ in range(N)]
cnt_white, cnt_blue = 0, 0
quadtree(query, N)
print(cnt_white)
print(cnt_blue)
