/**
 *     Date:- 2018-12-24
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/maximum-node-level/1
 *    
 *             
 */
 
 
 Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int item)
	{
	    data = item;
	    left = right = null;
	}
}

class GfG
{
    static int arr[]=new int[20];
    static void help(Node root,int level){
        if(root==null){return;}
        else{arr[level]+=1;}
        help(root.left,level+1);help(root.right,level+1);
        
    }
    public static int maxNodeLevel(Node node)
    {
        int k=-1;int level=0;
        Arrays.fill(arr,0);
        help(node,0);
        for(int i=0;i<20;i++){
            if(arr[i]>k){k=arr[i];level=i;}
        }
        return level;
    }
}
