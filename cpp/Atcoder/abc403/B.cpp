#include <iostream>

using namespace std;

/**
 * @source: https://atcoder.jp/contests/abc403/tasks/abc403_b (B - Four Hidden)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.04.27 (O)
 **/
int main() {
  string t, u;
  cin >> t >> u;

  for(int i=0;i<=t.length() - u.length();i++) {
    int tmp = 0;
    for(int j=i;j<i+u.length();j++) {

      if(t[j] == '?' || t[j] == u[j-i]) {
        tmp++;
      } else {
        break;
      }
    }

    if (tmp == u.length()) {
      cout << "Yes";
      return 0;
    }
  }

  cout << "No";
}