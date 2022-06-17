package leetcode.graph.dfs;

/**
 * @source: https://leetcode.com/problems/binary-tree-cameras/
 * @classfication: Greedy + DFS
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.17 (X)
 **/
public class Q968 {
    int res = 0;

    public int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + res;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 2;
        int left = dfs(root.left), right = dfs(root.right);
        if(left == 0 || right == 0) {
            res++;
            return 1;
        }

        return left == 1 || right == 1 ? 2 : 0;
    }

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
}
