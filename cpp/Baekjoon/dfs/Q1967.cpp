#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1967 (트리의 지름)
 * @classification: dfs
 * @문제 푼 날짜 (자력으로 풂?): 25.12.10 (X)
 * @증명: https://blog.myungwoo.kr/112
 **/
vector<vector<vector<int>>> graph;
int n, a, b, c, answer = 0;
int farthest_node;

void solve(int curr, int parent, int len1)
{
    for (vector<int> v : graph[curr])
    {
        if (parent == v[0])
        {
            continue;
        }

        int len2 = len1 + v[1];
        if (answer < len2)
        {
            answer = len2;
            farthest_node = v[0];
        }

        solve(v[0], curr, len2);
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>n;

    graph.resize(n+1);

    for (int i=1;i<n;i++)
    {
        cin>>a>>b>>c;
        graph[a].push_back({b, c});
        graph[b].push_back({a, c});
    }

    solve(1, 1, 0);
    solve(farthest_node, farthest_node, 0);

    cout<<answer;
}