package Atcoder.AtCoder_Beginner_Contest_314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @source: https://atcoder.jp/contests/abc314/tasks/abc314_b (B - Roulette)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.26 (O)
 **/
// ArrayList contain(), clear() 메서드로 대체 가능한 부분 있음
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        ArrayList<int[]> betList = new ArrayList<>();

        for(int i=0;i<K;i++) {
            int len = Integer.parseInt(br.readLine());
            int[] nums = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            betList.add(nums);
        }

        int X = Integer.parseInt(br.readLine());
        br.close();

        ArrayList<int[]> correctPersons = new ArrayList<>();
        correctPersons.add(new int[]{0, 38});

        for(int i=0;i<betList.size();i++) {
            int[] bet = betList.get(i);
            for(int num : bet) {
                if(X == num) {
                    int lowLen = correctPersons.get(0)[1];

                    if(lowLen == bet.length) {
                        correctPersons.add(new int[]{i+1, bet.length});
                    } else if(lowLen > bet.length) {
                        correctPersons = new ArrayList<>();
                        correctPersons.add(new int[]{i+1, bet.length});
                    }
                    break;
                }
            }
        }

        StringBuilder result = new StringBuilder();

        if(correctPersons.get(0)[0] == 0) {
            result.append(0);
        } else {
            result.append(correctPersons.size()).append('\n');

            for(int i=0;i<correctPersons.size();i++) {
                result.append(correctPersons.get(i)[0]).append(' ');
            }
        }

        System.out.print(result);
    }
}
