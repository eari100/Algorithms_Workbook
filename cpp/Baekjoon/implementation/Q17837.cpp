#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/17837 (새로운 게임 2)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.11.04 (O)
 **/
int turn = 1, player_cnt, n, color_board[12][12], moves[4][2] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
// 플레이어 번호는 1부터
vector<vector<int>> players; // x, y, z, dir
int player_board[12][12][4]; // 해당 자리에 플레이어 번호 쓰기
int x, y, d;

int get_reverse_dir(int dir)
{
    if (dir == 0)
    {
        return 1;
    }
    else if (dir == 1)
    {
        return 0;
    }
    else if (dir == 2)
    {
        return 3;
    }
    else
    {
        return 2;
    }
}

int get_player_len(int x, int y)
{
    int horse_len = 0;

    for (int z=0;z<3;z++)
    {
        if (!player_board[x][y][z])
        {
            break;
        }

        horse_len++;
    }

    return horse_len;
}

bool is_blue(int x, int y)
{
    if (x < 0 || x >= n || y < 0 || y >= n || color_board[x][y] == 2)
    {
        return true;
    }

    return false;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>n>>player_cnt;

    for (int i=0; i<n; i++)
    {
        for (int j=0; j<n; j++)
        {
            cin>>color_board[i][j];
        }
    }

    players.resize(player_cnt+1);

    for (int i=1;i<=player_cnt;i++)
    {
        cin>>x>>y>>d;
        x--;
        y--;
        d--;

        int player_len = get_player_len(x, y);
        if (player_len == 3)
        {
            cout << 0;
            return 0;
        }

        player_board[x][y][player_len] = i;
        players[i] = {x, y, player_len, d};
    }

    while (turn <= 1000)
    {
        for (int i=1;i<=player_cnt;i++)
        {
            vector<int> player = players[i];
            int dir = player[3];
            int next_x = player[0] + moves[dir][0];
            int next_y = player[1] + moves[dir][1];

            // blue
            if (is_blue(next_x, next_y))
            {
                dir = get_reverse_dir(dir);
                players[i][3] = dir;

                next_x = player[0] + moves[dir][0];
                next_y = player[1] + moves[dir][1];

                if (is_blue(next_x, next_y))
                {
                    continue;
                }
            }

            // white
            if (color_board[next_x][next_y] == 0)
            {
                int c_player_len = get_player_len(player[0], player[1]);
                int n_players_len = get_player_len(next_x, next_y);
                int from_len = c_player_len - player[2];

                if (from_len + n_players_len >= 4)
                {
                    cout<<turn;
                    return 0;
                }

                for (int c_len=player[2];c_len<c_player_len;c_len++,n_players_len++)
                {
                    int player_no = player_board[player[0]][player[1]][c_len];
                    player_board[next_x][next_y][n_players_len] = player_no;
                    player_board[player[0]][player[1]][c_len] = 0; // 비워주기

                    // 방향 빼고 변경
                    players[player_no] [0] = next_x;
                    players[player_no] [1] = next_y;
                    players[player_no] [2] = n_players_len;
                }
            }
            // red
            else if (color_board[next_x][next_y] == 1)
            {
                int c_player_len = get_player_len(player[0], player[1]);
                int n_players_len = get_player_len(next_x, next_y);
                int from_len = c_player_len - player[2];

                if (from_len + n_players_len >= 4)
                {
                    cout<<turn;
                    return 0;
                }

                for (int c_len=c_player_len-1;c_len>=player[2];c_len--,n_players_len++)
                {
                    int player_no = player_board[player[0]][player[1]][c_len];

                    player_board[next_x][next_y][n_players_len] = player_no;
                    player_board[player[0]][player[1]][c_len] = 0;

                    players[player_no] [0] = next_x;
                    players[player_no] [1] = next_y;
                    players[player_no] [2] = n_players_len;
                }
            }
        }

        // cout << "turn : " << turn << endl;
        // for (int i=1;i<=player_cnt;i++)
        // {
        //     cout << "players: " << i << endl;
        //     cout << "x: " << players[i][0] << "y: " << players[i][1] << "z: " << players[i][2] << "dir: " << players[i][3]  << endl;
        //     cout << "================"<< endl;
        // }

        turn++;
    }

    cout << -1;
}