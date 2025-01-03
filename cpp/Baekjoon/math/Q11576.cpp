#include <iostream>
#include <math.h>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/11576 (Base Conversion)
 * @classification: math
 * @문제 푼 날짜 (자력으로 풂?): 25.01.04 (X, 진법 변환 코드 짜는데 새벽이라 잠와서 chatGPT 씀)
 **/
int main() {
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    int a, b, m;

    cin >> a >> b >> m;

    int y = 0;

    for (int i=m-1;i>=0;i--) {
        int x;
        cin >> x;
        y += pow(a, i) * x;
    }

    vector<int> vec;

    while (y > 0) {
        const int remain = y % b;

        vec.push_back(remain);
        y /= b;
    }

    if (vec.empty()) {
        cout << 0;
    } else {
        for (int i = vec.size()-1;i>=0;i--) {
            cout << vec[i] << " ";
        }
    }
}