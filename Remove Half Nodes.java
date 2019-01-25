/**
 *     Date:- 2018-12-21
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/remove-half-nodes/1
 *    
 *             
 */
 
 Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

class GfG
{
   
    public Node removeHalfNodes(Node root)
    {
        if(root==null){return null;}
        root.left=removeHalfNodes(root.left);
        root.right=removeHalfNodes(root.right);
        if(root.left==null&&root.right!=null){return root.right;}
        else  if(root.left!=null&&root.right==null){return root.left;}
        else{return root;}
    }
}






