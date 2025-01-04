#include <iostream>
#include <cmath>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/32930 (슈팅 연습)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.01.04 (O)
 **/
int main() {
  const int ix = 101, iy = 101;
  int n, m;
  cin >> n >> m;

  int show[n][2];
  int prevX = 0, prevY = 0;

  for(int i=0;i<n;i++) {
    int x, y;
    if(cin >> x >> y) {
      show[i][0] = x;
      show[i][1] = y;
    } else {
      show[i][0] = ix;
      show[i][1] = iy;
    }
  }

  int maxIdx = 0;
  int maxDist = 0;
  int score = 0;

  while(m > 0) {
    for(int i=0;i<n;i++) {
      int x = show[i][0];
      int y = show[i][1];

      if(x == ix && y == iy) {
        continue;
      }

      int dist = abs(pow(x - prevX, 2) + pow(y - prevY, 2));

      if(dist > maxDist) {
        maxDist = dist;
        maxIdx = i;
      }
    }

    score += maxDist;
    maxDist = 0;
    prevX = show[maxIdx][0];
    prevY = show[maxIdx][1];
    --m;

    if(m == 0) {
      break;
    }

    int x, y;
    cin >> x >> y;

    show[maxIdx][0] = x;
    show[maxIdx][1] = y;
  }

  cout << score;
}