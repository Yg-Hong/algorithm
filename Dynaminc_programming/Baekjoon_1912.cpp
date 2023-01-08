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

int main() {
    int n;
    int dp[100001];
    int arr[100001];

    scanf("%d", &n);
    for (int i = 0;i < n;i++)
        scanf("%d", &arr[i]);

    int max_num = arr[0];
    dp[0] = arr[0];

    for (int i = 1; i < n; ++i) {
        dp[i] = max(dp[i - 1] + arr[i], arr[i]);
        max_num = max(dp[i], max_num);
    }

    printf("%d", max_num);
    return 0;
}