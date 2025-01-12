#include <iostream>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/10798 (세로읽기)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.01.10 (O)
 **/
int main() {
  vector<char> v[5];
  string s;
  int max_len = 0;

  for(int i=0;i<5;i++) {
    cin >> s;
    for(char c : s) {
      v[i].push_back(c);
    }

    max_len = max(max_len, (int)v[i].size());
  }

  string result = "";

  for(int col=0;col<max_len;col++) {
    for(int row=0;row<5;row++) {
      if(v[row].size() <= col) continue;

      result += v[row][col];
    }
  }

  cout << result;
}