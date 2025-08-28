#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2981 (검문)
 * @classification: euclidean algorithm
 * @문제 푼 날짜 (자력으로 풂?): 25.08.28 (유클리드 호제법 공식만 확인)
 **/
int gcd_f(int a, int b)
{
    while (b != 0)
    {
        int t = b;
        b = a % b;
        a = t;
    }

    return a;
}

int main()
{
    int n, gcd;
    cin>>n;
    vector<int> nums(n), diff(n);

    for (int i=0;i<n;i++)
    {
        cin >> nums[i];
    }

    sort(nums.begin(), nums.end());

    for (int i=1;i<n;i++)
    {
        diff[i] = nums[i] - nums[i-1];
    }

    gcd = diff[1];

    for (int i=2;i<n;i++)
    {
        gcd = gcd_f(gcd, diff[i]);
    }

    for (int i=2;i<=gcd;i++)
    {
        if (gcd % i == 0)
        {
            cout << i << ' ';
        }
    }
}