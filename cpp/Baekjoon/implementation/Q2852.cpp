#include<iostream>

using namespace std;

int n, team, curr_time = 0, prev_time = 0;
string _time;
int sca = 0, scb = 0;
int vta = 0,vtb = 0;

// c style
char* wook_to_string(int i, char* buf)
{
    int pos = 11;
    buf[pos] = '\0';

    if(i == 0)
    {
        buf[--pos] = '0';
        return &buf[pos];
    }

    while(i)
    {
        int mod = (i%10);
        buf[--pos] = ('0' + mod);
        i/=10;
    }

    if(i < 0)
    {
        buf[--pos] = '-';
    }

    return &buf[pos];
}

int its(string str)
{
    int m = 10 * (str[0] - '0') + (str[1] - '0');
    int s = 10 * (str[3] - '0') + (str[4] - '0');

    return m * 60 + s;
}

string sti(int i)
{
    string result = "";
    int m = i/60;
    int s = i%60;

    if(m < 10)
    {
        result += '0';
    }

    char buf[12];
    result += wook_to_string(m, buf);

    result += ':';

    if(s < 10)
    {
        result += '0';
    }

    result += wook_to_string(s, buf);

    return result;
}

int main()
{
    cin>>n;

    for(int i=0;i<n;i++)
    {
        cin>>team>>_time;

        curr_time = its(_time);
        int diff = (curr_time-prev_time);
        prev_time = curr_time;

        if(sca > scb)
        {
            vta += diff;
        }
        else if(sca < scb)
        {
            vtb += diff;
        }

        if(team == 1)
        {
            ++sca;
        }
        else
        {
            ++scb;
        }
    }

    int last = its("48:00");
    int ldiff = (last - curr_time);

    if(sca > scb)
    {
        vta += ldiff;
    }
    else if(sca < scb)
    {
        vtb += ldiff;
    }

    cout<<sti(vta)<<'\n'<<sti(vtb);
}