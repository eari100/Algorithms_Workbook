#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/11653 (소인수분해)
 * @classification: bruteforce
 * @문제 푼 날짜 (자력으로 풂?): 25.01.09 (O)
 **/
int main() {
  int n;
  cin>>n;
  int x = n;

  while(x > 1) {
    for(int i=2;i<=x;i++) {
      if (i == x) {
        x /= i;
        cout << i << '\n';
        break;
      }

      if(x % i == 0) {
        x /= i;
        cout << i << '\n';
        break;
      }
    }
  }
}
