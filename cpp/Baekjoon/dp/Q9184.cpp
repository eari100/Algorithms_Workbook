#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/9184 (신나는 함수 실행)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 25.09.19 (O)
 **/
int dp[50+1][50+1][50+1];
bool visited[50+1][50+1][50+1];

int bt(int a, int b, int c)
{
  if (a <= 0 || b <= 0 || c <= 0)
  {
    return 1;
  }

  if(visited[a][b][c])
  {
    return dp[a][b][c];
  }

  if(a > 20 || b > 20 || c > 20)
  {
    dp[a][b][c] = bt(20, 20, 20);
    visited[a][b][c] = true;
  }
  else if(a < b and b < c)
  {
    dp[a][b][c] = bt(a, b, c-1) + bt(a, b-1, c-1) - bt(a, b-1, c);
    visited[a][b][c] = true;
  }
  else
  {
    dp[a][b][c] = bt(a-1, b, c) + bt(a-1, b-1, c) + bt(a-1, b, c-1) - bt(a-1, b-1, c-1);
    visited[a][b][c] = true;
  }

  return dp[a][b][c];
}

int main()
{
  int a, b, c;

  while(1)
  {
    cin>>a>>b>>c;

    if(a==-1 && b==-1 && c==-1)
    {
      break;
    }

    cout << "w(" << a <<", " << b << ", " << c << ") = " << bt(a, b, c) << '\n';
  }
}