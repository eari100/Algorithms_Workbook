#include<iostream>
#include<vector>
#include<cmath>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/18221 (교수님 저는 취업할래요)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.06.26 (O)
 **/
int main()
{
  int n, professor[2], sungyu[2], distance, x1, x2, y1, y2, students = 0;
  cin >> n;
  vector<vector<int>> classroom(n, vector<int>(n));

   for(int i=0;i<n;i++)
   {
     for(int j=0;j<n;j++)
     {
       cin >> classroom[i][j];

       if(classroom[i][j] == 5)
       {
         professor[0] = i;
         professor[1] = j;
       }
       else if(classroom[i][j] == 2)
       {
         sungyu[0] = i;
         sungyu[1] = j;
       }
     }
   }

  distance = (int) pow(professor[0] - sungyu[0], 2) + (int) pow(professor[1] - sungyu[1], 2);

   if(distance < 25)
   {
     cout << 0;
     return 0;
   }

   if(professor[0] < sungyu[0])
   {
     x1 = professor[0];
     x2 = sungyu[0];
   }
   else
   {
     x1 = sungyu[0];
     x2 = professor[0];
   }

   if(professor[1] < sungyu[1])
   {
     y1 = professor[1];
     y2 = sungyu[1];
   }
   else
   {
     y1 = sungyu[1];
     y2 = professor[1];
   }

   for(int i=x1;i<=x2;i++)
   {
     for(int j=y1;j<=y2;j++)
     {
       if(classroom[i][j] == 1)
       {
         students++;
       }
     }
   }

  cout << (students >= 3 ? 1 : 0);
}