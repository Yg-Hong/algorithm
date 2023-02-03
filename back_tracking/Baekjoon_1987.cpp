#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <stack>
#include <vector>
#include <cmath>

using namespace std;

char map[21][21];
bool visit[26];

int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

int max_result = 0;

void dfs(int x, int y, int C,int R, int cnt) {

	if (max_result < cnt) max_result = cnt;

	for (int i = 0;i < 4;i++) {
		int next_y = y + dy[i];
		int next_x = x + dx[i];

		if (next_x > 0 && next_x <= C && next_y > 0 && next_y <= R) {
			if (visit[map[next_y][next_x] - 'A'] == false) {
				visit[map[next_y][next_x] - 'A'] = true;
				dfs(next_x, next_y, C, R, cnt + 1);
				visit[map[next_y][next_x] - 'A'] = false;
			}
		}
	}
}

int main() {
	int R, C;
	scanf("%d %d", &R, &C);
	for (int y = 1;y <= R;y++)
		for (int x = 0;x <= C;x++)
			scanf("%c", &map[y][x]);

	visit[map[1][1] - 'A'] = true;
	dfs(1, 1, C, R, 1);
	printf("%d", max_result);
}