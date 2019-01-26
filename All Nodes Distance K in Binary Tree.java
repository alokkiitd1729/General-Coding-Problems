/**
 *     Date:- 2018-12-24
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
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
    Map<Integer,TreeNode> map=new HashMap<>();int temp=0;
    Set<Integer>visited=new HashSet<>();
    List<Integer>l=new ArrayList<>();
    void help(TreeNode root,TreeNode baap){
        if(root==null){return;}
        map.put(root.val,baap);
        help(root.left,root);
        help(root.right,root);
    }
    void help1(TreeNode target, int k){
        if(target==null){return;}
        if(visited.contains(target.val)){return;}
        visited.add(target.val);
         if(k==0){
            l.add(target.val);
            return ;
        }
        help1(target.left,k-1);
        help1(target.right,k-1);
        help1(map.get(target.val),k-1);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        help(root,null);temp=target.val;
        help1(target,K);
        return l;
    }
}
