#include<iostream>
#include<set>

using namespace std;

int n;
set<string> s;
string tmp, sfx = "Cheese";

bool v(string& tmp)
{
    if (tmp.size() < sfx.size())
    {
        return false;
    }

    for (int i=0;i<sfx.size();i++)
    {
        if (tmp[tmp.size()-6+i] != sfx[i])
        {
            return false;
        }
    }

    return true;
}

int main()
{
    cin>>n;
    for (int i=0;i<n;i++)
    {
        cin>>tmp;

        if (v(tmp))
        {
            s.insert(tmp);

            if (s.size() == 4)
            {
                break;
            }
        }
    }

    cout<< (s.size() >= 4 ? "yummy" : "sad");
}