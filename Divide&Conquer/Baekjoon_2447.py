# pattern 반복
def starprinting(N: int):
	if N == 3:
		# pattern에 개행 문자 넣으면 안됨.
		pattern = ["***", "* *", "***"]
		return pattern
	new_star = [i * 3 for i in starprinting(N // 3)] + \
			   [i + ' ' * (N // 3) + i for i in starprinting(N // 3)] + \
			   [i * 3 for i in starprinting(N // 3)]
	return new_star

N = int(input())

for i in starprinting(N):
		print(i)