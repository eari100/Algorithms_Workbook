#include<algorithm>
#include<iomanip>
#include<iostream>
#include<vector>

/**
 * @source: https://www.acmicpc.net/problem/16022 (Voronoi Villages)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.09.27 (O)
 **/
using namespace std;

int main()
{
    int n;
    cin>>n;

    vector<double> nums(n);
    vector<double> dists(n-1);
    double _min = 2'000'000'000.0;

    for (int i=0;i<n;i++)
    {
        cin>>nums[i];
    }

    sort(nums.begin(), nums.end());

    for (int i=0;i<n-1;i++)
    {
        dists[i] = (nums[i+1]-nums[i]) / 2;
    }

    for (int i=0;i<n-2;i++)
    {
        _min = min(_min, dists[i] + dists[i+1]);
    }
    
    cout << fixed << setprecision(1) << _min;
}