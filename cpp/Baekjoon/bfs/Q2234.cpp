#include<iostream>
#include<vector>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2234 (성곽)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.12.07 (O)
 **/
int w, h;
int moves[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
int board[50][50];
int room_id[50][50];
int max_room_size = 0, max_merge_room_size = 0;
vector<int> room_size_list;

// 서: 1, 북: 2, 동: 4, 남: 8
int dir[4][2] = {{8, 2}, {4, 1}, {2, 0}, {1, 3}};

vector<int> get_terminal(int wall)
{
    vector<int> terminal;
    int terminal_sum = 15 - wall;

    for (int i=0;i<4;i++)
    {
        if (terminal_sum >= dir[i][0])
        {
            terminal_sum -= dir[i][0];
            terminal.push_back(dir[i][1]);
        }

        if ( !terminal_sum )
        {
            break;
        }
    }

    return terminal;
}

int main()
{
    cin>>w>>h;
    room_size_list.push_back(-1);

    for (int i=0;i<h;i++)
    {
        for (int j=0;j<w;j++)
        {
            cin>>board[i][j];
        }
    }

    for (int i=0;i<h;i++)
    {
        for (int j=0;j<w;j++)
        {
            if (room_id[i][j] == 0)
            {
                int id = room_size_list.size();
                queue<pair<int, int>> q;
                q.push({i, j});
                room_id[i][j] = id;
                int room_size = 1;

                while (q.size())
                {
                    pair<int, int> f = q.front();
                    q.pop();

                    vector<int> termial = get_terminal(board[f.first][f.second]);

                    for (int t : termial)
                    {
                        int x = f.first + moves[t][0];
                        int y = f.second + moves[t][1];

                        if (x < 0 || x >= h || y < 0 || y >= w || room_id[x][y])
                        {
                            continue;
                        }

                        ++room_size;
                        q.push({x, y});
                        room_id[x][y] = id;
                    }
                }

                room_size_list.push_back(room_size);
                max_room_size = max(max_room_size, room_size);
            }
        }
    }

    for (int i=0;i<h;i++)
    {
        for (int j=0;j<w;j++)
        {
            for (int k=0;k<4;k++)
            {
                int x = i + moves[k][0];
                int y = j + moves[k][1];

                if (x < 0 || x >= h || y < 0 || y >= w || room_id[i][j] == room_id[x][y])
                {
                    continue;
                }

                max_merge_room_size = max(max_merge_room_size, room_size_list[room_id[i][j]] + room_size_list[room_id[x][y]]);
            }
        }
    }

    cout<< room_size_list.size()-1 << '\n' << max_room_size << '\n' << max_merge_room_size;
}