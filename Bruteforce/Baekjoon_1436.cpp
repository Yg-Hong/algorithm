#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <vector>
#include <cmath>

using namespace std;

bool check_num(char num[]) {
	int i = 2;
	while (num[i] != '\0') {
		if (num[i - 2] == '6' && num[i - 1] == '6' && num[i] == '6')
			return true;
		i++;
	}

	return false;
}

int main() {
	int N;
	scanf("%d", &N);
	
	char num[60] = {0};

	int cnt = 0;
	int title = 665;
	while (cnt != N) {
		title++;

		sprintf(num, "%d", title); // =_itoa(title, num, 10);
		if (check_num(num)) {
			cnt++;
		}
	}
	printf("%d", title);
	
	return 0;
}