package leetcode.string;

/**
 * @source: https://leetcode.com/problems/valid-palindrome/
 * @classfication: string
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.05.27 (O)
 **/
public class Q125 {
    public static void main(String[] args) {
        Q125 q125 = new Q125();
        boolean b1 = q125.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(b1);

        boolean b2 = q125.isPalindrome("race a car");
        System.out.println(b2);

        boolean b3 = q125.isPalindrome(" ");
        System.out.println(b3);

        boolean b4 = q125.isPalindrome("0P");
        System.out.println(b4);
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }

        String origin = sb.toString();
        return origin.equals(sb.reverse().toString());
    }
}
