#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <vector>
#include <cmath>

using namespace std;


int main() {
	int N;
	int cost[1001][3] = { 0,0,0, };
	int color[3];
	scanf("%d", &N);
	for (int i = 1;i <= N;i++) {
		scanf("%d %d %d", &color[0], &color[1], &color[2]);
		cost[i][0] = min(cost[i - 1][1], cost[i - 1][2]) + color[0];
		cost[i][1] = min(cost[i - 1][0], cost[i - 1][2]) + color[1];
		cost[i][2] = min(cost[i - 1][0], cost[i - 1][1]) + color[2];
	}

	printf("%d", min(cost[N][0], min(cost[N][1], cost[N][2])));
	return 0;
}