#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1052 (물병)
 * @classification: bit masking
 * @문제 푼 날짜 (자력으로 풂?): 25.09.18 (X)
 **/
long long n, k, add_cnt = 0;

int digit_cnt(long long d)
{
    int cnt = 0;
    while (d)
    {
        if (d & 1)
        {
            cnt++;
        }

        d >>= 1;
    }

    return cnt;
}

int main()
{
    cin>>n>>k;

    while (digit_cnt(n) > k)
    {
        n++;
        add_cnt++;
    }

    cout << add_cnt;
}