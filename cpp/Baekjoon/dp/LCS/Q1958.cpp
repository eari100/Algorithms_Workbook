#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1958 (LCS 3)
 * @classification: LCS
 * @문제 푼 날짜 (자력으로 풂?): 25.11.15 (O)
 **/
string s1, s2, s3;
int dp[100+1][100+1][100+1];

int main()
{
    cin>>s1>>s2>>s3;

    for (int i=1;i<=s1.size();i++)
    {
        for (int j=1;j<=s2.size();j++)
        {
            for (int k=1;k<=s3.size();k++)
            {
                dp[i][j][k] = max(dp[i][j][k], dp[i-1][j][k]);
                dp[i][j][k] = max(dp[i][j][k], dp[i][j-1][k]);
                dp[i][j][k] = max(dp[i][j][k], dp[i][j][k-1]);
                int a = dp[i-1][j-1][k-1];

                if (s1[i-1] == s2[j-1] && s2[j-1] == s3[k-1])
                {
                    a++;
                }

                dp[i][j][k] = max(dp[i][j][k], a);
            }
        }
    }

    cout << dp[s1.size()][s2.size()][s3.size()];
}