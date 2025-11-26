#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1188 (음식 평론가)
 * @classification: number theory
 * @문제 푼 날짜 (자력으로 풂?): 25.11.26 (x)
 **/
int n,m;

int _gcd(int a, int b)
{
    while (b)
    {
        int r = a % b;
        a = b;
        b = r;
    }

    return a;
}

int main()
{
    cin>>n>>m;

    cout<<m - _gcd(n,m);
}
