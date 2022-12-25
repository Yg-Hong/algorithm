#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <vector>
#include <cmath>

using namespace std;

int main() {
	int test_case;
	scanf("%d", &test_case);
	for (int i = 0;i < test_case;i++) {
		int N, M;
		scanf("%d %d", &N, &M);

		int noc = 1;
		for (int j = 1;j <= N;j++) {
			noc *= (M - j + 1);
			noc /= j;
		}
		printf("%d\n", noc);
	}
	return 0;
}