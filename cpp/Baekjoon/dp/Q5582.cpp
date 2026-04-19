#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/5582 (공통 부분 문자열)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 26.04.19 (O)
 **/
string a,b;
int dp[4000+1][4000+1], max_len=0;;

int main()
{
    cin>>a>>b;

    for (int i=0;i<a.size();i++)
    {
        for (int j=0;j<b.size();j++)
        {
            if (a[i]==b[j])
            {
                dp[i+1][j+1] = dp[i][j] + 1;
                max_len = max(max_len, dp[i+1][j+1]);
            }
        }
    }

    cout<<max_len;
}