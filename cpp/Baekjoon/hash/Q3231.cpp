#include<iostream>
#include<unordered_map>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/3231 (카드놀이)
 * @classification: hash
 * @문제 푼 날짜 (자력으로 풂?): 25.09.21 (O)
 **/
int main()
{
    unordered_map<int, int> um;
    int n, clap = 0, tmp;
    cin>>n;

    for (int i=0;i<n;i++)
    {
        cin>>tmp;
        um[tmp] = i;
    }

    for (int curr=1;curr<n;curr++)
    {
        int next = curr+1;

        if (um[curr] > um[next])
        {
            ++clap;
        }
    }

    cout<<clap;
}
