#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/22862 (가장 긴 짝수 연속한 부분 수열 (large))
 * @classification: two pointer
 * @문제 푼 날짜 (자력으로 풂?): 26.04.07 (O, 문제집에서 태그 풀었음)
 **/
int n, k, max_len=0, s=0,e=0,curr_len=0,curr_k=0;
vector<int> v;

int main()
{
    cin>>n>>k;
    v.resize(n);

    for (int i=0;i<n;i++)
    {
        cin>>v[i];
    }

    if (v[s]%2)
    {
        curr_len=0;
        curr_k=1;
    }
    else
    {
        curr_len=1;
        max_len=1;
        curr_k=0;
    }

    while (1)
    {
        e++;

        if (e==n)
        {
            break;
        }

        if (v[e]%2)
        {
            curr_k++;

            while (curr_k>k)
            {
                if (v[s]%2) // 홀수
                {
                    curr_k--;
                }
                else
                {
                    curr_len--;
                }

                s++;
            }
        }
        else
        {
            curr_len++;
        }

        //cout<<"s = " << s << " e = " << e<< " curr_len = " << curr_len << " curr_k " << curr_k << endl;
        max_len=max(max_len,curr_len);
    }

    cout<<max_len;
}