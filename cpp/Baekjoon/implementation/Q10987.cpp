#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/10987 (모음의 개수)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.08.31 (O)
 **/
int main()
{
    int count = 0;
    string s;
    cin >> s;

    for (char& c : s)
    {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        {
            count++;
        }
    }

    cout << count;
}