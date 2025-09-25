#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2564 (경비원)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.09.25 (O)
 **/
int w, h, store_cnt, dir, dist, min_sum = 0, my_dir;
vector<int> stores;

int to_index(int dir, int dist)
{
    if (dir == 2) // 밑
    {
        return dist;
    }
    else if (dir == 4) // 오른쪽
    {
        return w + (h - dist);
    }
    else if (dir == 1)  // 위
    {
        return w + h + (w - dist);
    }
    else // 왼
    {
        if (dist == h)
        {
            return 0;
        }
        else
        {
            return w * 2 + h + dist;
        }
    }
}

int main()
{
    cin>>w>>h>>store_cnt;

    for (int i=0;i<store_cnt;i++)
    {
        cin>>dir>>dist;
        stores.push_back(to_index(dir, dist));
    }

    cin>>dir>>dist;
    my_dir = to_index(dir, dist);

    int last_index = 2 * h + 2 * w;

    for (int i=0;i<store_cnt;i++)
    {
        int one_line = abs(my_dir - stores[i]);
        int two_line;

        if (my_dir < stores[i])
        {
            two_line = my_dir + (last_index - stores[i]);
        }
        else
        {
            two_line = stores[i] + (last_index - my_dir);
        }

        min_sum += min(one_line, two_line);
    }

    cout<<min_sum;
}