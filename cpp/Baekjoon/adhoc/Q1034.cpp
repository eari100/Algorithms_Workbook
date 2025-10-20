#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1034 (램프)
 * @classification: ad-hok
 * @문제 푼 날짜 (자력으로 풂?): 25.10.20 (X)
 **/
int n, m, k, answer = 0, offs[51];
string row;
vector<string> v;

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>n>>m;

    v.resize(n);
    for (int i=0;i<n;i++)
    {
        cin >> v[i];

        for (int j=0;j<m;j++)
        {
            if (v[i][j] == '0')
            {
                offs[i]++;
            }
        }
    }

    cin>>k;

    for (int i=0;i<n;i++)
    {
        if (offs[i] <= k && !((offs[i]%2) ^ (k%2)))
        {
            int match = 0;

            for (int j=0;j<n;j++)
            {
                if ( (v[i] == v[j]) )
                {
                    ++match;
                }
            }

            answer = max(answer, match);
        }
    }

    cout << answer;
}