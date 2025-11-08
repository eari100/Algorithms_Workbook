#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/20303 (할로윈의 양아치)
 * @classification: knapsack
 * @문제 푼 날짜 (자력으로 풂?): 25.11.08 (X)
 **/
int n, m, k, candies[30'000], a, b;
vector<vector<int>> graph;
vector<vector<int>> costs; // 사탕 수, 친구 수
bool visited[30'000];
long long dp[3000]; // max k
long long max_candy = 0;
int tmp_candy, tmp_human;

void bt(int curr)
{
    visited[curr] = 1;
    tmp_candy += candies[curr];
    tmp_human++;

    for (int i=0;i<graph[curr].size();i++)
    {
        int next = graph[curr][i];

        if (!visited[next])
        {
            bt(next);
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>n>>m>>k;

    graph.resize(n);

    for(int i=0;i<n;i++)
    {
        cin>>candies[i];
    }

    for(int i=0;i<m;i++)
    {
        cin>>a>>b;
        a--;
        b--;

        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    for (int i=0;i<n;i++)
    {
        if ( !visited[i] )
        {
            tmp_candy = 0, tmp_human = 0;
            bt(i);

            if (tmp_human < k)
            {
                costs.push_back({tmp_candy, tmp_human});
            }
        }
    }

    for (int i=0;i<costs.size();i++)
    {
        vector<int> v = costs[i];

        for (int j=k-1;j>=v[1];j--)
        {
            dp[j] = max(dp[j], dp[j-v[1]] + v[0]);
            max_candy = max(max_candy, dp[j]);
        }
    }

    cout << max_candy;
}