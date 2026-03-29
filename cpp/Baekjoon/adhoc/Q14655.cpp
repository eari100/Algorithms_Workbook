#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/14655 (욱제는 도박쟁이야!!)
 * @classification: ad-hok
 * @문제 푼 날짜 (자력으로 풂?): 26.03.29 (O)
 **/
int n, sum=0, x;

int main()
{
    cin>>n;

    for (int i=0;i<n;i++)
    {
        cin>>x;

        if (x < 0)
        {
            x*=-1;
        }

        sum+=x;
    }

    for (int i=0;i<n;i++)
    {
        cin>>x;

        if (x < 0)
        {
            x*=-1;
        }

        sum+=x;
    }

    cout<<sum;
}