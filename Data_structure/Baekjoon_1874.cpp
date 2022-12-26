#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <stack>
#include <vector>
#include <cmath>

using namespace std;

int seq[100001];
vector<int> v;
vector<char> result;

int main(){
	int n;
	scanf("%d", &n);

	for (int i = 0;i < n;i++) {
		scanf("%d", &seq[i]);
	}

	int ptr = 0;
	for (int i = 1;i <= n;i++) {
		v.push_back(i);
		result.push_back('+');

		while (!v.empty() && v.back() == seq[ptr]) {
			v.pop_back();
			result.push_back('-');
			ptr++;
		}
	}
	if (!v.empty())
		printf("NO");
	else 
		for (int i = 0;i < result.size();i++)
			printf("%c\n", result[i]);
	

	return 0;
}