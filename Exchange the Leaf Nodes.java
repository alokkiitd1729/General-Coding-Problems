/**
 *     Date:- 2018-12-24
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/exchange-the-leaf-nodes/1
 *    
 *             
 */
 
 
 //User function Template for Java

The structure of node class is as follows:
class Node {
    int data;
    Node left, right;
    

   public Node(int data){
        this.data = data;
    }
}


class Solution {
    Node temp1=null;int xx=0;
    public void exchangeLeaves(Node root){
          if(root==null){return;}
        if(root.left==null && root.right==null){
            if(xx==0){temp1=root;xx++;}
            else{
                int k=temp1.data; temp1.data=root.data;root.data=k;
                xx=0;
            }
        }
       exchangeLeaves(root.left);
       exchangeLeaves(root.right);
    }
}








