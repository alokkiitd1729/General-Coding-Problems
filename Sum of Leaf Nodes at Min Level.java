

/**
 *     Date:- 2018-12-24
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/sum-of-leaf-nodes-at-min-level/1
 *    Problem Statement:-
 *                      
 * Given a Binary Tree of size N, your task is to complete the function minLeafSum(), that should return the sum 
    of all the leaf nodes that are at minimum level of the given binary tree.
 */
 
 //User function Template for Java

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

class GfG{
    int k=0;
    int minlevel(Node root){
        if(root==null){return Integer.MAX_VALUE;}
        if(root.left==null && root.right==null){return 1;}
        return Math.min(minlevel(root.left),minlevel(root.right))+1;
    }
    public int minLeafSum(Node root){
        if(root==null){return 0;}
        if(root.left==null && root.right==null){return root.data;}
      if(minlevel(root.left)<minlevel(root.right)){return minLeafSum(root.left);}
      else if(minlevel(root.left)>minlevel(root.right)){return minLeafSum(root.right);}
      else{return minLeafSum(root.left)+minLeafSum(root.right);}
    }
}
