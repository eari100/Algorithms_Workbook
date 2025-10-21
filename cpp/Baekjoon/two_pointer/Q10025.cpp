#include <iostream>

/**
 * @source: https://www.acmicpc.net/problem/10025 (게으른 백곰)
 * @classification: two-pointer
 * @문제 푼 날짜 (자력솔?): 25.10.21 (O)
 **/
#define MAX 1'000'000

using namespace std;

int n, k, arr[MAX+1];
long long max_ice;
long long curr_ice;

int main()
{
    cin>>n>>k;
    for (int i=0;i<n;i++)
    {
        int a, b;
        cin>>a>>b;
        arr[b] = a;
    }

    int aa = min(k*2+1, MAX+1);
    for (int i=0;i<aa;i++)
    {
        max_ice += arr[i];
    }

    curr_ice = max_ice;

    int l = 0, r = aa-1;

    for (int i=r+1;i<MAX+1;i++)
    {
        curr_ice += (arr[i] - arr[l++]);
        max_ice = max(max_ice, curr_ice);
    }

    cout << max_ice;
}