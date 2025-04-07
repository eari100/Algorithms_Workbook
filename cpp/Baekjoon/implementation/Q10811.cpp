#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/10811 (바구니 뒤집기)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.04.01 (O)
 **/
void swap(int balls[], int x, int y)
{
    int temp = balls[x];
    balls[x] = balls[y];
    balls[y] = temp;
}

void reverse(int balls[], int str, int end)
{
    while(str < end)
    {
        swap(balls, str, end);
        str++;
        end--;
    }
}

int main()
{
    int n, m, str, end;
    cin >> n >> m;
    int balls[n];
    
    for(int i=0;i<n;i++)
    {
        balls[i] = i + 1;
    }
    
    for(int i=0;i<m;i++)
    {
        cin >> str >> end;
        reverse(balls, str-1, end-1);
    }
    
    for(int ball : balls)
    {
        cout << ball << ' ';
    }
    
    return 0;
}