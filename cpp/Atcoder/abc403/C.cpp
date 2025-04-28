#include <iostream>
#include <unordered_map>
#include <set>

using namespace std;

/**
 * @source: https://atcoder.jp/contests/abc403/tasks/abc403_c (C - 403 Forbidden)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.04.27 (O)
 **/
int main() {
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);

  int n, m, q;
  cin >> n >> m >> q;

  unordered_map<int, set<int>> map;
  set<int> root;

  for(int i = 1; i <= q; i++) {
    int t, user, page;
    cin >> t >> user;

    if(t == 1) {
      cin >> page;
      map[user].insert(page);
    } else if(t == 2) {
      root.insert(user);
    } else if(t == 3) {
      cin >> page;

      if(root.count(user)) {
        cout << "Yes" << '\n';
      } else {
        if(map[user].count(page))
        {
          cout << "Yes" << '\n';
        }
        else
        {
          cout << "No" << '\n';
        }
      }
    }
  }
}