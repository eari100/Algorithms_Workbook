#include <iostream>
#include <set>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/14594 (동방 프로젝트 (Small))
 * @classification: union find
 * @문제 푼 날짜 (자력으로 풂?): 25.09.05 (O)
 **/
int n,act,rooms[100+1],l,r;
set<int> count;

int _find(int x)
{
    if (x == rooms[x])
    {
        return x;
    }

    return rooms[x] = _find(rooms[x]);
}

void _union(int a, int b)
{
    int p1 = _find(a), p2 = _find(b);

    if (p1 < p2)
    {
        rooms[p2] = p1;
    }
    else
    {
        rooms[p1] = p2;
    }
}

int main()
{
    cin>>n>>act;

    for (int i=1;i<=n;i++)
    {
        rooms[i] = i;
    }

    for (int i=0;i<act;i++)
    {
        cin>>l>>r;

        for (int j=l+1;j<=r;j++)
        {
            _union(l,j);
        }
    }

    for (int i=1;i<=n;i++)
    {
        count.insert(_find(rooms[i]));
    }

    cout << count.size();
}
