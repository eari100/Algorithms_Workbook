#include<iostream>
#include<vector>
#include<set>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/3018 (캠프파이어)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.11.29 (O)
 **/
int n, day;
set<int> memories[100+1];
int new_song = 0;

int main()
{
    cin>>n>>day;

    memories[1].insert(1);

    while (day--)
    {
        int tmp_cnt;
        int num;
        bool exist_1 = false;

        cin>>tmp_cnt;

        vector<int> _tmp;

        for (int i=0;i<tmp_cnt;i++)
        {
            cin>>num;

            if (num == 1)
            {
                exist_1 = true;
            }
            else
            {
                _tmp.push_back(num);
            }
        }

        if (exist_1)
        {
            // 새로운 곡 제작
            new_song++;
            int title = -new_song;

            // 선영이가 새로운 곡은 기억
            memories[1].insert(title);

            // 선영이 노래 그리고 새로운 곡 기억
            for (int i=0;i<_tmp.size();i++)
            {
                memories[_tmp[i]].insert(1);
                memories[_tmp[i]].insert(title);
            }
        }
        else
        {
            // 아는 거 서로 공유
            set<int> share;
            for (int i=0;i<_tmp.size();i++)
            {
                for (int song : memories[_tmp[i]])
                {
                    share.insert(song);
                }
            }

            for (int song : share)
            {
                for (int node : _tmp)
                {
                    memories[node].insert(song);
                }
            }
        }
    }

    for (int i=1;i<=n;i++)
    {
        if (memories[i].size() == new_song+1)
        {
            cout << i << '\n';
        }
    }
}