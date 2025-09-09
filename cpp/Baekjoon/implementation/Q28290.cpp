#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/28290 (안밖? 밖안? 계단? 역계단?)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.09.09 (O)
 **/
int main()
{
    string str;
    cin>>str;

    if (str == "fdsajkl;" || str == "jkl;fdsa")
    {
        cout << "in-out";
    }
    else if (str == "asdf;lkj" || str == ";lkjasdf")
    {
        cout << "out-in";
    }
    else if (str == "asdfjkl;")
    {
        cout << "stairs";
    }
    else if (str == ";lkjfdsa")
    {
        cout << "reverse";
    }
    else
    {
        cout << "molu";
    }
}