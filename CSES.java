import java.util.*;
import java.io.*;
public class CSES{
// taking inputs
static BufferedReader s1;
static BufferedWriter out;
static String read() throws IOException{String line="";while(line.length()==0){line=s1.readLine();continue;}return line;}
static int int_v (String s1){return Integer.parseInt(s1);}
static long long_v(String s1){return Long.parseLong(s1);}
static int[] int_arr() throws IOException{String[] a=read().split(" ");int[] b=new int[a.length];for(int i=0;i<a.length;i++){b[i]=int_v(a[i]);}return b;}
static long[] long_arr() throws IOException{String[] a=read().split(" ");long[] b=new long[a.length];for(int i=0;i<a.length;i++){b[i]=long_v(a[i]);}return b;}
static void sort(int[] a){List<Integer> l=new ArrayList<>();for(int z:a){l.add(z);}Collections.sort(l);for(int i=0;i<a.length;i++){a[i]=l.get(i);}}
//static void sorthd(int[][] a){List<int[]> l=new ArrayList<>();for(int[] x:a){l.add(x);}Collections.sort(l,(a1,b1)->f(a1,b1));for(int i=0;i<a.length;i++){a[i]=l.get(i);}}
static void assign(){s1=new BufferedReader(new InputStreamReader(System.in));out=new BufferedWriter(new OutputStreamWriter(System.out));}
static long Modpow(long a,long p,long m){long res=1;while(p>0){if((p&1)!=0){res=(res*a)%m;}p >>=1;a=(a*a)%m;}return res;}
static long Modmul(long a,long b,long m){return ((a%m)*(b%m))%m;}
static long ModInv(long a,long m){return Modpow(a,m-2,m);}
static long mod=(long)1e9+7;
//......................................@uthor_Alx..............................................
static void update(int x, int delta,int[] BIT){
       while(x<BIT.length){
            BIT[x] += delta;
           x+=x&-x;
       }
}
static int query(int x,int[] BIT){
    int sum = 0;
        while(x>0){
            sum += BIT[x];
            x-=x&-x;
        }
     return sum;
} 
static int find(int[] BIT, int k, int max){
	int l=1,r=max;
	while(l<r){
		int m=(l+r)/2;
		int f=query(m,BIT);
		if(f>k){
			r=m-1;
		}
		else if(f<k){
			l=m+1;
		}
		else{
			r=m;
		}
	}
	return l;
}
 
public static void main(String[] args) throws  IOException{
	        		    assign();
	        		  	int[] n1=int_arr();
	        		  	int n=n1[0],k=n1[1];
	        		  	int[] arr=int_arr();
	        		  	int[] c=arr.clone();
	        		  	sort(c);
	        		  	int j=1,k1=k;k=k/2+k%2;
	        		  	Map<Integer,List<Integer>> map=new HashMap<>();
	        		  	Map<Integer,Integer> ctr=new HashMap<>();
	        		  	int[] map1=new int[n+2];
	        		  	for(int x:c){
	        		  		map1[j]=x;
	        		  		ctr.put(x,0);
	        		  		map.computeIfAbsent(x,key ->new ArrayList<>()).add(j);
	        		  		j++;
	        		  	}
	        		  	int[] BIT=new int[n+2];
	        		  	for(int i=0;i<n;i++){
	        		  		int xx=ctr.get(arr[i]),mapped=map.get(arr[i]).get(xx);
	        		  		ctr.put(arr[i],xx+1);
	        		  		arr[i]=mapped;
	        		  	}
	        		  	for(int i=1;i<=k1;i++){
	        		  		update(arr[i-1],1,BIT);
	        		  	}
	        		  	out.write(map1[find(BIT,k,n)]+" ");j=0;
	        		  	for(int i=k1;i<n;i++){
	        		  		update(arr[i],1,BIT);
	        		  		update(arr[j],-1,BIT);
	        		  		out.write(map1[find(BIT,k,n)]+" ");j++;
	        		  	}
                        out.flush();
	}
}