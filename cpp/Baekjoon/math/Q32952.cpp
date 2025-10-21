#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/32952 (비트코인 반감기)
 * @classification: math
 * @문제 푼 날짜 (자력솔?): 25.10.22 (X, 우측 시프트 연산 너무 큰 수로 써서 오류)
 **/
long long a, b, c;
int main()
{
    cin>>a>>b>>c;
    long long share = c / b;
    while (share--)
    {
        a>>=1;
        if (!a) break;
    }

    cout<<a;
}