#include<iostream>
#include<vector>
#include<queue>
#include <tuple>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/17142 (연구소 3)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 26.01.12 (X, 난독 이슈)
 **/
int n,m,blank_cnt=0;
int board[50][50];
vector<pair<int, int>> virus;
bool active_virus[10];
bool visited[50][50];
int answer = 2500+5;
int moves[4][2] = {{-1,0},{0,1},{1,0},{0,-1}};

void bfs()
{
    queue<tuple<int, int, int>> q;
    int t=0;
    int visited_blank=0;

    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            visited[i][j] = false;
        }
    }

    for(int i=0;i<10;i++)
    {
        if(active_virus[i])
        {
            q.push({virus[i].first, virus[i].second,0});
            visited[virus[i].first][virus[i].second] = true;
        }
    }

    while(q.size())
    {
        tuple<int,int,int> _front = q.front();
        q.pop();
        int next_time = get<2>(_front)+1;

        for(int i=0;i<4;i++)
        {
            int x = get<0>(_front)+moves[i][0];
            int y = get<1>(_front)+moves[i][1];

            if(x<0||x>=n||y<0||y>=n||visited[x][y]||board[x][y]==1)
            {
                continue;
            }

            visited[x][y] = true;
            t = next_time;

            if(board[x][y] == 0)
            {
                ++visited_blank;

                if(visited_blank == blank_cnt)
                {
                    goto a;
                }
            }

            q.push({x,y,next_time});
        }
    }

    a:;
    if(visited_blank == blank_cnt)
    {
        answer=min(answer,t);
    }
}

void dfs(int virus_idx, int cnt)
{
    if(cnt == m)
    {
        bfs();
        return;
    }

    for(int i=virus_idx;i<virus.size();i++)
    {
        active_virus[i] = true;
        dfs(i+1, cnt+1);
        active_virus[i] = false;
    }
}

int main()
{
    cin>>n>>m;

    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            cin>>board[i][j];

            if(board[i][j] == 0)
            {
                blank_cnt++;
            }
            else if(board[i][j] == 2)
            {
                virus.push_back({i,j});
            }
        }
    }

    if(blank_cnt==0)
    {
        cout<<0;
        return 0;
    }

    dfs(0,0);

    cout<<(answer==2505?-1:answer);
}