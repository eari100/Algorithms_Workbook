#include <iostream>
#include <queue>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/11559 (Puyo Puyo)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.07.27 (X, down 로직 애매해서 다른 소스 참고)
 **/
int main()
{
  queue<vector<int>> removes;
  queue<vector<int>> remove_one;
  queue<vector<int>> que;
  char board[12][6];
  bool visited[12][6];
  int pop_cnt = 0, moves[4][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  for (int i = 0; i < 12; i++)
  {
    for (int j = 0; j < 6; j++)
    {
      cin >> board[i][j];
    }
  }

  while(true)
  {
    for(int i = 0; i < 12; i++)
    {
      for(int j = 0; j < 6; j++)
      {
        visited[i][j] = false;
      }
    }

    for(int i = 0; i < 12; i++)
    {
      for(int j = 0; j < 6; j++)
      {
        char type = board[i][j];

        if(visited[i][j] || type == '.')
        {
          continue;
        }

        visited[i][j] = true;
        que.push({i, j});
        remove_one.push({i, j});

        while(que.size() > 0)
        {
          vector<int> _front = que.front();
          que.pop();

          for(int k=0; k<4; k++)
          {
            int x = _front[0] + moves[k][0];
            int y = _front[1] + moves[k][1];

            if(x < 0 || x >= 12 || y < 0 || y >= 6 || visited[x][y] || board[x][y] != type) continue;

            visited[x][y] = true;
            que.push({x, y});
            remove_one.push({x, y});
          }
        }

        if(remove_one.size() >= 4)
        {
          while(remove_one.size() > 0)
          {
            removes.push(remove_one.front());
            remove_one.pop();
          }
        }
        else
        {
          while(remove_one.size() > 0)
          {
            remove_one.pop();
          }
        }
      }
    }

    if(removes.size() == 0) break;

    ++pop_cnt;

    while(removes.size() > 0)
    {
      vector<int> _front = removes.front();
      removes.pop();

      board[_front[0]][_front[1]] = '.';
    }

    // donw
    for(int i = 0; i < 6; i++)
    {
      for(int j = 10; j >= 0; j--)
      {
        for (int k=j;k<11;k++)
        {
          if (board[k][i] != '.' && board[k+1][i] == '.')
          {
            char _type = board[k][i];
            board[k][i] = '.';
            board[k+1][i] = _type;
          }
        }
      }
    }


    // print
    // cout << "==========="<< endl;
    // for (int i = 0; i < 12; i++)
    // {
    //   for (int j = 0; j < 6; j++)
    //   {
    //     cout << board[i][j] << ' ';
    //   }
    //
    //   cout << endl;
    // }
  }

  cout << pop_cnt;
}