#include<iostream>
#include<stack>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2504 (괄호의 값)
 * @classification: stack
 * @문제 푼 날짜 (자력으로 풂?): 25.10.05 (X)
 **/
int tmp = 1, answer = 0;
string str;
stack<char> stk;

int main()
{
    cin>>str;

    for (int i=0;i<str.length();i++)
    {
        if (str[i] == '(')
        {
            tmp *= 2;
            stk.push(str[i]);
        }
        else if (str[i] == '[')
        {
            tmp *= 3;
            stk.push(str[i]);
        }
        else if (stk.empty())
        {
            answer = 0;
            break;
        }
        else if (str[i] == ')')
        {
            if (stk.top() != '(')
            {
                answer = 0;
                break;
            }
            if (str[i-1] == '(')
            {
                answer += tmp;
            }

            tmp /= 2;
            stk.pop();
        }
        else if (str[i] == ']')
        {
            if (stk.top() != '[')
            {
                answer = 0;
                break;
            }
            if (str[i-1] == '[')
            {
                answer += tmp;
            }

            tmp /= 3;
            stk.pop();
        }
        else
        {
            answer = 0;
            break;
        }
    }

    if (!stk.empty())
    {
        answer = 0;
    }

    cout<<answer;
}
