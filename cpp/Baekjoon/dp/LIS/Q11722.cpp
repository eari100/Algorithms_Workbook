#include<iostream>

using namespace std;

int n, a[1000], dp[1000], answer = 0;

int main()
{
    cin>>n;

    for(int i=0;i<n;i++)
    {
        cin>>a[i];
    }

    for(int i=0;i<n;i++)
    {
        for(int j=0;j<i;j++)
        {
            if(a[j] > a[i])
            {
                if(dp[i] < dp[j]+1)
                {
                    dp[i] = dp[j]+1;
                    answer = max(answer, dp[i]);
                }
            }
        }
    }

    cout<<answer+1;
}