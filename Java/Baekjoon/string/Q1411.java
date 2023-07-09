package Baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @source: https://www.acmicpc.net/problem/1411 (비슷한 단어)
 * @classfication: string
 * @upsolving: true
 * @문제 푼 날짜 (자력으로 풂?): 23.07.09 (X, https://velog.io/@bobae1998/%EB%B0%B1%EC%A4%80-1411-%EB%B9%84%EC%8A%B7%ED%95%9C-%EB%8B%A8%EC%96%B4-JAVA)
 **/
public class Q1411 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int matching = 0;
        int N = Integer.parseInt(br.readLine());
        String[] strArr = new String[N];

        for(int i=0;i<N;i++) {
            strArr[i] = br.readLine();
        }

        br.close();

        for(int i=0;i<N;i++) {
            String target = strArr[i];

            L1: for(int j=i+1;j<N;j++) {
                HashMap<Character, Character> hashMap = new HashMap<>();
                String compare = strArr[j];

                for(int k=0;k<target.length();k++) {
                    char t = target.charAt(k);
                    char c = compare.charAt(k);

                    if( !hashMap.containsKey(t) ) {
                        Iterator<Character> keys = hashMap.keySet().iterator();
                        while(keys.hasNext()) {
                            char key = keys.next();
                            if(hashMap.get(key) == c) {
                                continue L1;
                            }
                        }
                    } else {
                        if(hashMap.get(t) != c) {
                            continue L1;
                        }
                    }

                    hashMap.put(t, c);
                }
               ++matching;
            }
        }

        System.out.print(matching);
    }
}
