#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1707 (이분 그래프)
 * @classification: dfs
 * @문제 푼 날짜 (자력으로 풂?): 25.10.16 (O)
 **/
int t, v, e, a, b, type[20'000+1];
vector<vector<int>> g;

bool _s(int curr, int curr_type)
{
    if (type[curr] == 0)
    {
        type[curr] = curr_type;
    }
    else if (type[curr] == curr_type)
    {
        return true;
    }
    else
    {
        return false;
    }

    int next_type = curr_type == 1 ? 2 : 1;

    for (int i=0;i<g[curr].size();i++)
    {

        if (!_s(g[curr][i], next_type))
        {
            return false;
        }
    }

    return true;
}

int main()
{
    cin>>t;

    while(t--)
    {
        cin>>v>>e;

        if (v <= 2)
        {
            cout<<"YES"<<'\n';
            continue;
        }

        for (int i=1;i<=v;i++)
        {
            type[i] = 0;
        }
        g.clear();
        g.resize(v+1);

        for (int i=0;i<e;i++)
        {
            cin>>a>>b;
            g[a].push_back(b);
            g[b].push_back(a);
        }

        bool ibg = true;
        for (int i=1;i<=v;i++)
        {
            if (type[i] == 0)
            {
                if (!_s(i, 1))
                {
                    ibg=false;
                    break;
                }
            }
        }

        cout<<(ibg?"YES":"NO")<<'\n';
    }
}