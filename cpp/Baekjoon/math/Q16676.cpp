#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/16676 (근우의 다이어리 꾸미기)
 * @classification: math
 * @문제 푼 날짜 (자력으로 풂?): 26.01.30 (O)
 **/
int n;

int main() {
    cin >> n;
    int a = 11, b = 1;

    while(n >= a)
    {
        a*=10;
        a++;
        b++;
    }

    cout<<b;
}