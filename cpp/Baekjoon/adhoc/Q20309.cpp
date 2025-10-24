#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/20309 (트리플 소트)
 * @classification: ad-hok
 * @문제 푼 날짜 (자력으로 풂?): 25.10.22 (O)
 **/
int n, nums[300'000+1];

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin >> n;

    for (int i=0;i<n;i++)
    {
        cin>>nums[i];

        if ( (nums[i]&1) ^ ((i+1)&1) )
        {
            cout << "NO";
            return 0;
        }
    }

    cout<<"YES";
}