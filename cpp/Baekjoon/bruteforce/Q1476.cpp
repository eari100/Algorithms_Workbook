#include<iostream>

using namespace std;

int e,s,m,year=1;

/**
 * @source: https://www.acmicpc.net/problem/1476 (날짜 계산)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.12.24 (X)
 **/
int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>e>>s>>m;

    while (1)
    {
        if (!((year-e)%15) && !((year-s)%28) && !((year-m)%19))
        {
            cout<<year;
            return 0;
        }

        year++;
    }
}