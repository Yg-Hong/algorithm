#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;

int main() {
	queue<int> q;
	char temp;

	int test_case, carriage;
	int totalScore;
	int score = 1;
	scanf("%d %d", &test_case, &carriage);

	for (int i = 0;i < test_case;i++) {
		totalScore = 0;

		while (true) {
			scanf("%1c", &temp);
			if (temp == '\n')
				break;

			if (temp == 'O')
				q.push(0);
			else if (temp == 'X')
				q.push(1);
		}

		while (true) {
			
			score = 1;
			while (q.front() == 0) {
				totalScore += score;
				q.pop();
				score++;

				if (q.empty())
					break;
			}
			if (q.empty())
				break;

			while (q.front() == 1) {
				q.pop();

				if (q.empty())
					break;
			}
			if (q.empty())
				break;

		}
		printf("%d\n", totalScore);

	}
}