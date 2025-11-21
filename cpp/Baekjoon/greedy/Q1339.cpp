#include<iostream>
#include<vector>
#include<cmath>
#include<algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1339 (단어 수학)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.11.21 (O)
 **/
int words_cnt;
string word;
vector<int> cal(26, 0); // {알파벳, 계산}
long long answer = 0;

struct comp
{
    bool operator()(int a, int b)
    {
        return a > b;
    }
};

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>words_cnt;

    for (int i=0;i<words_cnt;i++)
    {
        cin >> word;

        for (int j=word.size()-1;j>=0;j--)
        {
            int alp = word[j] - 'A';
            int exp = (word.size()-1) - j;
            int p = pow(10, exp);

            cal[alp] += p;
        }
    }

    sort(cal.begin(), cal.end(), comp());

    int index = 0;
    for (int i=9;i>=1;i--,index++)
    {
        if ( !cal[index] )
        {
            break;
        }

        answer += i * cal[index];
    }

    cout << answer;
}