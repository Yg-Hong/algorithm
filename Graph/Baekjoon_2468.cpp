#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <stack>
#include <vector>
#include <cmath>

using namespace std;

int map[101][101];
bool visit[101][101];
queue<pair<int, int>> q;

int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

int max_region = 0;
int region = 0;

void init(int h, int N) {
	region = 0;
	for (int i = 1;i <= N;i++) {
		for (int j = 1;j <= N;j++) {
			if (map[i][j] <= h)
				visit[i][j] = true;
			else
				visit[i][j] = false;
		}
	}
}


void bfs(int x, int y, int N) {
	if (!visit[y][x]) {
		region++;

		q.push(make_pair(y, x));
		visit[y][x] = true;

		while (!q.empty()) {
			int now_y = q.front().first;
			int now_x = q.front().second;
			q.pop();

			for (int i = 0;i < 4;i++) {
				int next_x = now_x + dx[i];
				int next_y = now_y + dy[i];
				if (next_x <= 0 || next_x > N || next_y <= 0 || next_y > N)
					continue;
				if (visit[next_y][next_x])
					continue;
				else {
					q.push(make_pair(next_y, next_x));
					visit[next_y][next_x] = true;
				}
			}
		}
	}
}


int main () {
	int N;
	int max_height = 0;
	scanf("%d", &N);
	for (int i = 1;i <= N;i++) {
		for (int j = 1;j <= N;j++) {
			scanf("%d", &map[i][j]);
			if (max_height < map[i][j])
				max_height = map[i][j];
		}
	}

	for(int h = 0;h <= max_height;h++){
		init(h, N);
		for (int i = 1;i <= N;i++) {
			for (int j = 1;j <= N;j++) {
				bfs(j, i, N);
			}
		}
		if (max_region < region)
			max_region = region;
	}
	printf("%d", max_region);
}