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

bool arr[10001];

int d(int n) {
    int acc = n;
    acc += n % 10;
    while (n != 0) {
        n /= 10;
        acc += n % 10;
    }
    return acc;
}

int main() {
    for (int i = 0;i < 10001;i++)
        arr[i] = false;

    for (int i = 1;i < 10001;i++) {
        arr[d(i)] = true;
    }

    for (int i = 1;i < 10001;i++) {
        if (arr[i] == false)
            printf("%d\n", i);
    }

    return 0;
}