#include<iostream>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/16920 (확장 게임)
 * @classification: bfs
 * @문제 푼 날짜 (자력솔?): 25.11.05 (X)
 **/
int h, w, p;
int moves[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
int acc[10], cnt[10];
int visited[1000][1000];
string s;
queue<vector<int>> q[10]; // x, y, move

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>h>>w>>p;

    for (int i=1;i<=p;i++)
    {
        cin>>acc[i];
    }

    getline(cin, s);

    for (int i=0;i<h;i++)
    {
        getline(cin, s);

        for (int j=0;j<w;j++)
        {
            if (s[j] == '#')
            {
                visited[i][j] = -1;
            }
            else if (s[j] != '.') // 성 이라면
            {
                int player_no = s[j] - '0';
                visited[i][j] = player_no;
                q[player_no].push({i, j});
                cnt[player_no]++;
            }
        }
    }

    while (1)
    {
        bool flag = false;

        for (int i=1;i<=p;i++)
        {
            for (int j=0;j<acc[i];j++)
            {
                if ( !q[i].size() )
                {
                    break;
                }

                flag = true;
                queue<vector<int>> q2;

                while (q[i].size())
                {
                    vector<int> f = q[i].front();
                    q[i].pop();

                    for (int move=0;move<4;move++)
                    {
                        int x = f[0] + moves[move][0];
                        int y = f[1] + moves[move][1];

                        if (x < 0 || x >= h || y < 0 || y >= w)
                        {
                            continue;
                        }

                        if (visited[x][y] == 0)
                        {
                            visited[x][y] = i;
                            cnt[i]++;
                            q2.push({x, y});
                        }
                    }
                }

                q[i] = q2;
            }
        }

        // cout<<"=============="<<endl;
        // for (int i=0;i<h;i++)
        // {
        //     for (int j=0;j<w;j++)
        //     {
        //         cout<<visited[i][j]<<" ";
        //     }
        //     cout<<endl;
        // }

        if (!flag)
            break;
    }

    for (int i=1;i<=p;i++)
    {
        cout << cnt[i] << " ";
    }
}