#include <iostream>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/33910 (합의 최소)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.08.22 (O)
 **/
int main()
{
    int n;
    long long sum = 0;
    cin>>n;
    vector<int> vec(n);

    for (int i=0;i<n;i++)
    {
        cin>>vec[i];
    }

    for (int j=n-1;j>=1;j--)
    {
        if (vec[j-1] > vec[j])
        {
            vec[j-1] = vec[j];
        }
    }

    for (int v : vec)
    {
        sum += v;
    }

    cout << sum;
}