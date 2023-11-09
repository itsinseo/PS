#include<iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int t;
	int a = 0, b = 0, c = 0;

	cin >> t;
	if (t % 10 != 0) {
		cout << -1;
	}
	else {
		if (t >= 300) {
			a = t / 300;
			t -= a * 300;
		}
		if (t >= 60) {
			b = t / 60;
			t -= b * 60;
		}
		if (t >= 10) {
			c = t / 10;
			t -= c * 10;
		}
		cout << a << ' ' << b << ' ' << c;
	}

	return 0;
}