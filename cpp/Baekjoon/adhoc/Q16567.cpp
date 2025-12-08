#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/16567 (바이너리 왕국)
 * @classification: ad-hok
 * @문제 푼 날짜 (자력으로 풂?): 25.12.08 (O)
 **/
int n, m, binary[1'000'000+5], opt, idx, dirty = 0;

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>n>>m;

    for (int i=1;i<=n;i++)
    {
        cin>>binary[i];

        if (binary[i-1] == 0 && binary[i] == 1)
        {
            ++dirty;
        }
    }

    for (int i=0;i<m;i++)
    {
        cin>>opt;

        if (opt)
        {
            cin>>idx;

            if (binary[idx] == 0)
            {
                if (binary[idx-1] == 1 && binary[idx+1] == 1)
                {
                    dirty--;
                }
                else if (binary[idx-1] == 0 && binary[idx+1] == 0)
                {
                    dirty++;
                }
                binary[idx] = 1;
            }
        }
        else
        {
            cout<<dirty<<'\n';
        }
    }
}