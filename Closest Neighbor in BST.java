/**
 *     Date:- 2018-12-24
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/closest-neighbor-in-bst/1
 *    
 *             
 */
 
 //User function Template for Java

class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
    
}

class GfG
{
    int k=0;
    int j=-1;
     int findMaxforKey(Node node, int val, int size)
    {
        if(node==null){return j;}
        if(node.data>k && node.data<=val){k=node.data;}
    if(val>node.data){findMaxforKey(node.right,val,size);}
    else{findMaxforKey(node.left,val,size);}
    if(k!=0){return k;}else{return j;}
    }
}
