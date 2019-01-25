/**
 *     Date:- 2018-12-24
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1
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
	public boolean isIsomorphic(Node root1,Node root2)
       {
           if(root1==null && root2==null){return true;}
           else if((root1!=null&&root2==null)||(root1==null&&root2!=null)){return false;}
         boolean b1= isIsomorphic(root1.left,root2.left)||isIsomorphic(root1.left,root2.right);
         boolean b2= isIsomorphic(root1.right,root2.right)||isIsomorphic(root1.right,root2.left);
         boolean b3=root1.data==root2.data;
         return b1&&b2&&b3;
	}
}




