

/**
 *     Date:- 2018-12-24
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/vertical-width-of-a-binary-tree/1
 *    Problem Statement:-
 *               Given a Binary Tree of N nodes. The task is to find the vertical width of the tree.
 */
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
// Function should return vertical width of the binary tree.
class GFG
{
    static void help(Node root,int h,Set<Integer> set){
        if(root==null){return;}
	    set.add(h);
	    help(root.left,h-1,set);help(root.right,h+1,set);
    }
    public static int verticalWidth(Node root)
	{
	    Set<Integer> set=new HashSet<>();
	   help(root,1,set);return set.size();
	}
}
