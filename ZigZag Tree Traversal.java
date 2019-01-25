

/**
 *     Date:- 2018-12-24
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1
 *    
 *             
 */

//User function Template for Java

class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}

// Print the zig zag traversal of tree.
class GFG
{
   Stack<Node>s1=new Stack<>();
   Stack<Node>s2=new Stack<>();
	void zigZagTraversal(Node node)
	{
	    if(node==null){return;}
	 s1.add(node);  
	 while(!s1.empty()||!s2.empty()){
	     while(!s1.empty()){
	         Node temp=s1.pop();
	         System.out.print(temp.data+" ");
	         if(temp.left!=null){s2.add(temp.left);}
	         if(temp.right!=null){s2.add(temp.right);}
	     }
	     while(!s2.empty()){
	         Node temp1=s2.pop();
	         System.out.print(temp1.data+" ");
	         if(temp1.right!=null){s1.add(temp1.right);}
	         if(temp1.left!=null){s1.add(temp1.left);}
	     }
	 }
	}
}
