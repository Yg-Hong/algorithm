import sys


def multipleOfMatrix(m1: list, m2: list):
	global N
	result = [[] for _ in range(N)]
	for i in range(N):
		for j in range(N):
			tmp = 0
			for k in range(N):
				tmp += m1[i][k] * m2[k][j] % 1000
			result[i].append(tmp)
	return result


def powerOfMatrix(exponent: int):
	global matrix
	if exponent == 1:
		return matrix
	result = powerOfMatrix(exponent // 2)
	squareResult = multipleOfMatrix(result, result)
	if exponent % 2 == 0:
		return squareResult
	else:
		return multipleOfMatrix(squareResult, matrix)


N, exponent = map(int, sys.stdin.readline().split(" "))
matrix = []
for _ in range(N):
	matrix.append(list(map(int, sys.stdin.readline().split(" "))))

for line in powerOfMatrix(exponent):
		for element in line:
			print(element % 1000, end=" ")
		print()

"""
print(N)
print(exponent)
for line in matrix:
	print(line)
"""
