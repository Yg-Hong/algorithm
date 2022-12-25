#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <vector>
#include <cmath>

using namespace std;


int main() {
	int N;
	int kim, lim;
	int nor = 1;
	scanf("%d %d %d", &N, &kim, &lim);

	while (true) {
		if (kim % 2 == 1 && lim % 2 == 1) {
			kim = (kim + 1) / 2;
			lim = (lim + 1) / 2;
			nor++;
			continue;
		}
		else if (kim % 2 == 0 && lim % 2 == 0) {
			kim /= 2;
			lim /= 2;
			nor++;
			continue;
		}
		int odd = (kim % 2 == 1) ? kim : lim;
		int even = (kim % 2 == 1) ? lim : kim;
		
		if (even - odd == 1) {
			printf("%d", nor);
			break;
		}
		else{
			kim = even / 2;
			lim = (odd + 1) / 2;
			nor++;
			continue;
		}
	}

	return 0;
}