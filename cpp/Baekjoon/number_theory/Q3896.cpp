#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/3896 (소수 사이 수열)
 * @classification: number theory
 * @문제 푼 날짜 (자력으로 풂?): 25.05.18 (X)
 **/
int main()
{
    bool nums[1299709+1];

    for (int i=2;i<=1299709;i++)
    {
        nums[i] = true;
    }

    for (int i=2;i<=1299709;i++)
    {
        if (!nums[i]) continue;

        for (int j=i+i;j<=1299709;j+=i)
        {
            nums[j] = false;
        }
    }

    int t;
    cin>>t;

    while(t--)
    {
        int num;
        cin >> num;

        if (nums[num])
        {
            cout << 0 <<'\n';
        }
        else
        {
            int len = 2;
            for (int i=num-1;i>=0;i--)
            {
                if (nums[i]) break;
                len++;
            }
            for (int i=num+1;i<1299709+1;i++)
            {
                if (nums[i]) break;
                len++;
            }
            cout<<len<<'\n';
        }
    }
}