#include<iostream>
#include<deque>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1021 (회전하는 큐)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.11.27 (O)
 **/
int n,m, cost = 0, target;
deque<int> dq;

int main()
{
    cin>>n>>m;
    for (int i=1;i<=n;i++)
        dq.push_back(i);

    for (int i=0;i<m;i++)
    {
        cin>>target;

        bool front_pop = false;

        for (int j=0;j<=dq.size()/2;j++)
        {
            if (dq[j]==target)
            {
                front_pop = true;
            }
        }

        if (front_pop)
        {
            while (1)
            {
                int f = dq.front();
                dq.pop_front();

                if (f == target)
                {
                    break;
                }

                dq.push_back(f);
                ++cost;
            }
        }
        else
        {
            while (1)
            {
                ++cost;
                int b = dq.back();
                dq.pop_back();

                if (b == target)
                {
                    break;
                }
                dq.push_front(b);
            }
        }
    }

    cout<<cost;
}