/**
 *     Date:- 2018-12-24
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://leetcode.com/problems/path-sum/
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
    public boolean hasPathSum(TreeNode root, int sum) {
         if(root==null){return false;}
        else if(root!=null&&root.left==null&&root.right==null&&root.val==sum){return true;}
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}
