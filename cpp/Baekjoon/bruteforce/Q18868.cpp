#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/18868 (멀티버스 Ⅰ)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.04.12 (O)
 **/
int main()
{
  int m, n, answer = 0;
  cin>>m>>n;
  int arr[m][n];

  for(int i=0;i<m;i++)
  {
    for(int j=0;j<n;j++)
    {
      cin>>arr[i][j];
    }
  }

  for (int i=0;i<m-1;i++)
  {
    for (int j=i+1;j<m;j++)
    {
      for (int k=0;k<n-1;k++)
      {
        for (int l=k+1;l<n;l++)
        {
          if
          (
            !
            (
              (arr[i][k] < arr[i][l] && arr[j][k] < arr[j][l]) ||
              (arr[i][k] == arr[i][l] && arr[j][k] == arr[j][l]) ||
              (arr[i][k] > arr[i][l] && arr[j][k] > arr[j][l])
            )
          )
          {
            goto next_j;
          }

          if (k == n-2 && l == n-1)
          {
            ++answer;
          }
        }
      }
      next_j:;
    }
  }

  cout<<answer;
}