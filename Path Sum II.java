/**
 *     Date:- 2018-12-24
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://leetcode.com/problems/path-sum-ii/
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
    List<List<Integer>> l=new ArrayList<>();
    void help(TreeNode root,List<Integer> path,int sum){
        if(root==null){return;}
        path.add(root.val);
        List<Integer>path1=new ArrayList<>(path);
        if(root.left==null&&root.right==null&&root.val==sum){
            l.add(path);
        }
        help(root.left,path,sum-root.val);
         help(root.right,path1,sum-root.val);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer>k=new ArrayList<>();
        help(root,k,sum);
        return l;
    }
}
