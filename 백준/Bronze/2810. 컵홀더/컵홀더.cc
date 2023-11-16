#include<iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n, s = 0, l = 0;
	char seat;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> seat;
		if (seat == 'L') {
			l++;
		}
		else {
			s++;
		}
	}
	if (l > 0)l += 2;

	cout << s + l / 2;

	return 0;
}