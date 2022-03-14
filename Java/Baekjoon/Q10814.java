package Baekjoon;

import java.io.*;
import java.util.*;

/**
 *@source: https://www.acmicpc.net/problem/10814
 *@classfication: sort
 **/
public class Q10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Member> members = new ArrayList<>();

        for (int i = Integer.parseInt(br.readLine());i > 0;i--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int order = i;

            members.add(new Member(age, name, order));
        }

        Collections.sort(members, (m1, m2) -> {
            if(m1.getAge() == m2.getAge())
                return m2.getOrder() - m1.getOrder(); // 내림차순
            else
                return m1.getAge() - m2.getAge(); // 오름차순
        });
        br.close();

        members.forEach(m -> System.out.println(m.getAge()+" "+m.getName()));
    }

    static class Member {
        private int age;
        private String name;
        private int order;

        Member(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public int getOrder() {
            return order;
        }
    }
}
