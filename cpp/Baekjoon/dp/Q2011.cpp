#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2011 (암호코드)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 25.11.11 (X, 엣지케이스 및 깔끔 처리 이슈)
 **/
int MOD = 1'000'000;
long long dp[5000+5];
string str;
long long tmp;

int main()
{
    cin>>str;

    if (str[0] == '0')
    {
        cout<<0;
        return 0;
    }

    dp[0] = 1;
    dp[1] = 1;

    for (int i=1;i<str.size();i++)
    {
        int di = i+1;
        if (str[i] - '0' > 0)
        {
            dp[di] = dp[di-1];
        }

        int x = (str[i-1] - '0') * 10 + (str[i] - '0');
        if (x <= 26 && x >= 10)
        {
            dp[di] += dp[di-2];
            dp[di] %= MOD;
        }
    }

    cout << dp[str.size()];
}