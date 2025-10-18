#include<iostream>

#define MAX 1000

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/11054 (가장 긴 바이토닉 부분 수열)
 * @classification: dp, lis, lds
 * @문제 푼 날짜 (자력으로 풂?): 25.10.18 (O)
 **/
int n, inc[MAX+1], decr[MAX+1], seq[MAX+1], answer = 0;

int main()
{
    cin>>n;

    for (int i=0;i<n;i++)
    {
        cin>>seq[i];
    }

    for (int i=0;i<n;i++)
    {
        int max_prev = 0;
        for (int j=0;j<i;j++)
        {
            if (seq[j] < seq[i] && inc[j] > max_prev)
            {
                max_prev = inc[j];
            }
        }

        int md = 0;
        for (int j=i;j<n;j++)
        {
            int min_prev = 0;
            for (int k=i;k<j;k++)
            {
                if (seq[k] > seq[j] && decr[k] > min_prev)
                {
                    min_prev = decr[k];
                }
            }

            decr[j] = min_prev + 1;
            md = max(md, decr[j]);
        }

        inc[i] = max_prev + 1;
        answer = max(answer, md + inc[i] - 1);
    }

    cout<<answer;
}