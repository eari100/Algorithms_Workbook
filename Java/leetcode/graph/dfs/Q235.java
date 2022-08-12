package leetcode.graph.dfs;

/**
 * @source: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/ (235. Lowest Common Ancestor of a Binary Search Tree)
 * @classfication: dfs, binary search tree, LCA
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.08.12 (X)
 **/
public class Q235 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
}
