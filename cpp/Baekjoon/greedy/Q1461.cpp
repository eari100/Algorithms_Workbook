#include<iostream>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1461 (도서관)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.10.09 (O)
 **/
struct min_heap
{
    bool operator()(int a, int b)
    {
        return a > b;
    }
};

int n, m, tmp, cost = 0;
priority_queue<int> pos;
priority_queue<int, vector<int>, min_heap> neg;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>n>>m;

    for(int i=0;i<n;i++)
    {
        cin>>tmp;
        if (tmp > 0)
        {
            pos.push(tmp);
        }
        else
        {
            neg.push(tmp);
        }
    }

    int repeat = m, p = 0, n = 0;

    if ( !pos.empty() )
    {
        p = pos.top();
    }

    if ( !neg.empty() )
    {
        n = neg.top();
    }

    if (p > -n)
    {
        cost += pos.top();

        while (repeat-- && !pos.empty())
        {
            pos.pop();
        }
    }
    else
    {
        cost -= neg.top();

        while (repeat-- && !neg.empty())
        {
            neg.pop();
        }
    }

    while (!pos.empty())
    {
        cost += (pos.top() * 2);

        for (int i=0;i<m;i++)
        {
            if (pos.empty())
                break;
            pos.pop();
        }
    }

    while (!neg.empty())
    {
        cost -= (neg.top() * 2);

        for (int i=0;i<m;i++)
        {
            if (neg.empty())
                break;
            neg.pop();
        }
    }

    cout<<cost;
}