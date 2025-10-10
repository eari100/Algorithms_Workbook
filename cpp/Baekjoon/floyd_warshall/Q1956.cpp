#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1956 (운동)
 * @classification: floyd-warshall
 * @문제 푼 날짜 (자력으로 풂?): 25.10.10 (O)
 **/
int v, e, INF = (1<<31)-1, min_dist = INF, a, b, d, dp[400+1][400+1];

int main()
{
    cin>>v>>e;

    for (int i=1;i<=v;i++)
    {
        for (int j=1;j<=v;j++)
        {
            dp[i][j] = INF;
        }
    }

    for (int i=0;i<e;i++)
    {
        cin>>a>>b>>d;
        dp[a][b] = d;
    }

    for (int k=1;k<=v;k++)
    {
        for (int i=1;i<=v;i++)
        {
            if (i == k || dp[i][k] == INF)
            {
                continue;
            }

            for (int j=1;j<=v;j++)
            {
                if (j == k || dp[k][j] == INF)
                {
                    continue;
                }

                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);
            }
        }
    }

    for (int i=1;i<=v;i++)
    {
        for (int j=1;j<=v;j++)
        {
            if (i == j)
                continue;

            if (dp[i][j] != INF && dp[j][i] != INF)
            {
                min_dist = min(min_dist, dp[i][j] + dp[j][i]);
            }
        }
    }

    cout<<(min_dist == INF ? -1 : min_dist);
}