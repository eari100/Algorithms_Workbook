#include<iostream>
#include<deque>
#include<vector>

#define MAX_SIZE 11

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/16235 (나무 재테크)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 26.04.07 (X, deque 잘 활용하자!, 연산자 괄호 실수 하지 말자)
 **/
int n,tree_cnt,year;
int x,y,z;
int ground[MAX_SIZE][MAX_SIZE];
int robot_power[MAX_SIZE][MAX_SIZE];
int dead_energy[MAX_SIZE][MAX_SIZE];
int baby_tree[MAX_SIZE][MAX_SIZE];

vector<vector<deque<int>>> tree_ages
(
    MAX_SIZE,
    vector<deque<int>>
    (
        MAX_SIZE,
        deque<int>()
    )
);
int alive_tree = 0;
int direction[8][2] =
{
    {-1,-1},{-1,0},{-1,1},{0,-1},
    {0,1},{1,-1},{1,0},{1,1}
};

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>n>>tree_cnt>>year;

    for (int i=1;i<=n;i++)
    {
        for (int j=1;j<=n;j++)
        {
            ground[i][j]=5;
            cin>>robot_power[i][j];
        }
    }

    while (tree_cnt--)
    {
        cin>>x>>y>>z;
        tree_ages[x][y].push_back(z);
    }

    // cout
    // for (int i=1;i<=n;i++)
    // {
    //     for (int j=1;j<=n;j++)
    //     {
    //         alive_tree += tree_ages[i][j].size();
    //         cout<<"x : " <<i <<", y : "<< y << endl;
    //         cout<<"alive: "<<tree_ages[i][j].size();
    //         cout<<endl;
    //     }
    // }
    // cout<<"==========================="<<endl;
    //


    while (year--)
    {
        // 초기화
        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=n;j++)
            {
                baby_tree[i][j]=0;
                dead_energy[i][j]=0;
            }
        }


        // 봄: 자신의 나이만큼 양분+, 나이+1
        // 나이가 어린 나무부터 양분을 먹는다
        // 자신의 나이만큼 양분을 먹을수 없는 나무는 즉시 죽는다

        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=n;j++)
            {
                deque<int> alive_q;

                while (tree_ages[i][j].size())
                {
                    int _top =tree_ages[i][j].front();
                    tree_ages[i][j].pop_front();

                    if (ground[i][j] < _top)
                    {
                        dead_energy[i][j]+= (_top/2);
                    }
                    else
                    {
                        // 나무가 에너지 흡수
                        ground[i][j] -= _top;
                        // 나이 +1
                        alive_q.push_back(_top+1);
                        // cout<<"alive: age :"<<_top+1<<endl;
                        // cout<<"dir"<<i<<", "<<j<<endl;
                        // cout<<"top:"<<endl;
                        // cout<<_top+1<<" "<<endl;


                        if ((_top+1) % 5 == 0)
                        {
                            for (int k=0;k<8;k++)
                            {
                                int x=i+direction[k][0];
                                int y=j+direction[k][1];

                                if (x < 1 || x>n || y < 1 || y>n)
                                {
                                    continue;
                                }

                                baby_tree[x][y]++; // 아기 나무 수 증가
                            }
                        }
                    }
                }

                // error
                tree_ages[i][j] = alive_q;
                //cout<<"alive queue size :"<<alive_q.size()<<endl;

                // 여름: 죽은 나무가 양분으로 변하게 된다. 나이를 /2
                ground[i][j] += dead_energy[i][j];
                // 겨울: 로봇 양분 추가
                ground[i][j] += robot_power[i][j];
            }
        }


        // 가을: 나무 번식 5의 배수의 나무 인접 8개의 칸에 나이가 1인 나무 생성
        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=n;j++)
            {
                for (int k=0;k<baby_tree[i][j];k++)
                {
                    // 1살 박이 나무 추가
                    tree_ages[i][j].push_front(1);
                }
            }
        }


        // 출력
        // cout<<"================="<<endl;
        //
        // cout<<"baby tree cnt:"<<endl;
        // for (int i=1;i<=n;i++)
        // {
        //     for (int j=1;j<=n;j++)
        //     {
        //         cout<<baby_tree[i][j]<<" ";
        //     }
        //     cout<<"\n";
        // }
        //
        // cout<<"energy:"<<endl;
        // for (int i=1;i<=n;i++)
        // {
        //     for (int j=1;j<=n;j++)
        //     {
        //         cout<<ground[i][j]<<" ";
        //     }
        //     cout<<"\n";
        // }
        //
        // cout<<"dead energy:"<<endl;
        // for (int i=1;i<=n;i++)
        // {
        //     for (int j=1;j<=n;j++)
        //     {
        //         cout<<dead_energy[i][j]<<" ";
        //     }
        //     cout<<"\n";
        // }
        //
        // // 출력
    }

    for (int i=1;i<=n;i++)
    {
        for (int j=1;j<=n;j++)
        {
            alive_tree += tree_ages[i][j].size();
            // cout<<"x : " <<i <<", y : "<< y << endl;
            // cout<<"alive: "<<tree_ages[i][j].size();
            // cout<<endl;
        }
    }

    cout<<alive_tree;
}