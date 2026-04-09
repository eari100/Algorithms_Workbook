#include<iostream>
#include<set>
#include<deque>
#include<vector>

#define MAX 55

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1109 (섬)
 * @classification: bfs
 * @문제 푼 날짜 (자력솔?): 26.04.09 (X)
 **/
char mark;
int n,m;
int moves[8][2] =
{
    {-1,0},{0,1},{1,0},{0,-1},
    {-1,1},{1,1},{1,-1},{-1,-1}
};
bool is_isl[MAX][MAX], visited[MAX][MAX];
vector<int> answer;

bool is_out(int& x, int& y)
{
    return x < 0 || x > n+2 || y < 0 || y > m+2;
}

set<pair<int,int>> search(bool b_is_isl, pair<int,int> p)
{
    set<pair<int,int>> ant;
    deque<pair<int,int>> q;
    q.push_back(p);
    int move_range = b_is_isl ? 8 : 4;

    while(q.size())
    {
        pair<int,int> f = q.front();
        q.pop_front();

        if(visited[f.first][f.second])
        {
            continue;
        }

        visited[f.first][f.second] = 1;

        for(int i=0;i<move_range;i++)
        {
            int x2 = f.first + moves[i][0];
            int y2 = f.second + moves[i][1];

            if(is_out(x2, y2) || visited[x2][y2])
            {
                continue;
            }

            if(b_is_isl == is_isl[x2][y2])
            {
                q.push_back({x2, y2});
            }
            else
            {
                ant.insert({x2, y2});
            }
        }
    }

    return ant;
}

int get_max_child_isl_height(set<pair<int,int>> seas)
{
//    cout<<"===========seas"<<endl;
//    for(pair<int,int> ss : seas)
//    {
//        cout<<ss.first <<", "<< ss.second <<"| ";
//    }
//    cout<<endl;

    int result = 0;
    set<pair<int,int>> islands;

    // 바다 찾고 인접한 섬은 결과로 주기
    for(auto& s : seas)
    {
        if(visited[s.first][s.second])
        {
            continue;
        }

        set<pair<int,int>> tmp = search(0, s);
        for(auto p : tmp)
        {
            islands.insert(p);
        }
    }

//    cout<<"===========islands"<<endl;
//    for(pair<int,int> ss : islands)
//    {
//        cout<<ss.first <<", "<< ss.second <<"| ";
//    }
//    cout<<endl;

    // 섬 찾고 인접한 바다는 결과로 주기
    for(auto& i : islands)
    {
        if(visited[i.first][i.second])
        {
            continue;
        }

        set<pair<int,int>> seas2 = search(1, i);
        result = max(result, get_max_child_isl_height(seas2)+1);
    }

    // cout<<"result: "<<result<<endl;
    if(answer.size() == result)
    {
        answer.push_back(0);
    }

    answer[result]++;

    return result;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>n>>m;

    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=m;j++)
        {
            cin>>mark;

            if(mark == 'x')
            {
                is_isl[i][j] = 1;
            }
        }
    }

    get_max_child_isl_height({{0,0}});

    if(answer.size() == 1)
    {
        cout<<-1;
    }
    else
    {
        for(int i=0;i<answer.size()-1;i++)
        {
            cout<<answer[i]<<" ";
        }
    }
}