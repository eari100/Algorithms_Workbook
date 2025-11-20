#include<iostream>
#include<vector>
#include<cmath>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/12873 (기념품)
 * @classification: implementation
 * @문제 푼 날짜 (자력솔?): 25.11.20 (X, 못 푼것과 별개로 여담으로 지문이 안좋음)
 **/
int n, index = 0;
long long t = 1, t3;
vector<int> v;

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>n;

    for (int i=1;i<=n;i++)
    {
        v.push_back(i);
    }

    if (n == 1) {
        cout << 1;
        return 0;
    }

    while (1)
    {
        t3 = pow(t, 3);

        long long remain = t3 % v.size();
        index += remain;

        if (index > 0)
            index %= v.size();
        index--;
        if (index == -1)
        {
            index = v.size()-1;
        }

        v.erase(v.begin() + index);

        if (v.size() == 1)
        {
            cout<<v[0];
            break;
        }

        t++;
    }
}