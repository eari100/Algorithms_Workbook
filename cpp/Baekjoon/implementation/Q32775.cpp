#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/32775 (가희와 4시간의 벽 1)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.09.10 (O)
 **/
int main()
{
    int a, b;
    cin>>a>>b;

    if (a > b)
    {
        cout << "flight";
    }
    else
    {
        cout << "high speed rail";
    }
}