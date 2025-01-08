#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2386 (도비의 영어 공부)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.01.08 (O)
 * @reference: https://www.acmicpc.net/source/46572316 (대소문자 변환 비트 연산)
 **/
int main() {
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);

  while(true) {
    char c;
    string s;
    int count = 0;

    cin >> c;

    if(c == '#') {
      break;
    }

    getline(cin, s);

    int i1 = (int) c;

    if(c > 90) {
      i1 -= 32;
    }

    for(auto c : s) {
      int i = (int) c;

      if(i > 90) {
        i -= 32;
      }

      if(i1 == i) {
        ++count;
      }
    }

    cout << c << ' ' << count << endl;
  }
}
