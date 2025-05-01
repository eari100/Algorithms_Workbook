#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/3085 (사탕 게임)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.05.02 (O)
 **/
int main()
{
  int n, _max = 0;
  cin >> n;
  char candies[n][n];

  for(int i=0;i<n;i++)
  {
    for(int j=0;j<n;j++)
    {
      cin >> candies[i][j];
    }
  }

  int a[2][2] = {{1, 0}, {0, 1}};

  for(int i=0;i<n;i++)
  {
    for(int j=0;j<n-1;j++)
    {
      for(int k=0;k<2;k++)
      {
        if(i+a[k][0] < n && candies[i][j] != candies[i+a[k][0]][j+a[k][1]])
        {
          candies[i][j] ^= candies[i+a[k][0]][j+a[k][1]] ^= candies[i][j] ^= candies[i+a[k][0]][j+a[k][1]];

          for(int l=0;l<n;l++)
          {
            for(int m=0;m<n;m++)
            {
              char color = candies[l][m];
              int len1 = 1, len2 = 1;

              for (int o=m+1;o<n;o++)
              {
                if (color != candies[l][o])
                {
                  break;
                }
                ++len1;
              }
              for (int o=m-1;o>=0;o--)
              {
                if (color != candies[l][o])
                {
                  break;
                }
                ++len1;
              }


              for (int o=l+1;o<n;o++)
              {
                if (color != candies[o][m])
                {
                  break;
                }
                ++len2;
              }
              for (int o=l-1;o>=0;o--)
              {
                if (color != candies[o][m])
                {
                  break;
                }
                ++len2;
              }

              int longer = max(len1, len2);
              if (longer == n)
              {
                cout << longer;
                return 0;
              }

              _max = max(_max, longer);
            }
          }

          candies[i][j] ^= candies[i+a[k][0]][j+a[k][1]] ^= candies[i][j] ^= candies[i+a[k][0]][j+a[k][1]];
        }
      }
    }
  }

  cout << _max;
}