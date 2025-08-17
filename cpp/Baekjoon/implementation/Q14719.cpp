#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/14719 (빗물)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.08.17 (O)
 **/
int main()
{
    int h, w, answer = 0;
    cin >> h >> w;
    vector<int> v(w);
    for(int i=0;i<w;i++)
    {
        cin>>v[i];
    }

    int index = -1;
    for (int i=0;i<w;i++)
    {
        if (v[i] > 0)
        {
            index = i;
            break;
        }
    }

    if (index == -1)
    {
        cout << 0;
        return 0;
    }

    while (index < w)
    {
        int max_h = 0, next_index = -1;
        for (int i=index+1;i<w;i++)
        {
            if (v[index] <= v[i])
            {
                max_h = v[i];
                next_index = i;
                break;
            }
            else if (max_h < v[i])
            {
                max_h = v[i];
                next_index = i;
            }
        }

        if (max_h == 0)
        {
            break;
        }

        int water = min(v[index], v[next_index]);
        for (int i=index+1;i<next_index;i++)
        {
            answer += water - v[i];
        }

        index = next_index;
    }

    cout << answer;
}