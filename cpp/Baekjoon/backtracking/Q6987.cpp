#include <iostream>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/6987 (월드컵)
 * @classification: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 25.09.02 (X)
 **/
vector<int> logs(6*3);
vector<vector<int>> test(4, vector<int>(18, 0));
vector<int> answer(4, 0);

void bt(int team1, int team2)
{
    if (team1 == 5)
    {
        for (int i=0;i<4;i++)
        {
            if (answer[i])
            {
                continue;
            }

            for (int j=0;j<18;j++)
            {
                if (logs[j] != test[i][j])
                {
                    break;
                }

                if (j == 17)
                {
                    answer[i] = 1;
                }
            }
        }

        return;
    }

    if (team2 >= 6)
    {
        bt(team1+1, team1+2);
        return;
    }

    for (int status=0;status<3;status++)
    {
        int status2 = -100;
        if (status == 0)
        {
            status2 = 2;
        }
        else if (status == 1)
        {
            status2 = 1;
        }
        else
        {
            status2 = 0;
        }

        logs[team1 * 3 + status]++;
        logs[team2 * 3 + status2]++;
        bt(team1, team2+1);
        logs[team1 * 3 + status]--;
        logs[team2 * 3 + status2]--;
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for (int t=0;t<4;t++)
    {
        for (int i=0;i<6*3;i++)
        {
            cin >> test[t][i];
        }
    }

    bt(0, 1);

    for (int a : answer)
    {
        cout << a << ' ';
    }
}