#include<iostream>
#include<queue>

/**
 * @source: https://www.acmicpc.net/problem/12851 (숨바꼭질 2)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.1.23 (O)
 **/
#define _max 50'000'000

using namespace std;

int n, k, dp[_max+1], inf = _max * 2, cnt = 0;
queue<int> q;

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>n>>k;

    if (n == k)
    {
        cout << 0 << '\n' << 1;
        return 0;
    }

    for (int i=0;i<=_max;i++)
    {
        dp[i] = inf;
    }
    dp[n] = 0;
    q.push(n);

    while (q.size())
    {
        int f = q.front();
        q.pop();

        int cost = dp[f] + 1;

        if (cost > dp[k])
        {
            break;
        }

        int nx1 = f + 1;
        if (nx1 <= _max)
        {
            if (dp[nx1] == inf || dp[nx1] == cost)
            {
                dp[nx1] = cost;

                if (nx1 == k)
                {
                    cnt++;
                }

                q.push(nx1);
            }
        }

        int nx2 = f - 1;
        if (nx2 >= 0)
        {
            if (dp[nx2] == inf || dp[nx2] == cost)
            {
                dp[nx2] = cost;

                if (nx2 == k)
                {
                    cnt++;
                }

                q.push(nx2);
            }
        }

        int nx3 = f * 2;
        if (nx3 <= _max)
        {
            if (dp[nx3] == inf || dp[nx3] == cost)
            {
                dp[nx3] = cost;

                if (nx3 == k)
                {
                    cnt++;
                }

                q.push(nx3);
            }
        }
    }

    cout << dp[k] << '\n' << cnt;
}