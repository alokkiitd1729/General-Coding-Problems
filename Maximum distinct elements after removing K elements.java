/**
 *     Date:- 2019-01-18
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/maximum-distinct-elements-after-removing-k-elements/0
 *    
 *             
 */
 
 
 
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	     Scanner s=new Scanner(System.in);
	     int test=s.nextInt();
	     for(int i=0;i<test;i++){
	         int length=s.nextInt();int k=0;
	     int remove=s.nextInt();
	     Set<Integer> set=new HashSet<>(); 
	     while(k<length){
	         int temp=s.nextInt();
	         set.add(temp);
	         k++;
	     }
	     if(length-remove>set.size()){
	         System.out.println(set.size());
	     }
	     else{System.out.println(length-remove);}
	     }
	}
}
