package leetcode.implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * @source: https://leetcode.com/problems/binary-tree-right-side-view/ (199. Binary Tree Right Side View)
 * @classfication: implementation
 * @reference: https://leetcode.com/problems/binary-tree-right-side-view/discuss/56012/My-simple-accepted-solution(JAVA)
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.11 (X)
 **/
public class Q199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        findRightNode(list, root, 0);

        return list;
    }

    private void findRightNode(List<Integer> list, TreeNode root, int depth) {
        if(root == null) return;

        if(list.size() == depth)
            list.add(root.val);

        findRightNode(list, root.right, depth+1);
        findRightNode(list, root.left, depth+1);
    }
}
