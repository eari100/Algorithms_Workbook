#include <iostream>
#include <vector>
#include <stack>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/3425 (고스택)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.11.11 (X, 지문 이슈)
 **/
string q;
long long input_cnt, x, _MAX = 1'000'000'000;

int main()
{
    while (1)
    {
        vector<string> queries;
        // 쿼리
        while (1)
        {
            getline(cin, q);

            if (q == "QUIT")
            {
                goto a1;
            }

            if (q == "END")
            {
                break;
            }

            queries.push_back(q);
        }

        cin>>input_cnt;
        for (int i=0;i<input_cnt;i++)
        {
            cin>>x;
            stack<long long> stk;

            stk.push(x);

            bool is_error = false;
            for (string query : queries)
            {
                if (query == "POP")
                {
                    if (stk.empty())
                    {
                        is_error = true;
                        break;
                    }

                    stk.pop();
                }
                else if (query == "INV")
                {
                    if (stk.empty())
                    {
                        is_error = true;
                        break;
                    }

                    long long t = stk.top();
                    stk.pop();

                    stk.push(t * -1);
                }
                else if (query == "DUP")
                {
                    if (stk.empty())
                    {
                        is_error = true;
                        break;
                    }

                    stk.push(stk.top());
                }
                else if (query == "SWP")
                {
                    if (stk.size() < 2)
                    {
                        is_error = true;
                        break;
                    }

                    long long t1 = stk.top();
                    stk.pop();
                    long long t2 = stk.top();
                    stk.pop();

                    stk.push(t1);
                    stk.push(t2);
                }
                else if (query == "ADD")
                {
                    if (stk.size() < 2)
                    {
                        is_error = true;
                        break;
                    }

                    long long t1 = stk.top();
                    stk.pop();
                    long long t2 = stk.top();
                    stk.pop();
                    long long sum = t1 + t2;

                    if (abs(sum) > _MAX)
                    {
                        is_error = true;
                        break;
                    }

                    stk.push(sum);
                }
                else if (query == "SUB")
                {
                    if (stk.size() < 2)
                    {
                        is_error = true;
                        break;
                    }

                    long long t1 = stk.top();
                    stk.pop();
                    long long t2 = stk.top();
                    stk.pop();

                    long long sub = t2 - t1;

                    if (abs(sub) > _MAX)
                    {
                        is_error = true;
                        break;
                    }

                    stk.push(sub);
                }
                else if (query == "MUL")
                {
                    if (stk.size() < 2)
                    {
                        is_error = true;
                        break;
                    }

                    long long t1 = stk.top();
                    stk.pop();
                    long long t2 = stk.top();
                    stk.pop();

                    long long mul = t1 * t2;

                    if (abs(mul) > _MAX)
                    {
                        is_error = true;
                        break;
                    }

                    stk.push(mul);
                }
                else if (query == "DIV")
                {
                    if (stk.size() < 2)
                    {
                        is_error = true;
                        break;
                    }

                    long long t1 = stk.top();
                    stk.pop();
                    long long t2 = stk.top();
                    stk.pop();

                    if (t1 == 0)
                    {
                        is_error = true;
                        break;
                    }

                    long long share = abs(t2) / abs(t1);

                    if ( (t1 > 0 && t2 < 0) || (t2 > 0 && t1 < 0) )
                    {
                        share *= -1;
                    }

                    if (abs(share) > _MAX)
                    {
                        is_error = true;
                        break;
                    }

                    stk.push(share);
                }
                else if (query == "MOD")
                {
                    if (stk.size() < 2)
                    {
                        is_error = true;
                        break;
                    }

                    long long t1 = stk.top();
                    stk.pop();
                    long long t2 = stk.top();
                    stk.pop();

                    if (t1 == 0)
                    {
                        is_error = true;
                        break;
                    }

                    long long md = abs(t2) % abs(t1);

                    if ( t2 < 0 )
                    {
                        md *= -1;
                    }

                    if (abs(md) > _MAX)
                    {
                        is_error = true;
                        break;
                    }

                    stk.push(md);
                }
                // NUM
                else
                {
                    long long x = 0;
                    for (int j=0;j<query.size();j++)
                    {
                        if (query[j] == ' ')
                        {
                            j++;
                            for (;j<query.size();j++)
                            {
                                int curr = query[j] - '0';

                                x *= 10;
                                if (abs(x) > _MAX)
                                {
                                    is_error = true;
                                    goto a2;
                                }

                                x += curr;
                                if (abs(x) > _MAX)
                                {
                                    is_error = true;
                                    goto a2;
                                }
                            }
                        }
                    }

                    stk.push(x);
                }
            }

            if (stk.size() != 1)
            {
                is_error = true;
            }

            a2:
            if (is_error)
            {
                cout << "ERROR" << '\n';
            }
            else
            {
                cout << stk.top() << '\n';
            }
        }
        cout<<'\n';

        getline(cin,q);
        getline(cin,q);
    }

    a1:
    return 0;
}