/**
 *     Date:- 2018-12-21
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/nodes-at-odd-levels/1
 *    
 *             
 */
 
 Node is as follows
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
class GfG{
    class fuck{
        Node x;int level;
        fuck(Node n,int c){x=n;level=c;}
    }
    public void nodeAtOdd(Node root)
     {
         if(root==null){return;}
       Queue<fuck>q=new LinkedList<>();
       fuck f=new fuck(root,1); q.add(f);
       while(!q.isEmpty()){
           fuck xx=q.poll();
           if(xx.level%2==1){System.out.print(xx.x.data+" ");}
           if(xx.x.left!=null){q.add(new fuck(xx.x.left,xx.level+1));}
           if(xx.x.right!=null){q.add(new fuck(xx.x.right,xx.level+1));}
       }
     }
}

