#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2160 (그림 비교)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.06.17 (O)
 **/
bool board[50][5][7];
int min_diff = 36, a, b;

int main()
{
  int n;
  cin >> n;

  for(int i=0;i<n;i++)
  {
    for(int j=0;j<5;j++)
    {
      string data;
      cin >> data;
      for(int k=0;k<7;k++)
      {
        board[i][j][k] = (data[k] == '.');
      }
    }
  }

  for(int i=0;i<n-1;i++)
  {
    for(int j=i+1;j<n;j++)
    {
      int diff = 0;

      for(int k=0;k<5;k++)
      {
        for(int l=0;l<7;l++)
        {
          if(board[i][k][l] != board[j][k][l])
          {
            diff++;
          }
        }
      }

      if(diff < min_diff)
      {
        min_diff = diff;
        a = i+1, b = j+1;
      }
    }
  }

  cout << a << ' ' << b;
}