package Baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @source: https://www.acmicpc.net/problem/2596 (비밀편지)
 * @classfication: implementation, string
 * @문제 푼 날짜 (자력으로 풂?): 23.09.17 (O)
 **/
public class Q2596 {
    final static String A = "000000";
    final static String B = "001111";
    final static String C = "010011";
    final static String D = "011100";
    final static String E = "100110";
    final static String F = "101001";
    final static String G = "110101";
    final static String H = "111010";
    final static String[] binaryArray = {A, B, C, D, E, F,  G, H};
    final static int letterLen = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Character> hashMap = new HashMap<>();

        for(int i=0;i<binaryArray.length;i++) {
            hashMap.put( binaryArray[i], (char)('A'+i));
        }

        int letterCount = Integer.parseInt(br.readLine());
        String letters = br.readLine();
        br.close();

        StringBuilder result = new StringBuilder();

        for(int i=0;i<letterCount;i++) {
            int str = i * letterLen;
            int end = str + letterLen;

            String subStr = letters.substring(str, end);

            if(hashMap.get(subStr) != null) {
                result.append(hashMap.get(subStr));
            } else {
                boolean isMatch = false;

                for ( String key : hashMap.keySet() ) {
                    int diffCount = 0;

                    for(int j=0;j<letterLen;j++) {
                        if(subStr.charAt(j) != key.charAt(j)) {
                            ++diffCount;

                            if(diffCount == 2) {
                                break;
                            }
                        }
                    }

                    if(diffCount == 1) {
                        isMatch = true;
                        result.append(hashMap.get(key));
                        break;
                    }
                }

                if( !isMatch ) {
                    result = new StringBuilder(String.valueOf(i+1));
                    break;
                }
            }
        }

        System.out.print(result);
    }
}
