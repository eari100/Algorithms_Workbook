#include<iostream>
#include<cmath>
#include<map>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1241 (머리 톡톡)
 * @classification: number theory
 * @문제 푼 날짜 (자력으로 풂?): 25.11.25 (x)
 **/
int n, x;
map<int, int> _map;
int nums[100'001];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>n;
    for (int i=0;i<n;i++)
    {
        cin>>x;
        _map[x]++;
        nums[i] = x;
    }

    for (int i=0;i<n;i++)
    {
        int target = nums[i];
        int sq = sqrt(target), hit = 0;

        for (int j=1;j<=sq;j++)
        {
            if (target % j == 0)
            {
                int share = target / j;
                hit += _map[j] + _map[share];
            }
        }

        if (sq * sq == target)
        {
            hit -= _map[sq];
        }

        cout << hit-1 << '\n';
    }
}