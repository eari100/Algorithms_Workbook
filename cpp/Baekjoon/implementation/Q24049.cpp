#include <iostream>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/24049 (정원 (Easy))
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.07.03 (O)
 **/
int main()
{
  int n, m;
  cin >> n >> m;
  vector<vector<int>> board(n+1, vector<int>(m+1));

  for (int i=1;i<=n;i++)
  {
   cin >> board[i][0];
  }

  for (int i=1;i<=m;i++)
  {
    cin >> board[0][i];
  }

  for (int i=1;i<=n;i++)
  {
    for (int j=1;j<=m;j++)
    {
       if (board[i-1][j] == board[i][j-1])
         board[i][j] = 0;
      else
        board[i][j] = 1;
    }
  }

  cout << board[n][m] << endl;
}