/**
 *     Date:- 2018-12-20
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/sum-of-left-leaf-nodes/1
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

class GfG{
    int result;
    public int leftLeafSum(Node node)
    {
      if(node==null||(node.left==null&&node.right==null)){return 0;}
      if(node.left!=null && node.left.left==null && node.left.right==null){result+=node.left.data;}
      leftLeafSum(node.left);leftLeafSum(node.right);
      return result;
    }
}
