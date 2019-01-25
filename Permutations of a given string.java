/**
 *     Date:- 2018-12-14
 *         Author:- @_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    Link for the problem:- https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0
 *    
 *             
 */
 
 
 import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static Map<String,Integer> helper(String s){
        Map<String,Integer>map=new TreeMap<>();
        if(s.length()==1){map.put(s,1);return map;}
        String sub=s.substring(1,s.length());
        char c=s.charAt(0);
        Map<String,Integer>temp_map=helper(sub);
        for(int i=0;i<=sub.length();i++){
            for(String z:temp_map.keySet()){
                if(i==0){String str4=Character.toString(c)+z;map.put(str4,1);}
                else{String str1=z.substring(0,i);
                String str2=z.substring(i,sub.length());
                String str3=str1+Character.toString(c)+str2;
                map.put(str3,1);}
            }
        }
        return map;
    }
    public static void helper2(String s2){
        Map<String,Integer>map2=helper(s2);
        for(String x:map2.keySet()){
            System.out.print(x+" ");
        }
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=Integer.parseInt(sc.nextLine());
		for(int q=0;q<v;q++){
		    String xxx=sc.nextLine();
		    helper2(xxx);
		    System.out.println();
		}
	}
}
