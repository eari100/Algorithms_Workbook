#include<iostream>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1524 (세준세비)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.11.28 (O, 그냥 가장 강한 원소 2개만 보면 되잖아...멍청아)
 **/
struct comp
{
    bool operator()(int a, int b)
    {
        return a > b;
    }
};

int t, n, m, x;

int main()
{
    cin>>t;

    while(t--)
    {
        cin>>n>>m;
        priority_queue<int, vector<int>, comp> sj, sb;

        for (int i=0;i<n;i++)
        {
            cin>>x;
            sj.push(x);
        }

        for (int i=0;i<m;i++)
        {
            cin>>x;
            sb.push(x);
        }

        for (int i=0;i<n+m;i++)
        {
            if (!sj.size())
            {
                cout<<"B"<<'\n';
                break;
            }

            if (!sb.size())
            {
                cout<<"S"<<'\n';
                break;
            }

            int t1 = sj.top(), t2 = sb.top();

            if (t1 >= t2)
            {
                sb.pop();
            }
            else
            {
                sj.pop();
            }
        }
    }
}