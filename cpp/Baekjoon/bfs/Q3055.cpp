#include<iostream>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/3055 (탈출)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.10.09 (O)
 **/
int w, h, moves[4][2] = {{-1, 0}, {0, 1}, {1,0}, {0,-1}};
char board[50+1][50+1];
string fail = "KAKTUS";
queue<vector<int>> q;
vector<int> s_dir(2);
bool s_visited[50+1][50+1];

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>h>>w;

    for (int i=0;i<h;i++)
    {
        for (int j=0;j<w;j++)
        {
            cin>>board[i][j];

            if (board[i][j] == '*')
            {
                q.push({i, j, '*'});
            }
            else if (board[i][j] == 'S')
            {
                s_dir = {i, j};
            }
        }
    }

    q.push({s_dir[0], s_dir[1], 'S', 0});
    s_visited[s_dir[0]][s_dir[1]] = true;

    while (!q.empty())
    {
        vector<int> curr = q.front();
        q.pop();

        for (int i=0;i<4;i++)
        {
            int x = curr[0] + moves[i][0];
            int y = curr[1] + moves[i][1];

            // 유효함 && 돌 체크
            if (x < 0 || x >= h || y < 0 || y >= w || board[x][y] == 'X')
            {
                continue;
            }

            if (curr[2] == '*')
            {
                if (board[x][y] == 'D' || board[x][y] == '*')
                {
                    continue;
                }

                board[x][y] = '*';
                q.push({x, y, '*'});
            }
            else if (curr[2] == 'S')
            {
                if (board[x][y] == 'D')
                {
                    cout << curr[3]+1;
                    return 0;
                }

                if (board[x][y] == '*' || s_visited[x][y])
                {
                    continue;
                }

                s_visited[x][y] = true;
                q.push({x, y, 'S', curr[3] + 1});
            }
        }
    }

    cout << fail;
}