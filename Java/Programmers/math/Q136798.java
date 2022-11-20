package Programmers.math;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/136798
 * @classfication: math
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.11.20 (X)
 **/
public class Q136798 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            int wp = getDivisorNumber(i);
            answer += wp > limit ? power : wp;
        }
        return answer;
    }

    public static int getDivisorNumber(int n){
        int number =0;

        if(Math.sqrt(n)%1==0) number++;

        for(int i=1;i<Math.sqrt(n);i++)
            if(n%i==0) number+=2;

        return number;
    }
}
