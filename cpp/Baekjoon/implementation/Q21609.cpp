#include <iostream>
#include <vector>
#include <deque>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/21609 (상어 중학교)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 26.04.11 (X, 문제의 요구사항 놓치는 실수, 회전, 중력, bfs 로직을 잘 구현했으니 업솔빙할 필요가 없을듯)
 **/
int n,m, board[20][20], score = 0;
int null_block = -100;
bool shared_visited[20][20];
bool unshared_visited[20][20];

int moves[4][2] = {{-1,0},{0,1},{1,0},{0,-1}};

void _debug(string memo)
{
    // cout <<"============"<<memo<<"================="<<endl;
    // for (int i=0;i<n;i++)
    // {
    //     for (int j=0;j<n;j++)
    //     {
    //         cout<<board[i][j]<<" ";
    //     }
    //     cout<<endl;
    // }
}

void isv()
{
    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
            shared_visited[i][j] = 0;
        }
    }
}

void iusv()
{
    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
            unshared_visited[i][j] = 0;
        }
    }
}

vector<pair<int,int>> get_biggest_block_group()
{
    isv();
    vector<pair<int,int>> biggest;
    int max_rainbow = 0;
    int a = 0, b = 0;

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
            if (board[i][j] > 0 && !shared_visited[i][j]) // 일반 블럭
            {
                iusv();
                int rainbow = 0, base_x = i, base_y = j;
                int color = board[i][j];
                vector<pair<int,int>> bg;
                bg.push_back({i, j});
                shared_visited[i][j] = 1;

                deque<pair<int,int>> q;
                q.push_back({i,j});

                while (q.size())
                {
                    pair<int,int> f = q.front();
                    q.pop_front();

                    for (int k=0;k<4;k++)
                    {
                        int x = f.first + moves[k][0];
                        int y = f.second + moves[k][1];

                        if (x < 0 || x >= n|| y < 0 || y >= n || board[x][y] < 0) // 검은 블록 && null
                        {
                            continue;
                        }

                        // 무지개 (여러번 방문 가능)
                        if (board[x][y] == 0 && !unshared_visited[x][y])
                        {
                            ++rainbow;
                            bg.push_back({x, y});
                            unshared_visited[x][y] = 1;
                            q.push_back({x,y});
                        }
                        // 기준과 동일 컬러
                        else if (board[x][y] == color && !shared_visited[x][y])
                        {
                            bg.push_back({x, y});
                            shared_visited[x][y] = 1;
                            q.push_back({x,y});
                        }
                    }
                }


                // print
                // cout<<"======================"<<endl;
                // cout<<"i "<<i<<" j "<<j<<endl;
                // for (pair<int,int> b: bg)
                // {
                //     cout<<"("<<b.first<<", "<<b.second<<")"<<", ";
                // }
                // cout<<endl;
                // print

                if (bg.size() >= 2)
                {
                    if (biggest.size() < bg.size())
                    {
                        max_rainbow = rainbow;
                        a = base_x;
                        b = base_y;
                        biggest = bg;
                    }
                    else if (biggest.size() == bg.size())
                    {
                        if (max_rainbow < rainbow)
                        {
                            max_rainbow = rainbow;
                            a = base_x;
                            b = base_y;
                            biggest = bg;
                        }
                        else if (max_rainbow == rainbow)
                        {
                            if (a < base_x)
                            {
                                max_rainbow = rainbow;
                                a = base_x;
                                b = base_y;
                                biggest = bg;
                            }
                            else if (a == base_x)
                            {
                                if (b < base_y)
                                {
                                    max_rainbow = rainbow;
                                    a = base_x;
                                    b = base_y;
                                    biggest = bg;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    return biggest;
}

void clear_bg(vector<pair<int,int>> bg)
{
    //cout<<"s = "<<(bg.size() * bg.size())<<endl;
    score += (bg.size() * bg.size());

    for (pair<int,int> p : bg)
    {
        board[p.first][p.second] = null_block;
    }
}

void apply_gravity()
{
    for (int i=n-2;i>=0;i--)
    {
        for (int j=0;j<n;j++)
        {
            if (board[i][j]>=0)
            {
                for (int k=i;k<n-1;k++)
                {
                    // 아래로 떨어짐처리
                    if (board[k][j] >= 0 && board[k+1][j] == null_block)
                    {
                        board[k+1][j] = board[k][j];
                        board[k][j] = null_block;
                    }
                }
            }
        }
    }
}

void rotate()
{
    int r_board[20][20];

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
            int x = n-1-j;
            int y = i;

            r_board[x][y] = board[i][j];
        }
    }

    // copy
    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
            board[i][j] = r_board[i][j];
        }
    }
}

// 블록 그룹 => 일반(단색( + 무지개, 2<=,
int main()
{
    cin>>n>>m;

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
            cin>>board[i][j];
        }
    }

    while (1)
    {
        vector<pair<int,int>> gb = get_biggest_block_group();

        if (gb.size() == 0)
        {
            break;
        }

        clear_bg(gb);
        _debug("clear");

        apply_gravity();
        _debug("grv1");
        rotate();
        _debug("rotate");
        apply_gravity();
        _debug("grv2");
    }

    cout<<score;
}