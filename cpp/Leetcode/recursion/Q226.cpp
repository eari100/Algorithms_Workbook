/**
 * @source: https://leetcode.com/problems/invert-binary-tree/description/ (226. Invert Binary Tree)
 * @classification: recursion
 * @문제 푼 날짜 (자력으로 풂?): 26.01.13 (O)
 **/
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        TreeNode* ivt = NULL;

        if(root == NULL)
        {
            return ivt;
        }

        ivt = new TreeNode();
        ivt->val=root->val;
        ivt->left=invertTree(root->right);
        ivt->right=invertTree(root->left);

        return ivt;
    }
};