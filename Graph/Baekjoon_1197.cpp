#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <stack>
#include <vector>
#include <cmath>

using namespace std;

int parent[10001];
vector<pair<int, pair<int, int>>> g;

int find(int x) {
	if (parent[x] == x) return x;
	else return parent[x] = find(parent[x]);
}

void uni(int x, int y) {
	x = find(x);
	y = find(y);
	parent[y] = x;
}

bool checkSameParent(int x, int y) {
	x = find(x);
	y = find(y);
	if (x == y) return true;
	else return false;
}

int main() {
	int V, E;
	scanf("%d %d", &V, &E);

	for (int i = 0;i < E;i++) {
		int from, to, cost;
		scanf("%d %d %d", &from, &to, &cost);
		g.push_back({ cost,{from,to} });
	}
	sort(g.begin(), g.end());

	int result = 0;
	for (int i = 1;i <= V;i++)
		parent[i] = i;
	for (int i = 0;i < g.size();i++) {
		if (!checkSameParent(g[i].second.first, g[i].second.second)) {
			uni(g[i].second.first, g[i].second.second);
			result += g[i].first;
		}
	}
	printf("%d", result);
}