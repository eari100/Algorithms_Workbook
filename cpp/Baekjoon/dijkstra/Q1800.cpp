#include<iostream>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1800 (인터넷 설치)
 * @classification: dijkstra
 * @문제 푼 날짜 (자력으로 풂?): 25.11.30 (O, 매개변수 + 다익스트라가 정해라고 함. 어떻게 내가 이걸 풀었는 지 신기함.)
 **/
struct comp
{
    // cost 작은 거 부터
    bool operator()(vector<long long> a, vector<long long> b)
    {
        return a[1] > b[1];
    }
};

long long INF = (1ULL<<63)-1;
long long n, p, k, dist[1000+1][1000+1], a, b, d;
priority_queue<vector<long long>, vector<vector<long long>>, comp> pq; // node, cost, remain free
vector<vector<vector<long long>>> graph;
long long answer = INF;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>n>>p>>k;
    graph.resize(n+1);

    for (int i=2;i<=n;i++)
    {
        for (int j=0;j<=k;j++)
        {
            dist[i][j] = INF;
        }
    }

    for (int i=0;i<p;i++)
    {
        cin>>a>>b>>d;

        graph[a].push_back({b, d});
        graph[b].push_back({a, d});
    }

    pq.push({1, 0, k});

    while (pq.size())
    {
        vector<long long> f = pq.top();
        pq.pop();

        long long curr = f[0];
        long long curr_cost = f[1];
        long long remain_free = f[2];

        for (vector<long long> v : graph[curr])
        {
            long long next = v[0];
            long long next_cost = v[1];

            long long cost1 = max(curr_cost, next_cost);

            // 케이블비 지불
            if (dist[next][remain_free] > cost1)
            {
                dist[next][remain_free] = cost1;
                pq.push({next, dist[next][remain_free], remain_free});
            }

            if (remain_free)
            {
                // 공짜로 이용
                if (dist[next][remain_free-1] > curr_cost)
                {
                    dist[next][remain_free-1] = curr_cost;
                    pq.push({next, dist[next][remain_free-1], remain_free-1});
                }
            }
        }
    }

    for (int i=0;i<=k;i++)
    {
        answer = min(answer, dist[n][i]);
    }

    cout << (answer == INF ? -1 : answer);
}