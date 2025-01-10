#include <iostream>
#include <string>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/4096 (팰린드로미터)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.01.09 (O)
 **/
bool isPalindrome(int* nums, int len) // 배열의 크기 len을 인자로 추가
{
    for (int i = 0; i < len / 2; i++)
    {
        int c1 = nums[i];
        int c2 = nums[len - 1 - i];

        if (c1 != c2)
        {
            return false;
        }
    }

    return true;
}

int main()
{
    string str;

    while (true)
    {
        cin >> str;
        int len = str.length(); // 길이를 계산
        int nums[len]; // 배열 크기를 len으로 지정

        if (str == "0") break;

        // 문자열을 숫자 배열로 변환
        for (int i = 0; i < len; i++)
        {
            nums[i] = str[i] - '0';
        }

        int ep = 0;

        while (true)
        {
            // 배열의 길이를 isPalindrome 함수에 전달
            if (isPalindrome(nums, len))
            {
                cout << ep << '\n';
                break;
            }
            ++ep;

            // 마지막 인덱스부터 증가시킴
            int index = len - 1;
            while (index >= 0)
            {
                ++nums[index];

                if (nums[index] < 10)
                {
                    break;
                }

                nums[index] = 0;
                --index;
            }
        }
    }
}
