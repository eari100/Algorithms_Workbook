#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2780 (비밀번호)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 25.11.05 (O)
 **/
int MOD = 1234567;

vector<vector<int>> num_map =
{
    {7},

    {2, 4},
    {1, 3, 5},
    {2, 6},

    {1, 5, 7},
    {2, 4, 6, 8},
    {3, 5, 9},

    {0, 4, 8},
    {5, 7, 9},
    {6, 8},
};

int t, n;
long long sum, dp[1000+1][10];

int main()
{
    cin>>t;

    for (int i=0;i<=9;i++)
    {
        dp[1][i] = 1;
    }

    for (int i=2;i<=1000;i++)
    {
        for (int j=0;j<=9;j++)
        {
            for (int k=0;k<num_map[j].size();k++)
            {
                dp[i][j] = (dp[i][j] + dp[i-1][num_map[j][k]]) % MOD;
            }
        }
    }

    while (t--)
    {
        cin>> n;
        sum = 0;
        for (int i=0;i<=9;i++)
        {
            sum = (sum + dp[n][i]) % MOD;
        }

        cout << sum << '\n';
    }
}
