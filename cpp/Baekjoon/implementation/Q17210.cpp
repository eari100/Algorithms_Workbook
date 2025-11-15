#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/17210 (문문문)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.11.15 (O)
 **/
int n, m;

int main()
{
    cin>>n>>m;

    if (n >= 6)
    {
        cout << "Love is open door";
    }
    else
    {
        for (int i = 1; i < n; i++)
        {
            m = !m;
            cout << m << '\n';
        }
    }
}