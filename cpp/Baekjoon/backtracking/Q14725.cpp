#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/14725 (개미굴)
 * @classification: backtracking (인 줄 알았는데 이게 트라이라는 자료구조라는 이름이 있는 모양)
 * @문제 푼 날짜 (자력으로 풂?): 25.09.07 (O, C++ 문법은 몰라서 참고함)
 **/
int n, cnt;
string item, line = "--", answer = "";

class hole
{
    public:
        string name;
        vector<hole> child;

        bool operator<(const hole& other) const
        {
            return name < other.name;
        }
};

vector<hole> holes;

void bt(hole& h, string prefix)
{
    cout << prefix << h.name << '\n';

    if (h.child.size() == 0)
    {
        return;
    }

    sort(h.child.begin(), h.child.end());

    for (int i=0;i<h.child.size();i++)
    {
        bt(h.child[i], prefix + line);
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>n;

    for(int i=0;i<n;i++)
    {
        cin>>cnt;
        vector<hole>* curr = &holes;

        for (int j=0;j<cnt;j++)
        {
            cin>>item;

            bool is_exist = false;

            for (hole& h : *curr)
            {
                if (item == h.name)
                {
                    is_exist = true;
                    curr = &h.child;
                    break;
                }
            }

            if (!is_exist)
            {
                curr -> push_back({item});
                curr = &curr->back().child;
            }
        }
    }

    sort(holes.begin(), holes.end());

    for (int i=0;i<holes.size();i++)
    {
        bt(holes[i], "");
    }

    cout << answer << endl;
}