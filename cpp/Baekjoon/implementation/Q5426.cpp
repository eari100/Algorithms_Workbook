#include<iostream>
#include<cmath>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/5426 (비밀 편지)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.09.04 (O)
 **/
int main()
{
    int n;
    cin>>n;
    for (int i=0;i<n;i++)
    {
        string s;
        cin>>s;
        int len = sqrt(s.size()), index = 0;
        char answer[s.size()];

        for (int j=len-1;j>=0;j--)
        {
            for (int aa=0;aa<len;aa++)
            {
                answer[index++] = s[len * aa + j];
            }
        }

        for (char c : answer)
        {
            cout << c;
        }

        cout << '\n';
    }
}