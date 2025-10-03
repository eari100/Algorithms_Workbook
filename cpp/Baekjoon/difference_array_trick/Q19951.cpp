#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/19951 (태상이의 훈련소 생활)
 * @classification: difference array trick
 * @문제 푼 날짜 (자력으로 풂?): 25.10.03 (X)
 **/
long long n, m, ground[100001], diff[100001+1], s, e, k, update = 0;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;

    for(int i = 0; i < n; i++)
    {
        cin>>ground[i];
    }

    for(int i = 0; i < m; i++)
    {
        cin>>s>>e>>k;
        diff[s-1] += k;
        diff[e] -= k;
    }

    for (int i=0;i<n;i++)
    {
        update += diff[i];
        ground[i] += update;
        cout << ground[i] << " ";
    }
}