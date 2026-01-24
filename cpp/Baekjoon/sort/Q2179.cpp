#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2179 (비슷한 단어)
 * @classification: sort
 * @문제 푼 날짜 (자력으로 풂?): 26.01.24 (O)
 **/
struct item
{
    string str;
    int idx;
};

struct comp
{
    bool operator()(item a, item b)
    {
        return a.str < b.str;
    }
};

int n, max_match = 0;
vector<item> v;
string s;
vector<item> answer(2);

int get_match(string a, string b)
{
    int len = min(a.size(), b.size());
    int match = 0;

    for(int i=0;i<len;i++)
    {
        if(a[i] != b[i])
        {
            break;
        }

        ++match;
    }

    return match;
}

int main()
{
    cin>>n;

    for(int i=0;i<n;i++)
    {
        cin>>s;
        v.push_back({s, i});
    }

    sort(v.begin(), v.end(), comp());

    int i = 1;
    while(i < v.size())
    {
        int match = get_match(v[i-1].str, v[i].str);
        vector<item> tmp(2);

        if(match > 0 && match >= max_match)
        {
            item a, b;

            if(v[i-1].idx < v[i].idx)
            {
                a = v[i-1];
                b = v[i];
            }
            else
            {
                a = v[i];
                b = v[i-1];
            }

            tmp = {a, b};

            i++;
            while(i<v.size())
            {
                int match2 = get_match(v[i-1].str, v[i].str);

                if(match == match2)
                {
                    if(v[i].idx < tmp[0].idx)
                    {
                        tmp[1] = tmp[0];
                        tmp[0] = v[i];
                    }
                    else if(v[i].idx < tmp[1].idx)
                    {
                        tmp[1] = v[i];
                    }

                    i++;
                }
                else
                {
                    i--;
                    break;
                }
            }

            if(match > max_match)
            {
                max_match = match;
                answer[0] = tmp[0];
                answer[1] = tmp[1];
            }
            else if(match == max_match)
            {
                if(tmp[0].idx < answer[0].idx)
                {
                    answer[0] = tmp[0];
                    answer[1] = tmp[1];
                }
            }
        }

        i++;
    }

    cout<<answer[0].str<<'\n'<<answer[1].str;
}