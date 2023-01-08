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
    int n, s;
    int arr[100001];

    scanf("%d %d", &n, &s);
    int max_index = 0;
    for (int i = 0;i < n;i++) {
        scanf("%d", &arr[i]);
    }

    int lptr = 0;
    int rptr = 0;
    int acc = arr[0];
    int len = n + 1;
    while (lptr <= rptr && rptr < n) {
        if (acc < s) {
            acc += arr[++rptr];
        }
        else {
            len = min(len, rptr - lptr + 1);
            acc -= arr[lptr++];
        }
    }
    if (len == n + 1) len = 0;
    printf("%d", len);

    return 0;
}