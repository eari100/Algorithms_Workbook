#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/11387 (님 무기가 좀 나쁘시네여)
 * @classification: math, floating point error(100 으로 나누지 않도록 조정해줘야 합니다)
 * @문제 푼 날짜 (자력으로 풂?): 25.09.09 (X)
 **/
// 힘과 공격력 0 ~ 20,000
// 치명타 확률 0 ~ 200 (%)
// 치명타 피해비율, 공격속도 증가 0 ~ 500 (%)
long long get_battle_point(long long attack, long long power, long long cc, long long chdr, long long atk_speed)
{
    return attack * (100 + power) * ( 100 * (100 - min(cc, 100LL)) + min(cc, 100LL) *  chdr ) * (100 + atk_speed);
}

int main()
{
    long long datas[4][5];

    for (long long i=0; i<4; i++)
    {
        for (long long j=0;j<5;j++)
        {
            cin >> datas[i][j];
        }
    }

    long long weapon_cri = get_battle_point(datas[0][0],datas[0][1],datas[0][2],datas[0][3],datas[0][4]);

    long long swap_weapon_cri =
        get_battle_point
        (
        (datas[0][0] - datas[2][0] + datas[3][0]),
        (datas[0][1] - datas[2][1] + datas[3][1]),
        (datas[0][2] - datas[2][2] + datas[3][2]),
        (datas[0][3] - datas[2][3] + datas[3][3]),
        (datas[0][4] - datas[2][4] + datas[3][4])
        );

    long long weapon_paboo = get_battle_point(datas[1][0], datas[1][1], datas[1][2], datas[1][3],datas[1][4]);

    long long swap_weapon_paboo =
        get_battle_point
        (
            (datas[1][0] - datas[3][0] + datas[2][0]),
            (datas[1][1] - datas[3][1] + datas[2][1]),
            (datas[1][2] - datas[3][2] + datas[2][2]),
            (datas[1][3] - datas[3][3] + datas[2][3]),
            (datas[1][4] - datas[3][4] + datas[2][4])
        );

    // cout << weapon_cri << endl;
    // cout << swap_weapon_cri << endl;
    // cout << weapon_paboo << endl;
    // cout << swap_weapon_paboo << endl;

    if (weapon_cri == swap_weapon_cri)
    {
        cout << 0 << '\n';
    }
    else if (weapon_cri > swap_weapon_cri)
    {
        cout << '-' << '\n';
    }
    else
    {
        cout << '+' << '\n';
    }

    if (weapon_paboo == swap_weapon_paboo)
    {
        cout << 0 << '\n';
    }
    else if (weapon_paboo > swap_weapon_paboo)
    {
        cout << '-' << '\n';
    }
    else
    {
        cout << '+' << '\n';
    }
}