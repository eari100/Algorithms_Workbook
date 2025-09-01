#include <iostream>
#include <vector>
#include <queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/29767 (점수를 최대로)
 * @classification: cumulative sum
 * @문제 푼 날짜 (자력으로 풂?): 25.09.01 (O)
 **/
struct c
{
    bool operator()(vector<long long> a, vector<long long> b)
    {
        return a[0] < b[0];
    }
};

int main()
{
    int n,k,tmp;
    long long answer = 0;
    cin>>n>>k;
    vector<long long> v(n, 0);
    priority_queue<vector<long long>, vector<vector<long long>>, c> pq;

    for (int i=0;i<n;i++)
    {
        cin >> tmp;
        if (i == 0)
        {
            v[i] = tmp;
        }
        else
        {
            v[i] = v[i-1] + tmp;
        }
        pq.push({v[i], i});
    }

    while (k--)
    {
        answer += v[pq.top()[1]];
        pq.pop();
    }

    cout << answer;
}