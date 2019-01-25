/**
 *     Date:- 2018-01-16
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/children-sum-parent/1
 *    
 *             
 */
 
 Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

class GfG
{
    static int help1(Node root){
        if(root==null){return 0;}
        else{return root.data;}
    }
    static boolean help(Node root){
        if(root==null || (root.left==null&&root.right==null)){return true;}
        boolean b=(help1(root)==help1(root.left)+help1(root.right));
        return b&&help(root.left)&&help(root.right);
        
    }
    public static int isSumProperty(Node node)
    {
         if(help(node)==true){
             return 1;
         }
         else {return 0;}
        
    }
}
