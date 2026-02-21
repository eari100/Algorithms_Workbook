#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/32200 (항해)
 * @classification: math, greedy
 * @문제 푼 날짜 (자력으로 풂?): 26.02.03 (X)
 **/
long long n, x, y, sandwich, k, day, _throw = 0;

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>n>>x>>y;

    for(int i=0;i<n;i++)
    {
        cin>>sandwich;

        if(sandwich < x)
        {
            _throw += sandwich;
        }
        else
        {
            k = sandwich / x;
            day += k;
            _throw += sandwich - min(sandwich, k*y);
        }
    }

    cout<<day<<'\n'<<_throw;
}