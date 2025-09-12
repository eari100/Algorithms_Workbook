#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/9082 (지뢰찾기)
 * @classification: greedy, ad-hoc
 * @문제 푼 날짜 (자력으로 풂?): 25.09.12 (O)
 **/
int t, len, first[100], answer, check[100];
char mine = '*', unknown = '#', safe = 's', second[100];
string f, s;

int main()
{
    cin>>t;

    while (t--)
    {
        cin>>len;
        answer = 0;
        cin >> f;
        for (int i=0;i<len;i++)
        {
            first[i] = f[i] - '0';
            check[i] = 0; // 초기화
        }

        cin >> s;
        for (int i=0;i<len;i++)
        {
            second[i] = s[i];

            if (second[i] == mine)
            {
                ++answer;

                for (int j=i-1;j<=i+1;j++)
                {
                    if (j >= 0 && j < len)
                    {
                        check[j]++;
                    }
                }
            }
        }

        for (int i=0;i<len;i++)
        {
            if (second[i] == unknown)
            {
                bool is_mine = true;

                for (int j=i-1;j<=i+1;j++)
                {
                    if (j >= 0 && j < len)
                    {
                        if (check[j] == first[j])
                        {
                            is_mine = false;
                            break;
                        }
                    }
                }

                if (is_mine)
                {
                    ++answer;

                    for (int j=i-1;j<=i+1;j++)
                    {
                        if (j >= 0 && j < len)
                        {
                            check[j]++;
                        }
                    }
                }
            }
        }

        cout << answer <<'\n';
    }
}