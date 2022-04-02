package Baekjoon.sort;

import java.util.*;

/**
 *@source: https://www.acmicpc.net/problem/1181
 *@classfication: 문자열, 정렬
**/
public class Q1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> sWords = new HashSet<>();
        int num = sc.nextInt();

        for(int i=0;i<num;i++)
            sWords.add(sc.next());

        List<String> lWords = new ArrayList<>(sWords);

        Collections.sort(lWords, (o1, o2) -> {
            if (o1.length() == o2.length())
                return o1.compareTo(o2);
            else
                return o1.length() - o2.length(); // 길이 오름차순
        });

        for(String word : lWords)
            System.out.println(word);

        sc.close();
    }
}
