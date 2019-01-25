

/**
 *     Date:- 2018-12-06
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/tilt-of-binary-tree/1
 *    Problem Statement:-
 *               Given a binary tree of size N+1, your task is to complete the function tiltTree(), that 
                 return the tilt of the whole tree. The tilt of a tree node is defined as the absolute 
                 difference between the sum of all left subtree node values and the sum of all right subtree node values.
 */
 
 
 //User function Template for Java

Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

class GfG{
    int sum(Node root){
        if(root==null){return 0;}
        return sum(root.left)+sum(root.right)+root.data;
    }
     int tilt(Node root){
         if(root==null){return 0;}
        return tilt(root.right)+tilt(root.left)+(Math.abs(sum(root.left)-sum(root.right)));
    }
}
