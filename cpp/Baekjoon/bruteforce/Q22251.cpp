#include<iostream>
#include<cmath>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/22251 (빌런 호석)
 * @classification: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 25.12.09 (O)
 **/
int n, k, p, c; // 층, 자릿수, 조작, 현재
int answer = 0;
int LED[1'000'000+1];

int cvt[10][10] =
{
    // j=0 j=1 j=2 j=3 j=4 j=5 j=6 j=7 j=8 j=9
    { 0, 4, 3, 3, 4, 3, 2, 3, 1, 2 }, // i=0
    { 4, 0, 5, 3, 2, 5, 6, 1, 5, 4 }, // i=1
    { 3, 5, 0, 2, 5, 4, 3, 4, 2, 3 }, // i=2
    { 3, 3, 2, 0, 3, 2, 3, 2, 2, 1 }, // i=3
    { 4, 2, 5, 3, 0, 3, 4, 3, 3, 2 }, // i=4
    { 3, 5, 4, 2, 3, 0, 1, 4, 2, 1 }, // i=5
    { 2, 6, 3, 3, 4, 1, 0, 5, 1, 2 }, // i=6
    { 3, 1, 4, 2, 3, 4, 5, 0, 4, 3 }, // i=7
    { 1, 5, 2, 2, 3, 2, 1, 4, 0, 1 }, // i=8
    { 2, 4, 3, 1, 2, 1, 2, 3, 1, 0 }  // i=9
};

void solve(int idx, int con, int tmp)
{
    if (idx == -1)
    {
        if (con > 0 && tmp > 0)
        {
            answer++;
        }

        return;
    }

    for (int i=0;i<=9;i++)
    {
        int con2 = con + cvt[LED[idx]][i];
        int tmp2 = tmp + (i * pow(10, (k-1-idx)));

        if (con2 > p || tmp2 > n)
        {
            continue;
        }

        solve(idx-1, con2, tmp2);
    }
}

int main()
{
    cin>>n>>k>>p>>c;

    int tmp = c;

    for (int i=k-1;i>=0;i--)
    {
        if (tmp == 0)
        {
            LED[i] = 0;
        }
        else
        {
            int remain = tmp % 10;
            LED[i] = remain;
            tmp /= 10;
        }
    }

    solve(k-1, 0, 0);

    cout << answer;
}
