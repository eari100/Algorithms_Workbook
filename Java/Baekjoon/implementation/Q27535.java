package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/27535 (제주 초콜릿 지키기)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.07.14 (O)
 **/
public class Q27535 {
    static final char[] chocoType = {'H', 'T', 'C', 'K', 'G'};

    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Choco[] chocoArr = new Choco[5];
        int prevSum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<chocoType.length;i++) {
            int cnt = Integer.parseInt(st.nextToken());
            chocoArr[i] = new Choco(chocoType[i], cnt);
            prevSum += cnt;
        }

        int m = Integer.parseInt(br.readLine());

        int currSum = prevSum;

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<5;j++) {
                int eatCnt = Integer.parseInt(st.nextToken());
                chocoArr[j].eat(eatCnt);
                currSum -= eatCnt;
            }

            int formation = getFormation(prevSum);
            result.append(changeToFormation(formation, currSum)).append("7H").append('\n');

            Choco[] copyOfChocoArr = copyOf(chocoArr);

            if(currSum == 0) {
                result.append("NULL").append('\n');
            } else {
                Arrays.sort(copyOfChocoArr, (c1, c2) -> {
                    if(c1.count == c2.count) {
                        return c1.type - c2.type;
                    } else {
                        return c2.count - c1.count;
                    }
                });

                for(Choco choco : copyOfChocoArr) {
                    if(choco.count == 0) {
                        break;
                    }

                    result.append(choco.type);
                }

                result.append('\n');
            }

            prevSum = currSum;
        }

        br.close();

        System.out.print(result);
    }

    private static int getFormation(int prevSum) {
        return prevSum % 10;
    }

    private static String changeToFormation(int formation, int currSum) {
        if (formation == 0 || formation == 1) {
            return String.valueOf(currSum);
        } else {
            return Integer.toString(currSum, formation);
        }
    }

    private static Choco[] copyOf(Choco[] chocoArr) {
        Choco[] copyOfChocoArr = new Choco[chocoArr.length];
        for (int i = 0; i < chocoArr.length; i++) {
            copyOfChocoArr[i] = chocoArr[i];
        }
        return copyOfChocoArr;
    }

    public static class Choco {
        public char type;
        public int count;

        public Choco(char type, int count) {
            this.type = type;
            this.count = count;
        }

        public void eat(int eatCnt) {
            this.count -= eatCnt;
        }
    }
}
