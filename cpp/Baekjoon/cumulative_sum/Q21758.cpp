#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/21758 (꿀 따기)
 * @classification: cumulative sum
 * @문제 푼 날짜 (자력으로 풂?): 25.10.05 (X, 엣지 케이스 삐끗함)
 **/
int n, max_mid = 0;
int nums[100000+1];
long long _max, sum = 0, l, r;

int main()
{
    cin>>n;
    for(int i=0;i<n;i++)
    {
        cin>>nums[i];
        sum += nums[i];

        if (i >= 1 && i <= n-2)
        {
            max_mid = max(max_mid, nums[i]);
        }
    }

    _max = (sum - (nums[0] + nums[n-1]) + max_mid);

    l = sum - nums[0];
    r = sum - nums[0];

    for (int i=1;i<n-1;i++)
    {
        r -= nums[i];
        _max = max(_max, (l - nums[i]) + r);
    }

    l = sum - nums[n-1];
    r = sum - nums[n-1];

    for (int i=n-2;i>=1;i--)
    {
        l -= nums[i];
        _max = max(_max, (r - nums[i]) + l);
    }

    cout<<_max;
}