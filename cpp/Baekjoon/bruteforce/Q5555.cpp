#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/5555 (반지)
 * @classification: brute-force
 * @문제 푼 날짜 (자력솔?): 25.12.16 (O)
 **/
string target, ring;
int n, answer=0;

int main()
{
    cin>>target>>n;

    for (int i=0;i<n;i++)
    {
        cin>>ring;

        for (int j=0;j<ring.size();j++)
        {
            for (int k=0;k<target.size();k++)
            {
                int idx=(j+k)%ring.size();

                if (ring[idx]!=target[k])
                {
                    break;
                }

                if (k == target.size()-1)
                {
                    answer++;
                    goto match;
                }
            }
        }

        match:;
    }

    cout<<answer;
}