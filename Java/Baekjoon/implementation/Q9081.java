package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *@source: https://www.acmicpc.net/problem/9081 (단어 맞추기)
 *@classfication: implementation
 **/
public class Q9081 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=Integer.parseInt(br.readLine());i>0;i--) {
            String str = br.readLine();
            String cvStr = str;

            for(int j=str.length()-2;j>=0;j--) {
                List<Character> charList = new ArrayList<>();

                for(int k=j;k<str.length();k++) {
                    charList.add(str.charAt(k));
                }

                Collections.sort(charList, Collections.reverseOrder());

                if(str.charAt(j) == charList.get(0)) continue;
                else {
                    Character next = null;
                    
                    for(int l=0;l<charList.size();l++) {
                        if(str.charAt(j)==charList.get(l)) {
                            next = charList.get(l-1);
                            charList.remove(l-1);
                            break;
                        }
                    }

                    Collections.sort(charList);
                    cvStr = str.substring(0, j);
                    cvStr += next;
                    for(Character c : charList) {
                        cvStr += c;
                    }
                    break;
                }
            }
            System.out.println(cvStr);
        }

        br.close();
    }
}
