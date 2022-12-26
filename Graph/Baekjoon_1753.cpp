#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <stack>
#include <vector>
#include <cmath>

using namespace std;

priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> H;
vector<pair<int, int>> g[20001];
int dist[20001];

void init() {
	for (int i = 0;i < 20001;i++) 
		dist[i] = 99999999;
}

int main() {
	int V, E, start;
	scanf("%d %d", &V, &E);
	scanf("%d", &start);

	for (int i = 1;i <= E;i++) {
		int v, u, w;
		scanf("%d %d %d", &u, &v, &w);
		g[u].push_back(make_pair(v, w));
	}

	init();
	dist[start] = 0;
	H.push(make_pair(dist[start], start));
	
	while (!H.empty()) {
		int u = H.top().second;
		H.pop();

		for (int i = 0;i < g[u].size();i++) {
			int now = g[u][i].first;
			int weight = g[u][i].second;
			if (dist[now] > dist[u] + weight) {
				dist[now] = dist[u] + weight;
				H.push(make_pair(dist[now], now));
			}
		}
	}

	for (int i = 1;i <= V;i++) {
		if (dist[i] == 99999999)
			printf("INF\n");
		else
			printf("%d\n", dist[i]);
	}
}