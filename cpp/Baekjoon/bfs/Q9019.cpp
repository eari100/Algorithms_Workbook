#include<iostream>
#include<queue>
#include<cmath>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/9019 (DSLR)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.09.10 (X)
 **/
int t, in, out;
long long dp[10000], INF = (1ULL << 63) - 1;

class item
{
public:
    string logs;
    int num;
    int count;
};

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>t;
    while (t--)
    {
        cin>>in>>out;
        queue<item> que;

        for (int i=0;i<10000;i++)
        {
            dp[i] = INF;
        }

        dp[in] = 0;
        que.push({"", in, 0});

        while(que.size())
        {
            item _front = que.front();
            que.pop();

            if (_front.num == out)
            {
                cout << _front.logs << '\n';
                break;
            }

            int next_count = _front.count + 1;

            // D
            int next_num_1 = (_front.num * 2) % 10000;
            if (dp[next_num_1] > next_count)
            {
                que.push({_front.logs + "D", next_num_1, next_count});
                dp[next_num_1] = next_count;
            }

            // S
            int next_num_2 = (_front.num == 0 ? 9999 : _front.num - 1);
            if (dp[next_num_2] > next_count)
            {
                que.push({_front.logs + "S", next_num_2, next_count});
                dp[next_num_2] = next_count;
            }

            int next_num_3 = (_front.num % 1000) * 10 + (_front.num / 1000); // L
            int next_num_4 = (_front.num / 10) + (_front.num % 10) * 1000;   // R


            if (dp[next_num_3] > next_count)
            {
                que.push({_front.logs + "L", next_num_3, next_count});
                dp[next_num_3] = next_count;
            }

            if (dp[next_num_4] > next_count)
            {
                que.push({_front.logs + "R", next_num_4, next_count});
                dp[next_num_4] = next_count;
            }
        }
    }
}