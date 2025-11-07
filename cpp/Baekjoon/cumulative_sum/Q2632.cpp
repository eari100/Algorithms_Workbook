#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2632 (피자판매)
 * @classification: cumulative sum
 * @문제 푼 날짜 (자력으로 풂?): 25.11.07 (O)
 **/
int target, n, m, p1[1000], p2[1000], a1[2'000'001], a2[2'000'001], answer = 0, sum;

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>target>>n>>m;;

    sum = 0;
    for (int i=0;i<n;i++)
    {
        cin>>p1[i];
        sum+=p1[i];
    }
    if (sum == target)
    {
        ++answer;
    }
    else if (sum < target)
    {
        a1[sum]++;
    }

    sum = 0;
    for (int i=0;i<m;i++)
    {
        cin>>p2[i];
        sum+=p2[i];
    }
    if (sum == target)
    {
        ++answer;
    }
    else if (sum < target)
    {
        a2[sum]++;
    }


    for (int i=0;i<n;i++)
    {
        int temp = 0, index = i;

        for (int j=0;j<n-1;j++)
        {
            temp += p1[index];

            if (temp == target)
            {
                ++answer;
                break;
            }
            else if (temp > target)
            {
                break;
            }

            a1[temp]++;
            index++;

            if (index == n)
            {
                index = 0;
            }
        }
    }

    for (int i=0;i<m;i++)
    {
        int temp = 0, index = i;

        for (int j=0;j<m-1;j++)
        {
            temp += p2[index];

            if (temp == target)
            {
                ++answer;
                break;
            }
            else if (temp > target)
            {
                break;
            }

            a2[temp]++;
            index++;

            if (index == m)
            {
                index = 0;
            }
        }
    }

    for (int i=1;i<target;i++)
    {
        if (a1[i])
        {
            int y = target - i;
            answer += a2[y] * a1[i];
        }
    }

    cout << answer;
}