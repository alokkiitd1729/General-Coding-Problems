/**
 *     Date:- 2018-12-24
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *    
 *             
 */
 
 
 
  * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
class Solution {
     List<List<Integer>> l=new ArrayList<>();
    void help(TreeNode root,int level){
        if(root==null){return;}
        if(level<=l.size()){
            l.get(level-1).add(root.val);
        }
        else{
             List<Integer> temp=new ArrayList<>();
            temp.add(root.val);
            l.add(temp);
        }
        help(root.left,level+1);
        help(root.right,level+1);
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        help(root,1);
        Collections.reverse(l);
        return l;
    }
}
