/**
 *     Date:- 2018-12-24
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/diagonal-sum-in-binary-tree/1
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
    Map<Integer,Integer>map=new HashMap<>();
    void visit(Node root,int distance){
        if(root==null){ return;}
        if(map.containsKey(distance)){
            map.put(distance,map.get(distance)+root.data);
        }
        else{map.put(distance,root.data);}
        visit(root.left,distance+1);visit(root.right,distance);
    }
    public void diagonalsum(Node root)
     {
      visit(root,0);
      for(int i=0;i<map.size();i++){
          System.out.print(map.get(i)+" ");
      }
     }
}
