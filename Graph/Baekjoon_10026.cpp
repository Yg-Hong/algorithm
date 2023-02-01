#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <stack>
#include <vector>
#include <cmath>

using namespace std;

char map[101][101];
bool visit[101][101];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
queue<pair<int, int>> q;

void init(int N) {
	for (int i = 1;i <= N;i++)
		for (int j = 1;j <= N;j++)
			visit[i][j] = false;
}

int bfs1(int N) {
	int x, y, region = 0;
	char pivot;
	for (int i = 1;i <= N;i++) {
		for (int j = 1;j <= N;j++) {
			if (visit[i][j])
				continue;
			else {
				region++;
				pivot = map[i][j];
				x = j;	y = i;
				q.push(make_pair(y, x));
				visit[y][x] = true;

				while (!q.empty()) {
					y = q.front().first;
					x = q.front().second;
					q.pop();

					for (int h = 0;h < 4;h++) {
						int next_x = x + dx[h];
						int next_y = y + dy[h];
						if (map[next_y][next_x] == pivot) {
							if (!visit[next_y][next_x]) {
								q.push(make_pair(next_y, next_x));
								visit[next_y][next_x] = true;
							}
						}
					}
				}
			}
		}
	}
	return region;
}

int bfs2(int N) {
	int x, y, region = 0;
	char pivot;
	for (int i = 1;i <= N;i++) {
		for (int j = 1;j <= N;j++) {
			if (visit[i][j])
				continue;
			else {
				region++;
				pivot = map[i][j];
				x = j;	y = i;
				q.push(make_pair(y, x));
				visit[y][x] = true;

				while (!q.empty()) {
					y = q.front().first;
					x = q.front().second;
					q.pop();

					for (int h = 0;h < 4;h++) {
						int next_x = x + dx[h];
						int next_y = y + dy[h];
						if (pivot == 'B') {
							if (map[next_y][next_x] == pivot) {
								if (!visit[next_y][next_x]) {
									q.push(make_pair(next_y, next_x));
									visit[next_y][next_x] = true;
								}
							}
						}
						else {
							if (map[next_y][next_x] == 'R' || map[next_y][next_x] == 'G') {
								if (!visit[next_y][next_x]) {
									q.push(make_pair(next_y, next_x));
									visit[next_y][next_x] = true;
								}
							}
						}
					}
				}
			}
		}
	}
	return region;
}


int main() {
	int N;
	scanf("%d", &N);
	for (int i = 1;i <= N;i++) {
		for (int j = 0;j <= N;j++) {
			scanf("%c", &map[i][j]);
		}
	}
	int result1 = bfs1(N);
	init(N);
	int result2 = bfs2(N);

	printf("%d %d", result1, result2);
}