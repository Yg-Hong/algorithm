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

bool check(int num) { // num은 무조건 세자리 숫자
    int arr[3];
    arr[2] = num % 10;
    arr[1] = (num / 10) % 10;
    arr[0] = ((num / 10) / 10) % 10;

    if (arr[2] - arr[1] == arr[1] - arr[0])
        return true;
    else
        return false;
}

int main() {
    int num;
    int cnt, temp;
    scanf("%d", &num);
    if (num < 100) {
        printf("%d", num);
        return 0;
    }
    else {
        cnt = 99;
        temp = 99;
        while (temp <= num) {
            if (temp == 1000) {
                printf("%d", cnt);
                return 0;
            }
            if (check(temp++)) cnt++;
        }
        printf("%d", cnt);
        return 0;
    }
}