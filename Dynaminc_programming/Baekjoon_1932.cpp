#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <stack>
#include <vector>
#include <cmath>

using namespace std;


int main() {
	int tri[501][501];

	int n;
	scanf("%d", &n);
	for (int i = 1;i <= n;i++) {
		for (int j = 1;j <= i;j++) {
			scanf("%d", &tri[i][j]);
		}
	}
	
	for (int i = n;i >= 1;i--) {
		for (int j = 1;j < i;j++) {
			tri[i - 1][j] += max(tri[i][j], tri[i][j + 1]);
		}
 	}

	printf("%d", tri[1][1]);
}