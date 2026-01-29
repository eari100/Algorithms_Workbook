#include<iostream>

using namespace std;

int t,n, players[10'000+1];
bool visited[10'000+1];

int main()
{
    cin>>t;

    while(t--)
    {
       cin>>n;

       for(int i=1;i<=n;i++)
       {
           cin>>players[i];
           visited[i] = false;
       }

       bool f = false;
       int curr=1,call=0;

       while(1)
       {
           if(visited[curr])
           {
               f = true;
               break;
           }

           visited[curr] = true;

           if(curr == n)
           {
               break;
           }

           curr = players[curr];
           call++;
       }

       if(f)
       {
            cout<<0<<'\n';
       }
       else
       {
           cout<<call<<'\n';
       }
    }
}