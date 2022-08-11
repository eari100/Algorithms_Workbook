package leetcode.graph.dfs;

/**
 * @source: https://leetcode.com/problems/validate-binary-search-tree/ (98. Validate Binary Search Tree)
 * @classfication: dfs, Binary Search Tree
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.08.12 (X)
 **/
public class Q98 {
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

    public boolean isValidBST(TreeNode root) {

        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root,long minval,long maxval){
        if(root == null) return true;
        if(root.val >= maxval || root.val <= minval) return false;

        return isValidBST(root.left,minval,root.val) && isValidBST(root.right,root.val,maxval);
    }
}
