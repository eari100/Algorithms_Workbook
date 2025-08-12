#include <iostream>
#include <vector>
#include <queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2623 (음악프로그램)
 * @classification: topological sort
 * @문제 푼 날짜 (자력으로 풂?): 25.08.12 (X)
 **/
int main()
{
    int n,m;
    cin>>n>>m;

    vector<vector<int>> g(n+1);
    vector<int> topology(n+1);
    vector<int> answer;

    for (int i=0;i<m;i++)
    {
        int cnt;
        cin>>cnt;
        int temp[cnt];
        for (int j=0;j<cnt;j++)
        {
            cin>>temp[j];
        }

        for (int j=0;j<cnt;j++)
        {
            for (int k=j+1;k<cnt;k++)
            {
                g[temp[j]].push_back(temp[k]);
                topology[temp[k]]++;
            }
        }
    }

    queue<int> q;
    for (int i=1;i<=n;i++)
    {
        if (topology[i] == 0)
        {
            q.push(i);
        }
    }

    while(!q.empty())
    {
        int curr = q.front();
        answer.push_back(curr);
        q.pop();

        for (int next : g[curr])
        {
            topology[next]--;

            if (topology[next] == 0)
            {
                q.push(next);
            }
        }
    }

    if (answer.size()==n)
    {
        for (int a : answer)
        {
            cout<<a<<'\n';
        }
    }
    else
    {
        cout << 0;
    }
}