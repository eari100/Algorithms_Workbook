#include<iostream>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1388 (바닥 장식)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.11.23 (O)
 **/
int n, m, answer = 0;
string s;
char board[50][50];
bool visited[50][50];
int moves[2][2][2] = {{{-1, 0}, {1, 0}}, {{0, -1}, {0, 1}}};

int main()
{
    cin>>n>>m;

    getline(cin,s);
    for (int i=0;i<n;i++)
    {
        getline(cin,s);
        for (int j=0;j<m;j++)
        {
            board[i][j] = s[j];
        }
    }

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<m;j++)
        {
            if ( !visited[i][j] )
            {
                ++answer;
                queue<vector<int>> q;
                q.push({i,j});
                visited[i][j] = true;
                int index;

                if (board[i][j] == '|')
                {
                    index = 0;
                }
                else if (board[i][j] == '-')
                {
                    index = 1;
                }

                while (q.size())
                {
                    vector<int> f = q.front();
                    q.pop();

                    for (int mi=0;mi<2;mi++)
                    {
                        int next_x = f[0] + moves[index][mi][0];
                        int next_y = f[1] + moves[index][mi][1];

                        if (next_x < 0 || next_x >= n || next_y < 0 || next_y >= m || visited[next_x][next_y] || (board[i][j] != board[next_x][next_y]))
                        {
                             continue;
                        }

                        visited[next_x][next_y] = true;
                        q.push({next_x, next_y});
                    }
                }
            }
        }
    }

    cout << answer;
}