#include<iostream>
#include<set>

/**
 * @source: https://www.acmicpc.net/problem/1765 (닭싸움 팀 정하기)
 * @classification: union-find
 * @문제 푼 날짜 (자력으로 풂?): 25.10.19 (O, 너무 깊게 생각하면 함정에 빠짐. 논리에 흔들리지 말 것)
 **/
#define MAX 5000

using namespace std;

int n, m, p, q, parents[MAX+1], enemies[MAX+1];
char c;
set<int> team_cnt;

int find(int curr)
{
    if (parents[curr] == curr)
    {
        return curr;
    }

    return parents[curr] = find(parents[curr]);
}

void _union(int a, int b)
{
    int p1 = find(a), p2 = find(b);

    if (p1 < p2)
    {
        parents[p1] = p2;
    }
    else
    {
        parents[p2] = p1;
    }
}

int main()
{
    cin>>n>>m;

    for (int i=1; i<=n; i++)
    {
        parents[i] = i;
    }

    for (int i=0;i<m;i++)
    {
        cin>>c>>p>>q;

        if (c == 'F')
        {
            _union(p, q);
        }
        else
        {
            if ( enemies[p] )
            {
                _union(enemies[p], q);
            }
            enemies[p] = q;

            if ( enemies[q] )
            {
                _union(p, enemies[q]);
            }
            enemies[q] = p;
        }
    }

    for (int i=1;i<=n;i++)
    {
        team_cnt.insert(find(i));
    }

    cout<<team_cnt.size();
}