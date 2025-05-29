#include<iostream>
#include<queue>

using namespace std;

int INF = 2e9;

struct Compare {
  bool operator() (vector<int>& a, vector<int>& b)
  {
    return a[2] > b[2];
  }
};

/**
 * @source: https://www.acmicpc.net/problem/4485 (녹색 옷 입은 애가 젤다지?)
 * @classification: dijkstra
 * @문제 푼 날짜 (자력으로 풂?): 25.05.29 (O)
 **/
int main()
{
  int n, board[125+1][125+1], dists[125+1][125+1], moves[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}, num = 1;
  priority_queue<vector<int>, vector<vector<int>>, Compare> pq;

  while (1)
  {
    cin>>n;

    if (n == 0) break;

    for(int i=1;i<=n;i++)
    {
      for(int j=1;j<=n;j++)
      {
        cin>>board[i][j];
      }
    }

    for(int i=1;i<=n;i++)
      for(int j=1;j<=n;j++)
        dists[i][j] = INF;

    dists[1][1] = board[1][1];

    pq.push({1, 1, board[1][1]});

    while ( !pq.empty() )
    {
      vector<int> _top = pq.top();
      pq.pop();

      int x1 = _top[0], y1 = _top[1];

      for (int i=0;i<4;i++)
      {
        int x2 = x1+moves[i][0], y2 = y1+moves[i][1];

        if (x2 <= 0 || y2 <= 0 || x2 > n || y2 > n) continue;

        if (dists[x2][y2] > dists[x1][y1] + board[x2][y2])
        {
          dists[x2][y2] = dists[x1][y1] + board[x2][y2];
          pq.push({x2, y2, board[x2][y2]});
        }
      }
    }

    cout << "Problem " << num++ << ": " << dists[n][n] << '\n';
  }
}