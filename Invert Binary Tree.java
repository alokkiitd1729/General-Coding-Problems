/**
 *     Date:- 2018-12-24
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://leetcode.com/problems/invert-binary-tree/
 *    
 *             
 */
 
 
 
  * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
class Solution {
    void help(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        help(root.left);
        help(root.right);
    }
    public TreeNode invertTree(TreeNode root) {
        help(root);
        return root;
    }
}
