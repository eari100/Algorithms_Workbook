#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/17939 (Gazzzua)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.12.05 (O)
 **/
int answer = 0, stock[100'000+1], n, _max = 0;

int main()
{
    cin>>n;
    for (int i=0;i<n;i++)
    {
        cin>>stock[i];
    }

    for (int i=n;i>=0;i--)
    {
        if (stock[i] >= _max)
        {
            _max = stock[i];
        }
        else
        {
            answer += _max - stock[i];
        }
    }

    cout<<answer;
}