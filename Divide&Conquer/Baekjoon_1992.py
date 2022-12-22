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
	if check(query) == 1:
		print("1", end="")
		return

	elif check(query) == 0:
		print("0", end="")
		return

	else:
		print("(", end="")

		query1 = [query[line_num][0:N // 2] for line_num in range(N // 2)]
		query2 = [query[line_num][N // 2:] for line_num in range(N // 2)]
		query3 = [query[line_num + N // 2][0:N // 2] for line_num in range(N // 2)]
		query4 = [query[line_num + N // 2][N // 2:] for line_num in range(N // 2)]

		quadtree(query1, N // 2)
		quadtree(query2, N // 2)
		quadtree(query3, N // 2)
		quadtree(query4, N // 2)
		print(")", end="")

N = int(input())
query = [list(input().strip()) for _ in range(N)]
quadtree(query, N)

