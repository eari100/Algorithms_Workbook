#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1374 (강의실)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.08.31 (O)
 **/
struct compareV
{
    bool operator()(vector<int> a, vector<int> b)
    {
        if (a[1] == b[1])
        {
            return a[2] < b[2];
        }

        return a[1] < b[1];
    }
};

int main()
{
    int n;
    cin >> n;
    vector<vector<int>> v(n, vector<int>(3));
    vector<int> end_times;

    for (int i=0;i<n;i++)
    {
        cin >> v[i][0] >> v[i][1] >> v[i][2];
    }

    sort(v.begin(), v.end(), compareV());

    end_times.push_back(v[0][2]);

    for (int i=1;i<n;i++)
    {
        bool merge = false;
        for (int j=0;j<end_times.size();j++)
        {
            if (end_times[j] <= v[i][1])
            {
                end_times[j] = v[i][2];
                merge = true;
                break;
            }
        }

        if (!merge)
        {
            end_times.push_back(v[i][2]);
        }
    }

    cout << end_times.size();
}