package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @source: https://leetcode.com/problems/subsets/description/ (78. Subsets)
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 24.08.18 (O)
 * @performace: Runtime: 0ms, Memory: 42.51
 * @reference: https://leetcode.com/problems/subsets/solutions/5525998/video-we-have-two-choices-for-each-number/
 **/
public class Q78 {
    static List<List<Integer>> answer;

    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();

        answer.add(new ArrayList<Integer>());
        bt(0, nums, new ArrayList<>());

        return answer;
    }

    private void bt(int depth, int[] nums, ArrayList<Integer> tmp) {
        for(int i=depth;i<nums.length;i++) {
            tmp.add(nums[i]);
            answer.add(new ArrayList<>(tmp));
            bt(i+1, nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
