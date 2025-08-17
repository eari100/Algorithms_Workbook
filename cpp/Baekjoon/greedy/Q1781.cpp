#include<iostream>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1781 (컵라면)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.08.17 (X)
 **/
int main()
{
    int answer = 0;
    int n;
    cin>>n;
    vector<int> v[n+1];
    priority_queue<int> pq;

    for (int i=0;i<n;i++)
    {
        int deadline, value;
        cin >> deadline >> value;
        v[deadline].push_back(value);
    }

    for (int day = n;day>=1;day--)
    {
        for (int value : v[day])
            pq.push(value);

        if ( !pq.empty() )
        {
            answer += pq.top();
            pq.pop();
        }
    }

    cout << answer;
}