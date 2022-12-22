#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <vector>
#include <cmath>

using namespace std;

queue<int> blue;
queue<int> white;

char map[101][101];
int visit[101][101];
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,1,-1 };

void init() {
	for (int i = 0;i < 100;i++)	{
		for (int j = 0;j < 100;j++) {
			visit[i][j] = 0;
		}
	}
}

int square(int base) {
	return base * base;
}

void bfs(int y, int x) {
	char pivot = map[y][x];
	int cloud = 1;
	int now_x, now_y, next_x, next_y;
	queue<pair<int, int>> q;

	q.push(make_pair(x, y));
	visit[y][x] = 1;
	while (!q.empty()) {
		now_x = q.front().first;
		now_y = q.front().second;
		q.pop();

		for (int i = 0;i < 4;i++) {
			next_x = now_x + dx[i];
			next_y = now_y + dy[i];
			if (pivot == map[next_y][next_x]) {
				if (!visit[next_y][next_x]) {
					q.push(make_pair(next_x, next_y));
					visit[next_y][next_x] = 1;
					cloud++;
				}
			}
		}
	}

	if (pivot == 'W')
		white.push(cloud);
	else if (pivot == 'B')
		blue.push(cloud);
}


int main() {
	int N, M, carrige;
	scanf("%d %d %d", &N, &M, &carrige);

	for (int i = 0;i < M;i++) {
		for (int j = 0;j <= N;j++) {
			scanf("%1c", &map[i][j]);
		}
	}

	init();
	for (int i = 0;i < M;i++) {
		for (int j = 0;j < N;j++) {
			if (!visit[i][j])
				bfs(i, j);
		}
	}

	int powerOfWhite = 0; int powerOfBlue = 0;
	while (!white.empty()) {
		powerOfWhite += square(white.front());
		white.pop();
	}
	while (!blue.empty()) {
		powerOfBlue += square(blue.front());
		blue.pop();
	}
	printf("%d %d", powerOfWhite, powerOfBlue);

	return 0;
}