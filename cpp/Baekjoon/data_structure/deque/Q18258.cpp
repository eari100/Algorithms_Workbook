#include<iostream>
#include<deque>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/18258 (큐 2)
 * @classification: deque
 * @문제 푼 날짜 (자력으로 풂?): 25.11.02 (O)
 **/
deque<int> dq;
int q, x;
string query;

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>q;

    while (q--)
    {
        cin>>query;

        if (query=="push")
        {
            cin>>x;
            dq.push_back(x);
        }
        else if (query=="pop")
        {
            if (dq.size())
            {
                cout << dq.front() << '\n';
                dq.pop_front();
            }
            else
            {
                cout<<-1<<'\n';
            }
        }
        else if (query=="size")
        {
            cout<<dq.size()<<'\n';
        }
        else if (query=="empty")
        {
            cout << (dq.size() == 0 ? 1 : 0) << '\n';
        }
        else if (query=="front")
        {
            if (!dq.size())
            {
                cout << -1 << '\n';
            }
            else
            {
                cout << dq.front() << '\n';
            }
        }
        else
        {
            if (!dq.size())
            {
                cout << -1 << '\n';
            }
            else
            {
                cout << dq.back() << '\n';
            }
        }
    }
}