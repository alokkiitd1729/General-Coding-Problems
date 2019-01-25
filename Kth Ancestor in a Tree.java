/**
 *     Date:- 2018-12-24
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1
 *    
 *             
 */
 
 //User function Template for Java
Structure of Node class is:
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}


class Solution {
    class xnode{  // "xnode" is a class which holds parents for a particular node
        int x;Node parent;
        xnode(int n1,Node n2){x=n1;parent=n2;}
    }
    Map<Integer,xnode>map=new HashMap<>();
    void visit(Node root,Node par){  //this is putting "xnode" object in the Map for every node of tree 
        if(root==null){return;}
        map.put(root.data,new xnode(root.data,par));
        if(root.left!=null){visit(root.left,root);}
        if(root.right!=null){visit(root.right,root);}
    }
    public int kthAncestor(Node root, int k, int node){
        if(k==0){return -1;}
        visit(root,null); xnode anc=map.get(node);
        while(k>0 &&anc.parent!=null ){    //  so just find node in O(1) time from Map and and assign it's
         anc=map.get(anc.parent.data);k--; //parents to it self -> Repeat this k times we get kth ancestor
        }
        boolean b=anc.parent==null;
        if(k==0){return anc.x;}
        else{return -1;}
    }
}
