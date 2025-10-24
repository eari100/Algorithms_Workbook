#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/33572 (자세히 보아야 예쁘다)
 * @classification: math
 * @문제 푼 날짜 (자력으로 풂?): 25.10.23 (O)
 **/
long long n, m, love, sum = 0;

int main()
{
    cin>>n>>m;
    for(int i=0;i<n;i++)
    {
        cin>>love;
        sum+=love;
    }

    if ((sum - m) < n)
    {
        cout<<"OUT";
    }
    else
    {
        cout<<"DIMI";
    }
}