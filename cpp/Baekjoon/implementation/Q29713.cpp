#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/29713 (브실이의 띠부띠부씰 컬렉션 🍪)
 * @classification: implementation
 * @문제 푼 날짜 (자력솔?): 25.12.14 (O)
 **/
int n, alp[26], answer = 1000+5;
string s, target="BRONZESILV";

int main()
{
    cin>>n>>s;

    for (char c : s)
    {
        alp[c-'A']++;
    }

    for (char c : target)
    {
        int cnt = alp[c-'A'];
        if (cnt && c == 'E' || c == 'R')
        {
            cnt/=2;
        }
        answer=min(answer, cnt);
    }

    cout<<answer;
}