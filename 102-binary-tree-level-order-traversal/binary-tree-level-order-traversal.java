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
    List<List<Integer>> ans;   //Global Variable

    public List<List<Integer>> levelOrder(TreeNode root) {
        ans = new ArrayList<>();

        DFS(root, 0);
        return ans;
    }

    public void DFS(TreeNode root, int a){
        if(root == null) return;    //root is null return the root value

        if(ans.size() == a){
            ans.add(new ArrayList<>()); //adding new root element
        }
        ans.get(a).add(root.val);   //adding list in the list
        DFS(root.left, a+1);    //recursive calling
        DFS(root.right, a+1);
        
    }
}