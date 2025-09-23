#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/25183 (인생은 한 방)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.09.23 (O)
 **/
int n, len = 1;
string str;

int main()
{
    cin>>n>>str;

    for (int i=0;i<n-1;i++)
    {
        int curr = str[i] - 'A';
        int next = str[i+1] - 'A';

        if (abs(curr - next) == 1)
        {
            ++len;
            if (len == 5)
            {
                break;
            }
        }
        else
        {
            len = 1;
        }
    }

    cout<<(len>=5 ? "YES" : "NO");
}