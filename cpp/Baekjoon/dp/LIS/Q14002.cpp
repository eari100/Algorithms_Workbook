#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/14002 (가장 긴 증가하는 부분 수열 4)
 * @classification: LIS
 * @문제 푼 날짜 (자력으로 풂?): 25.10.31 (O)
 **/
int n, nums[1000], max_len = 1, last_node = 0, lens[1000], parents[1000];

int main()
{
    cin>>n;

    for (int i=0;i<n;i++)
    {
        cin>>nums[i];
        parents[i] = i;
        lens[i] = 1;
    }

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<i;j++)
        {
            if (nums[j] < nums[i])
            {
                if (lens[j]+1 > lens[i])
                {
                    lens[i] = lens[j]+1;
                    parents[i] = j;

                    if (max_len < lens[i])
                    {
                        max_len = lens[i];
                        last_node = i;
                    }
                }
            }
        }
    }

    cout<<max_len<<'\n';

    int curr_node = last_node;
    string answer = "";
    while (parents[curr_node] != curr_node)
    {
        answer = to_string(nums[curr_node]) + " " +answer;
        curr_node = parents[curr_node];
    }

    answer = to_string(nums[curr_node]) + " " +answer;

    cout << answer;
}