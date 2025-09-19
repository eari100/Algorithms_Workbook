#include<iostream>
#include<queue>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1726 (로봇)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.09.20 (O)
 **/
queue<vector<int>> q; // 세로, 가로, 방향, count
int h, w;
int board[100+1][100+1];
int visited[100+1][100+1][4];
int target[3];
int start[3];
// 동, 서, 남, 북
int moves[4][2] =
{
  {0, 1}, {0, -1}, {1, 0}, {-1, 0}
};
int INF = 40'005;

int left_dir(int dir)
{
  if(dir == 0) // 동
  {
    return 3; // 북
  }
  else if(dir == 1) // 서
  {
    return 2;
  }
  else if(dir == 2) // 남
  {
    return 0;
  }
  else // 북
  {
    return 1; // 서
  }
}

int right_dir(int dir)
{
  if(dir == 0) // 동
  {
    return 2; // 남
  }
  else if(dir == 1) // 서
  {
    return 3;
  }
  else if(dir == 2) // 남
  {
    return 1;
  }
  else // 북
  {
    return 0; // 서
  }
}

int main()
{
  cin >> h >> w;

  for(int i=0;i<h;i++)
  {
    for(int j=0;j<w;j++)
    {
      cin>>board[i][j];

      for(int k=0;k<4;k++)
      {
        visited[i][j][k] = INF;
      }
    }
  }

  cin>>start[0]>>start[1]>>start[2];
  start[0]--;
  start[1]--;
  start[2]--;

  cin>>target[0]>>target[1]>>target[2];
  target[0]--;
  target[1]--;
  target[2]--;

  visited[start[0]][start[1]][start[2]] = 0;
  q.push({start[0],start[1],start[2], 0});

  while(!q.empty())
  {
    vector<int> _front = q.front();
    q.pop();

    if(_front[0] == target[0] && _front[1] == target[1] && _front[2] == target[2])
    {
      break;
    }

    // 전진
    for (int i=1;i<=3;i++)
    {
      int next_h = _front[0] + moves[_front[2]][0] * i;
      int next_w = _front[1] + moves[_front[2]][1] * i;

      if(next_h >= 0 && next_h < h && next_w >= 0 && next_w < w)
      {
        // 장애물 만나면 탈출
        if (board[next_h][next_w]) break;

        if(visited[next_h][next_w][_front[2]] > _front[3]+1)
        {
          visited[next_h][next_w][_front[2]] = _front[3]+1;
          q.push({next_h, next_w, _front[2], _front[3]+1});
        }
      }
      else
      {
        break;
      }
    }

    // 왼쪽
    int ld = left_dir(_front[2]);
    if(visited[_front[0]][_front[1]][ld] > _front[3]+1)
    {
      visited[_front[0]][_front[1]][ld] = _front[3]+1;
      q.push({_front[0], _front[1], ld, _front[3]+1});
    }

    // 오른쪽
    int rd = right_dir(_front[2]);
    if(visited[_front[0]][_front[1]][rd] > _front[3]+1)
    {
      visited[_front[0]][_front[1]][rd] = _front[3]+1;
      q.push({_front[0], _front[1], rd, _front[3]+1});
    }
  }

  cout << visited[target[0]][target[1]][target[2]];
}