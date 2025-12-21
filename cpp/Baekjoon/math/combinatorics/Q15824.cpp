#include <iostream>
#include <algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/15824 (너 봄에는 캡사이신이 맛있단다)
 * @classification: combinatorics
 * @문제 푼 날짜 (자력으로 풂?): 25.12.21 (X)
 **/
int n;
long long nums[300'000], _pow[300'000], MOD = 1'000'000'007, _plus = 0, _minus = 0;


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>n;
    _pow[0] = 1;

    for (int i=0;i<n;i++)
    {
        cin>>nums[i];

        if (i)
        {
            _pow[i] = (_pow[i-1] * 2) % MOD;
        }
    }

    sort(nums, nums+n);

    for (int i=n-1;i>=0;i--)
    {
        long long p = (_pow[i] - 1 + MOD) % MOD;
        _plus += (nums[i] * p) % MOD;
        _minus += (nums[n-1-i] * p) % MOD;
    }

    cout<<(_plus % MOD - _minus % MOD + MOD) % MOD;
}