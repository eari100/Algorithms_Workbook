#include<iostream>

using namespace std;

/**
 * @source:https://www.acmicpc.net/problem/10775 (공항)
 * @classification: union-find, greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.11.27 (O)
 **/
int g, p, max_gate;
int parent[100'000+1];

int _find(int x)
{
    if (x == parent[x])
    {
        return x;
    }

    return parent[x] = _find(parent[x]);
}

void _union(int a, int b)
{
    int p1 = _find(a);
    int p2 = _find(b);

    if (p1 > p2)
    {
        parent[p1] = p2;
    }
    else
    {
        parent[p2] = p1;
    }
}

int main()
{
    cin>>g>>p;

    for (int i=1;i<=g;i++)
    {
        parent[i]=i;
    }

    for (int i=1;i<=p;i++)
    {
        cin>>max_gate;

        int p = _find(max_gate);
        if (p==0)
        {
            cout << i-1;
            return 0;
        }

        _union(p, p-1);
    }

    cout << p;
}