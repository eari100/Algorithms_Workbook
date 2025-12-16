#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/16172 (나는 친구가 적다 (Large))
 * @classification: KMP
 * @문제 푼 날짜 (자력으로 풂?): 25.12.16 (X)
 **/
string a, a2="", b;
int pi[200'000];

bool is_alp(char& c)
{
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
}

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>a>>b;

    for (char c : a)
    {
        if (is_alp(c))
        {
            a2 += c;
        }
    }

    int str = 0;
    for (int end=1;end<b.size();end++)
    {
        while (str>0 && b[str] != b[end])
        {
            str = pi[str-1];
        }

        if (b[str] == b[end])
        {
            pi[end] = ++str;
        }
    }

    int idx = 0;
    for (int i=0;i<a2.size();i++)
    {
        if (a2[i] == b[idx])
        {
            idx++;
            if (idx==b.size())
            {
                cout<<1;
                return 0;
            }
        }
        else
        {
            if (idx)
            {
                idx = pi[idx-1];
                i--;
            }
        }
    }

    cout<<0;
}