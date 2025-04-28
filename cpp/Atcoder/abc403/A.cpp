#include <iostream>

using namespace std;

/**
 * @source: https://atcoder.jp/contests/abc403/tasks/abc403_a (A - Odd Position Sum)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.04.27 (O)
 **/
int main() {
    int n;
    cin >> n;
    int sum = 0, num;

    for(int i=1;i<=n;i++) {
        cin >> num;
        if(i % 2 != 0) {
            sum += num;
        }
    }

    cout << sum;
}