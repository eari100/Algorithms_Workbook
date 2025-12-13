#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2343 (기타 레슨)
 * @classification: binary search
 * @문제 푼 날짜 (자력솔?): 25.12.14 (X)
 **/
int n,m,blu_ray[100'000];
int l = 0, r = 0;
int answer;

int main()
{
    cin>>n>>m;

    for (int i=0;i<n;i++)
    {
        cin>>blu_ray[i];
        r+=blu_ray[i];
        l=max(l, blu_ray[i]);
    }

    while (l<=r)
    {
        int mid = (l+r)/2;
        int cnt = 1;
        int tmp = blu_ray[0];

        for (int i=1;i<n;i++)
        {
            if (tmp+blu_ray[i] <= mid)
            {
                tmp+=blu_ray[i];
            }
            else
            {
                cnt++;
                tmp = blu_ray[i];
            }
        }

        if (cnt > m)
        {
            l = mid+1;
        }
        else
        {
            answer = mid;
            r = mid-1;
        }
    }

    cout<<answer;
}