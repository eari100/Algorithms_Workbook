#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/26007 (Codepowers)
 * @classification: cumulative sum
 * @문제 푼 날짜 (자력으로 풂?): 25.10.29 (O)
 **/
int n, m, k, arr[100000+5], add, s, e;
long long score;

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>n>>m>>k>>score;

    for (int i=1;i<=n;i++)
    {
        arr[i] = arr[i-1];

        cin>>add;
        score+=add;

        if (score < k)
        {
            arr[i]++;
        }
    }

    for (int i=0;i<m;i++)
    {
        cin>>s>>e;

        cout << arr[e-1] - arr[s-1] << '\n';
    }
}