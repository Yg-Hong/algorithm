#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <stack>
#include <vector>
#include <cmath>

using namespace std;

int W[101];
int V[101];
int knap[101][100001];

int main() {
	int N, K;
	scanf("%d %d", &N, &K);
	for (int i = 1;i <= N;i++) 
		scanf("%d %d", &W[i], &V[i]);
	
	int chosen, unchosen;

	for (int i = 1;i <= N;i++) {
		for (int j = 1;j <= K;j++) {
			if (j - W[i] >= 0) {
				chosen = knap[i - 1][j - W[i]];
				unchosen = knap[i - 1][j];
				
				knap[i][j] = max(unchosen, chosen + V[i]);
			}
			else
				knap[i][j] = knap[i - 1][j];
		}
	}
	printf("%d", knap[N][K]);
}