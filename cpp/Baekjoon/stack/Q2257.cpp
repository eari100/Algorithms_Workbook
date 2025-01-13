#include <iostream>
#include <stack>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2257 (화학식량)
 * @classification: stack
 * @문제 푼 날짜 (자력으로 풂?): 25.01.13 (O)
 **/
int main()
{
    string str; cin >> str;
    stack<int> stk;
    int answer = 0;

    for (char c : str)
    {
        if (c >= '1' && c <= '9')
        {
            int mul = c - '0';
            int top = stk.top();
            stk.pop();
            stk.push(top * mul);
        }
        else if (c == ')')
        {
            int tmp = 0;
            while (true)
            {
                int top = stk.top();
                stk.pop();

                if (top == -1)
                {
                    break;
                }

                tmp += top;
            }

            stk.push(tmp);
        }
        else
        {
            if (c == 'H')
            {
                stk.push(1);
            }
            else if (c == 'C')
            {
                stk.push(12);
            }
            else if (c == 'O')
            {
                stk.push(16);
            }
            else if (c == '(')
            {
                stk.push(-1);
            }
        }
    }

    while ( !stk.empty() )
    {
        answer += stk.top();
        stk.pop();
    }

    cout << answer;
}
