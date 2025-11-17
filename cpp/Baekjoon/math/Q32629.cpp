#include<iostream>
#include<cmath>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/32629 (직사각형)
 * @classification: math
 * @문제 푼 날짜 (자력으로 풂?): 25.11.17 (O)
 **/
int t, x;

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>t;
    while (t--)
    {
        cin>>x;

        int p = sqrt(x);
        int share = x / p;
        int remain = x % p;

        if (remain)
        {
            share++;
        }

        cout << 2 * (p + share) << '\n';
    }
}