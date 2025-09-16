#include <iostream>
#include <vector>
#include <queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1766 (문제집)
 * @classification: topological sort
 * @문제 푼 날짜 (자력으로 풂?): 25.09.16 (X, 위상 정렬 까먹어서 다시 공부)
 **/
struct compareItem
{
    bool operator()(int i1, int i2) // 최소힙
    {
        return i1 > i2;
    }
};

int cnt, order_cnt, a, b;
vector<vector<int>> graph;
vector<int> topology; // 1부터 시작하니까 실수하지마라
priority_queue<int, vector<int>, compareItem> pq; // 최소힙이다

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin >> cnt >> order_cnt;

    graph.resize(cnt+1);
    topology.resize(cnt+1);


    for (int i=0;i<order_cnt;i++)
    {
        cin>>a>>b;
        topology[b]++; // 부모 수 올려
        graph[a].push_back(b); // 자식 추가
    }

    for (int i=1;i<=cnt;i++)
    {
        if (topology[i] == 0)
        {
            pq.push(i);
        }
    }

    while ( !pq.empty() )
    {
        int _top = pq.top();
        cout << _top << " ";
        pq.pop();

        for (int child : graph[_top])
        {
            topology[child]--;
            if (topology[child] == 0)
            {
                pq.push(child);
            }
        }
    }
}