#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/14394 (9-퍼즐)
 * @classification: implementation
 * @문제 푼 날짜 (자력솔?): 25.10.22 (O)
 **/
string s1, s2;
int arr[26];

int main()
{
    cin>>s1>>s2;

    for (int i=0;i<10;i++)
    {
        if (s1[i]!='*')
        {
            arr[s1[i]-'A']++;
        }

        if (s2[i]!='*')
        {
            arr[s2[i]-'A']--;
        }
    }

    cout << ((abs(arr['R'-'A']) + abs(arr['G'-'A']) + abs(arr['B'-'A']) + abs(arr['Y'-'A'])) / 2);
}