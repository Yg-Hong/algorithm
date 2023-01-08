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
    int N;
    int temp;
    int acc = 0;
    scanf("%d", &N);
    for (int i = 0;i < N;i++) {
        scanf("%1d", &temp);
        acc += temp;
    }
    printf("%d", acc);
    return 0;
}