#include <iostream>
#include <vector>
#include <deque>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/3190 (뱀)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.08.03 (O)
 **/
int main()
{
  deque<vector<int>> snake = {{0, 0}};
  int moves[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  int n, apple_cnt, /*head[2] = {0,0}, tale[2] = {0,0}, */ time = 0, move_index=0;
  int log_index = 0;
  cin>>n>>apple_cnt;
  // 뱀: 1, 빈공간:0, 사과: 2
  int board[n][n];
  for (int i = 0; i < n; i++)
  {
    for (int j = 0; j < n; j++)
    {
      board[i][j] = 0;
    }
  }
  board[0][0] = 1;

  for(int i=0;i<apple_cnt;i++)
  {
    int x, y;
    cin>>x>>y;

    board[x-1][y-1] = 2;
  }

  int log_size;
  cin >> log_size;
  // 0: 왼쪽 L, 1: 오른쪽: D
  int logs[log_size][2];

  for(int i=0;i<log_size;i++)
  {
    cin >>logs[i][0];
    char dir;
    cin >> dir;
    if(dir == 'L')
    {
      logs[i][1] = 0;
    }
    else
    {
      logs[i][1] = 1;
    }
  }

  while(true)
  {
    time++;

    // 머리위치 반영
    vector<int> head = snake.front();
    head[0] += moves[move_index][0];
    head[1] += moves[move_index][1];

    if(head[0] < 0 || head[0] >= n || head[1] < 0 || head[1] >= n || board[head[0]][head[1]] == 1)
    {
      break;
    }
    snake.push_front(head);

    //cout << "?? " << board[head[0]][head[1]] << endl;
    // 그림 반영
    if(board[head[0]][head[1]] == 2)
    {
      board[head[0]][head[1]] = 1;
    }
    else
    {
      board[head[0]][head[1]] = 1;
      board[snake.back()[0]][snake.back()[1]] = 0;
      snake.pop_back();
    }

    // print
    // cout << "-----------" << endl;
    // cout << "time = " << time << endl;
    // for (int i=0;i<n;i++)
    // {
    //   for (int j=0;j<n;j++)
    //   {
    //     cout << board[i][j] << ' ';
    //   }
    //   cout << endl;
    // }


    // 조작 시점
    if(log_index < log_size && time == logs[log_index][0])
    {
      if(logs[log_index][1] == 0) // 왼
      {
        move_index--;

        if(move_index == -1)
        {
          move_index = 3;
        }
      }
      else
      {
        move_index++;
        move_index %= 4;
      }

      log_index++;
    }
  }

  cout << time;
}