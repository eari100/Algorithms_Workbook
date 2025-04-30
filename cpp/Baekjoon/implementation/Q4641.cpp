#include<iostream>
#include<set>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/4641 (Doubles)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.04.30 (O)
 **/
int main()
{
    while (1)
    {
        int first;
        cin >> first;

        if (first == -1)
        {
            break;
        }
        else
        {
            set<int> nums;
            nums.insert(first);
            while (cin >> first)
            {
                if (first == 0) break;

                nums.insert(first);
            }

            int count = 0;

            for (set<int>::iterator it = nums.begin();it != nums.end();it++ )
            {
                if (nums.find(*it * 2) != nums.end())
                {
                    count++;
                }
            }

            cout << count << '\n';
        }
    }
}