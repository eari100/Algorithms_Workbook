#include <iostream>
using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/11659 (구간 합 구하기 4)
 * @classification: cumulative sum
 * @문제 푼 날짜 (자력으로 풂?): 25.01.03 (O)
 **/
int main() {
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    int n, m;

    cin >> n >> m;
    int arr[100001] = {};

    for (int i=1;i<=n;i++) {
        int curr;
        cin >> curr;
        arr[i] = arr[i-1] + curr;
    }

    for (int i=0;i<m;i++) {
        int str, end;
        cin >> str >> end;
        cout << arr[end] - arr[str-1] << "\n";
    }
}