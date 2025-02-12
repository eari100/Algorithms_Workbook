#include <stdio.h>
#include <stdlib.h>

int *dp, **backpack;

/**
 * @source: https://www.acmicpc.net/problem/12865 (평범한 배낭)
 * @classification: knapsack
 * @문제 푼 날짜 (자력으로 풂?): 25.02.12 (X)
 **/
int main()
{
  int n, k;
  scanf("%d %d", &n, &k);

  dp = (int *)malloc((k+1) * sizeof(int));
  if(!dp) return 1; // 메모리 할당 실패 시 종료
  for(int i=0;i<k+1;i++) // 초기화
  {
    dp[i] = 0;
  }

  backpack = (int**)malloc(n * sizeof(int*));
  if(!backpack) return 1;
  for(int i=0;i<n;i++)
  {
    backpack[i] = (int *)malloc(2 * sizeof(int));
    if(!backpack[i]) return 1;

    scanf("%d %d", &backpack[i][0], &backpack[i][1]);
  }

  for (int i=0;i<n;i++)
  {
    int w = backpack[i][0];
    int v = backpack[i][1];

    for (int j=k;j>=w;j--)
    {
        if (dp[j] < dp[j-w] + v)
        {
          dp[j] = dp[j-w] + v;
        }
    }
  }

  printf("%d\n", dp[k]);

  free(dp);
  for(int i=0;i<n;i++)
  {
    free(backpack[i]);
  }
  free(backpack);
}