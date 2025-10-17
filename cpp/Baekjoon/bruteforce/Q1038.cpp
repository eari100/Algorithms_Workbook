#include<iostream>
#include<queue>

/**
 * @source: https://www.acmicpc.net/problem/1038 (감소하는 수)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.10.17 (X)
 **/
#define MAX 1000000

using namespace std;

int idx = 10, target;
long long dp[MAX+1];

queue<long long> q;

int main()
{
    cin>>target;

    if (target == 0)
    {
        cout << 0;
        return 0;
    }

    for (int i=0;i<10;i++)
    {
        q.push(i);
        dp[i] = i;
    }

    while ( q.size() && idx < MAX )
    {
        long long f = q.front();
        q.pop();
        int last = f % 10;
        f *= 10;

        for (int i=0;i<last;i++)
        {
            long long next = f + i;
            q.push(next);
            dp[idx++] = next;
        }
    }

    cout<<(!dp[target]?-1:dp[target]);
}