#include <iostream>
#include <unordered_map>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/32978 (아 맞다 마늘)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.01.08 (O)
 **/
int main() {
  int n; cin >> n;
  unordered_map<string, int> map;

  for (int i = 0; i < n; i++) {
    string str; cin >> str;
    map.insert({str, 1});
  }

  for(int i = 0; i < n-1; i++) {
    string str; cin >> str;
    map.find(str) -> second--;
  }

  for(auto& entry : map) {
    if(entry.second > 0) {
      cout << entry.first;
      break;
    }
  }
}