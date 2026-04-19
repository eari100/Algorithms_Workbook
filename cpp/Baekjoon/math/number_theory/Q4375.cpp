#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/4375 (1)
 * @classification: number theory
 * @문제 푼 날짜 (자력으로 풂?): 26.04.19 (X)
 **/
int n;
long long a, y;

int main()
{
    while (cin>>n)
    {
        a=1;
        y=1;

        while (1)
        {
            if (y % n == 0)
            {
                break;
            }

            y*=10;
            y++;
            y%=n;
            a++;
        }


        cout<<a<<'\n';
    }
}