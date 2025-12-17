#include<iostream>

using namespace std;

/**
 * @source:https://www.acmicpc.net/problem/16916 (부분 문자열)
 * @classification: KMP
 * @문제 푼 날짜 (자력으로 풂?): 25.12.17 (O)
 **/
string a, b;
int pi[1'000'000];

void get_pi()
{
    int str=0;

    for (int end=1;end<b.size();end++)
    {
        while (str && b[str]!=b[end])
        {
            str = pi[str-1];
        }

        if (b[str] == b[end])
        {
            pi[end] = ++str;
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>a>>b;

    get_pi();

    int idx = 0;
    for (int i=0;i<a.size();i++)
    {
        if (a[i] == b[idx])
        {
            idx++;

            if (idx == b.size())
            {
                cout<<1;
                return 0;
            }
        }
        else
        {
            if (idx)
            {
                i--;
                idx = pi[idx-1];
            }
        }
    }

    cout<<0;
}