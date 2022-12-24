#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <vector>
#include <cmath>

using namespace std;

int main() {
	long long X, Y, Z;
	scanf("%lld %lld", &X, &Y);
	
	Z = Y * 100 / X;

	if (Z == 99 || Z == 100) {
		printf("-1");
		return 0;
	}
	int win = (X * (Z + 1) - 100 * Y) / (99 - Z);
	win = (X * (Z + 1) - 100 * Y) % (99 - Z) == 0 ? win : win + 1;

	printf("%d", win);
	return 0;
}