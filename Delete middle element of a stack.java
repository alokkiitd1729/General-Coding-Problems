

/**
 *     Date:-2018-12-07
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1
 *    Problem Statement:-
 *               Given a stack with push(), pop(), empty() operations, delete middle of it without using any additional data structure.
 */
 
 //User function Template for Java
class GfG{
    public Stack<Integer> deleteMid(Stack<Integer> s,int n,int current){
        Stack<Integer> s1=new Stack<>();
        int k=0;
        while(!s.empty()){
            int temp=s.pop();k++;
            if(k!=n/2+1){s1.push(temp);}
        }
        while(!s1.empty()){s.push(s1.pop());}
        return s;
    }
}
