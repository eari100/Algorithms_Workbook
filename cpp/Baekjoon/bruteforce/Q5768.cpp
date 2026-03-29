#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/5768 (Divide and Conquer)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 26.03.29 (O)
 **/
int n,m;
int a[5000+1];

int main()
{
    for (int i=1;i<=5000;i++)
    {
        int j = 1;

        while (1)
        {
            int re = i * j;

            if (re > 5000)
            {
                break;
            }

            a[re]++;
            j++;
        }
    }

    while(1)
    {
        cin>>n>>m;

        if (!n && !m)
        {
            break;
        }

        int max_div = 0;
        int answer = 0;

        for (int i=m;i>=n;i--)
        {
            if (max_div < a[i])
            {
                max_div = a[i];
                answer = i;
            }
        }

        cout<<answer<<" "<<max_div<<'\n';
    }
}