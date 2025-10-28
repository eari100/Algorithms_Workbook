#include<iostream>
#include<vector>

/**
 * @source: https://www.acmicpc.net/problem/1325 (효율적인 해킹)
 * @classification: dfs
 * @문제 푼 날짜 (자력으로 풂?): 25.10.28 (X)
 **/
#define max_com 10000

using namespace std;

int n, m, a, b, com[max_com], max_t = 0, cost;
vector<vector<int>> g;
vector<int> trust, visited;

void bt(int curr)
{
    ++cost;
    visited[curr] = 1;

    for (int i=0;i<g[curr].size();i++)
    {
        if (visited[g[curr][i]]) continue;

        bt(g[curr][i]);
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>n>>m;
    g.resize(n);
    trust.resize(n, 0);
    visited.resize(n);

    for (int i=0;i<m;i++)
    {
        cin>>a>>b;
        g[b-1].push_back(a-1);
    }

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
            visited[j] = 0;
        }

        cost = 0;
        bt(i);

        trust[i] = cost;
        max_t = max(max_t, cost);
    }

    for (int i=0;i<n;i++)
    {
        if (max_t == trust[i])
        {
            cout << i+1 << " ";
        }
    }
}