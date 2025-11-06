#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/7523 (Gauß)
 * @classification: math
 * @문제 푼 날짜 (자력솔?): 25.11.06 (O)
 **/
long long t, n, m;

int main()
{
    cin>>t;
    for (int i=1;i<=t;i++)
    {
        cin>>n>>m;
        long long sigma = (m-n+1) * (n+m) / 2;
        cout << "Scenario #" << i << ":" << '\n';
        cout<<sigma<<"\n\n";
    }
}