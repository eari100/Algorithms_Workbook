package Baekjoon.dp.Q1676;

import java.io.*;
import java.math.BigInteger;

public class UsingBigInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        BigInteger val = new BigInteger("1");
        for(int i=1;i<=N;i++)
            val = val.multiply(BigInteger.valueOf(i));

        int result = 0;
        String x = val.toString();
        for(int i=x.length()-1;i>=0;i--) {
            if(x.charAt(i) == '0') ++result;
            else break;
        }

        System.out.print(result);
    }
}
