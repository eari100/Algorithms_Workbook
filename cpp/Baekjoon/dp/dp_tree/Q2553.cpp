#include<iostream>
#include<vector>

#define _total 1'000'001

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2533 (사회망 서비스(SNS))
 * @classification: dp_tree
 * @문제 푼 날짜 (자력으로 풂?): 25.12.11 (X)
 **/
int n, u, v;
vector<int> g[_total];
int dp[_total][2];
bool visited[_total];

void solve(int curr)
{
    visited[curr] = true;
    dp[curr][0] = 1;

    for (int next : g[curr])
    {
        if (visited[next])
        {
            continue;
        }

        solve(next);

        dp[curr][0] += min(dp[next][0], dp[next][1]);
        dp[curr][1] += dp[next][0];
    }
}

int main()
{
    cin>>n;

    for (int i=0;i<n-1;i++)
    {
        cin>>u>>v;
        g[u].push_back(v);
        g[v].push_back(u);
    }

    solve(1);

    cout<<min(dp[1][0], dp[1][1]);
}