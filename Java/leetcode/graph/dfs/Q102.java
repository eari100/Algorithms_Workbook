package leetcode.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @source: https://leetcode.com/problems/binary-tree-level-order-traversal/ (102. Binary Tree Level Order Traversal)
 * @classfication: dfs
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.13 (O, Runtime: 1 ms, faster than 92.53%, Memory Usage: 43.9 MB, less than 24.94%)
 **/
public class Q102 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        recursive(list, root, 0);

        return list;
    }

    private void recursive(List<List<Integer>> list, TreeNode root, int depth) {
        if(root==null) return;

        if(list.size() == depth)
            list.add(new ArrayList<>());

        list.get(depth).add(root.val);

        recursive(list, root.left, depth+1);
        recursive(list, root.right, depth+1);
    }
}
