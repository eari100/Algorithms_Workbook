package ProjectEuler;

/**
 *@source: https://projecteuler.net/problem=1
 *@classfication: arithmetic series
 **/
public class Q1 {
    public static void main(String[] args) {
        final int limit = 1000;
        int three = arithmeticSeries(3, limit);
        int five = arithmeticSeries(5, limit);
        int fifteen = arithmeticSeries(15, limit);

        System.out.println(three+five-fifteen);
    }

    private static int arithmeticSeries(int num, int limit) {
        limit -= 1;
        int n = limit/num;
        return n*(n+1)*num/2;
    }
}
