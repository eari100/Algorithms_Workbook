#include <iostream>
#include <queue>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2638 (치즈)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.07.29 (O)
 **/
int main()
{
  int h, w, cheese_cnt = 0, round = 0, moves[4][2] = {{-1,0}, {0,1}, {1,0}, {0,-1}};
  cin>>h>>w;
  int count[h][w];
  bool board[h][w];
  queue<vector<int>> remove;
  queue<vector<int>> _queue;

  for(int i=0;i<h;i++)
  {
    for(int j=0;j<w;j++)
    {
      if(i == 0 || i == h-1 || j == 0 || j == w-1)
      {
        count[i][j] = 1;
        _queue.push({i, j});
      }
      else
      {
        count[i][j] = 0;
      }

      cin >> board[i][j];

      if(board[i][j])
      {
        ++cheese_cnt;
      }
    }
  }

  while (cheese_cnt > 0)
  {
    while(_queue.size() > 0)
    {
      vector<int> _front = _queue.front();
      _queue.pop();

      for(int i=0;i<4;i++)
      {
        int x = _front[0] + moves[i][0];
        int y = _front[1] + moves[i][1];

        if(x < 0 || x >= h || y < 0 || y >= w) continue;
        if(count[x][y] == 0) // 미방문
        {
          if(!board[x][y]) // 공기
          {
            _queue.push({x, y});
          }

          count[x][y]++;
        }
        else // 방문
        {
          if(board[x][y]) // 치즈
          {
            count[x][y]++;

            if(count[x][y] == 2) // 두번 방문만 remove 에 저장
            {
              remove.push({x, y});
            }
          }
        }
      }
    }

    round++;
    cheese_cnt -= remove.size();
    while(remove.size() > 0)
    {
      vector<int> _front2 = remove.front();
      _queue.push({_front2[0], _front2[1]});
      board[_front2[0]][_front2[1]] = false;
      count[_front2[0]][_front2[1]] = 1;
      remove.pop();
    }
  }

  cout<<round;
}