#include<iostream>
using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/16937 (두 스티커)
 * @classification: bruteforce
 * @문제 푼 날짜 (자력으로 풂?): 25.01.05 (O)
 **/
int main() {
  int h, w, n, maxSize = 0;
  cin >> h >> w >> n;

  int stickers[n][2];

  for(int i = 0; i < n; i++) {
    int r, c;
    cin >> r >> c;

    stickers[i][0] = r;
    stickers[i][1] = c;
  }

  for(int i = 0; i < n-1; i++) {
    int r1 = stickers[i][0], c1 = stickers[i][1];

    for(int j = i+1; j < n; j++) {
      int r2 = stickers[j][0], c2 = stickers[j][1];

      int l1 = max(r1, r2);
      int l2 = c1 + c2;

      int l3 = max(r1, c2);
      int l4 = c1 + r2;

      int l5 = r1 + r2;
      int l6 = max(c1, c2);

      int l7 = r1 + c2;
      int l8 = max(c1, r2);

      if((h >= l1 && w >= l2) || (h >= l2 && w >= l1)) {
        maxSize = max(maxSize, r1 * c1 + r2 * c2);
      } else if ((h >= l3 && w >= l4) || (h >= l4 && w >= l3)) {
        maxSize = max(maxSize, r1 * c1 + r2 * c2);
      } else if ((h >= l5 && w >= l6) || (h >= l6 && w >= l5)) {
        maxSize = max(maxSize, r1 * c1 + r2 * c2);
      } else if((h >= l7 && w >= l8) || (h >= l8 && w >= l7)) {
        maxSize = max(maxSize, r1 * c1 + r2 * c2);
      }
    }
  }

  cout << maxSize;
}