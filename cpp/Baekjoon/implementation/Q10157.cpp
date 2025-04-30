#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/10157 (자리배정)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.04.30 (O)
 **/
int main()
{
  int r, c, order;
  cin >> r >> c >> order;

  if (order > r * c)
  {
    cout <<  0;
    return 0;
  }

  vector<vector<bool>> visited(c, vector<bool>(r, false));

  int moves[4][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  int move_index = 0;
  int x = -1, y = 0;

  while(order-- > 0)
  {
    int x2 = x + moves[move_index][0], y2 = y + moves[move_index][1];

    if(x2 < 0 || y2 < 0 || x2 >= c || y2 >= r || visited[x2][y2])
    {
      move_index = (move_index + 1) % 4;
      order++;
      continue;
    }

    x = x2, y = y2;
    visited[x][y] = true;
  }

  cout << (y+1) << " " << (x+1);
}