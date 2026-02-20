/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // we need to check if the left and right subtree matches along with the root node
        // conditions 
        // both null
        if(p == null && q == null){
            return true;
        }
        // one of them is null
        if(p == null || q == null){
            return false;
        }
        // comparing the data
        if(p.val != q.val){
            return false;
        }
        
        return isSameTree(p.left , q.left) && isSameTree(p.right , q.right);
    }
}