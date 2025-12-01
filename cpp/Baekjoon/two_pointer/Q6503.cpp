#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/6503 (망가진 키보드)
 * @classification: two-pointer
 * @문제 푼 날짜 (자력솔?): 25.12.02 (O)
 **/
int av, alp[128], alp_cnt;
string s;

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    while(1)
    {
        cin>>av;

        if (!av)
        {
            break;
        }

        getline(cin,s);
        getline(cin,s);

        int max_len = 0, l = 0, r = -1;

        for (int i=0;i<128;i++)
        {
            alp[i] = 0;
        }

        alp_cnt = 0;

        while (r+1 < (int)s.size())
        {
            int idx = s[r+1];

            if (alp[idx])
            {
                alp[idx]++;
                r++;
                max_len = max(max_len, r-l+1);
            }
            else
            {
                if (alp_cnt < av)
                {
                    alp_cnt++;

                    alp[idx]++;
                    r++;
                    max_len = max(max_len, r-l+1);
                }
                else
                {
                    int idx2 = s[l];

                    alp[idx2]--;
                    if (alp[idx2] == 0)
                    {
                        alp_cnt--;
                    }

                    l++;
                }
            }
        }

        cout<<max_len<<'\n';
    }
}