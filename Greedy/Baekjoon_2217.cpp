#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <stack>
#include <vector>
#include <cmath>

using namespace std;

vector<int> lope;

int main() {
	int N;
	scanf("%d", &N);

	for (int i = 0;i < N;i++) {
		int temp;
		scanf("%d", &temp);
		lope.push_back(temp);
	}
	sort(lope.rbegin(), lope.rend());

	int maxWeight = lope[0];
	for (int i = 1;i < lope.size();i++) {
		if (maxWeight < lope[i] * (i + 1))
			maxWeight = lope[i] * (i + 1);
	}
	printf("%d", maxWeight);
}