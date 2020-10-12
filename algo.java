import java.util.*;
import java.io.*;
import java.math.BigInteger; 

 public class algo{
/// functions
  static BufferedReader s1;
static BufferedWriter out;
static String read() throws IOException{String line="";while(line.length()==0){line=s1.readLine();continue;}return line;}
static int int_v (String s1){return Integer.parseInt(s1);}
static long long_v(String s1){return Long.parseLong(s1);}
static int[] int_arr() throws IOException{String[] a=read().split(" ");int[] b=new int[a.length];for(int i=0;i<a.length;i++){b[i]=int_v(a[i]);}return b;}
static long[] long_arr() throws IOException{String[] a=read().split(" ");long[] b=new long[a.length];for(int i=0;i<a.length;i++){b[i]=long_v(a[i]);}return b;}
static void assign(){s1=new BufferedReader(new InputStreamReader(System.in));out=new BufferedWriter(new OutputStreamWriter(System.out));}

static long gcd(long a,long b){if(b==0){return a;}return gcd(b,a%b);}
static long Modpow(long a,long p,long m){long res=1;while(p>0){if((p&1)!=0){res=(res*a)%m;}p >>=1;a=(a*a)%m;}return res;}
static long Modmul(long a,long b,long m){return ((a%m)*(b%m))%m;}
static long ModInv(long a,long m){return Modpow(a,m-2,m);}
static long nck(int n,int r,long m){if(r>n){return 0l;}return Modmul(f[n],ModInv(Modmul(f[n-r],f[r],m),m),m);}
static long[] f;

static String setpreciosion(double d,int k){BigDecimal d1 = new BigDecimal(Double.toString(d));return d1.setScale(k,RoundingMode.UP).toString();//UP DOWN,  .doubleValue()} 
// rec Inv
long[] inv=new long[1000001];Arrays.fill(inv,1l);
 for(int i = 2; i < 1e6+1; i++){
      inv[i] =((mod-mod/i)*inv[mod%i])%mod;
  }
// KMP/Z function String processing
//  KMP to Z — for i=1;i<n      Z[i−P[i]+1]=max(Z[i−P[i]+1],P[i])
//  Z to KMP — for i=1;i<n      P[i+Z[i]−1]=max(P[i+Z[i]−1],z[i])
static int kmp(String s2){
        int n=s2.length();
        int[] p=new int[n];
        for(int i=1;i<n;i++){
            int j=p[i-1];
            char c1=s2.charAt(j),c2=s2.charAt(i);
            while(j>0&&c1!=c2){
                j=p[j-1];c1=s2.charAt(j);
            }
            if(c1==c2) j++;
            p[i]=j;
        }
        return p[n];
  }
///////////////////////////////////
static void babystep(int g, int h, int p) throws  IOException{
    out.write("step1..........\n");
    int m=(int)Math.ceil((double)Math.sqrt(p));
    Map<Long,Integer> ss=new HashMap<>();
    for(int i=0;i<m;i++){
        long kk=Modmul(ModInv(Modpow((long)g,(long)i,p),p),(long)h,p);
        ss.put(kk,i);
        out.write("("+kk+","+i+") ");
    }
    if(ss.get(1l)!=null){
        out.write("\ncontains identity\n");
        out.write("answer   "+ss.get(1l)+"  ");
        if(h==Modpow((long)g,(long)ss.get(1l),p)) out.write("  -  Verifed!");
        return;
    }
    out.write("\nstep2......... m q\n");
    for(int q=1;q<=100;q++){
        long kk=Modpow(g,(long)q*m,p);
        out.write("g^("+q+"m) - "+kk+"\n");
        if(ss.get(kk)!=null){
            out.write("answer   "+m+"*"+q+"+"+ss.get(kk)+" = "+(m*q+ss.get(kk))+"   ");
            if(h==Modpow((long)g,(long)(m*q+ss.get(kk)),p)) out.write("  -  Verifed!");
             return;
        }
    }
}
// SegmentTree  :)
static class SegTree{
  //left=v+1,right=v+2*(mid-l+1)
  int[][] t; int n;
  SegTree(int n,int[] a){
    t=new int[4*n][2];
    this.n=n;
    build(a,1,0,n-1);
  }
  int[] merge(int[] a, int[] b){
    if(a[0]>b[0]) return  b;
    if(b[0]>a[0]) return a;
    return new int[]{a[0],a[1]+b[1]};
  }
  void build(int[] a,int v,int l,int r){
    if(l==r){t[v][0]=a[l];t[v][1]=1;return;}
    int m=(l+r)/2;
    build(a,2*v,l,m); build(a,2*v+1,m+1,r);
    t[v]=merge(t[2*v],t[2*v+1]);
  }
  void upd(int i,int v){upd(1,0,n-1,i,v);}
  int[] qry(int l,int r){return qry(1,0,n-1,l,r);}
  void upd(int v,int tl,int tr,int pos,int x){
    if(tl==tr){t[v][0]=x;t[v][1]=1;return;}
    int m=(tl+tr)/2;
    if(pos<=m)
      upd(2*v,tl,m,pos,x);
    else
      upd(2*v+1,m+1,tr,pos,x);
    t[v]=merge(t[2*v],t[2*v+1]);
  }
  int[] qry(int v,int tl,int tr,int l,int r){
    if(l>r) return new int[]{(int)2e9,0};;
    if(tl==l&&tr==r) return t[v];
    int m=(tl+tr)/2;
    return merge(qry(2*v,tl,m,l,Math.min(r,m))
           ,qry(2*v+1,m+1,tr,Math.max(l,m+1),r));
  }

}

// Segment Tree Lazy Propagation
static class SegTreeLP{
  int[] t;int n;
  boolean[] marked;
  SegTreeLP(int n, int[] a){
    t=new int[2*n];
    marked=new boolean[2*n];
    this.n=n;
    build(1,0,n-1,a);
  }
  void build(int v,int tl,int tr,int[] a){
    if(tr==tl){
      t[v]=a[tr];
      marked[v]=true;
      return;
    }
    int m=(tr+tl)>>1;
    build(v+1,tl,m,a); build(v+2*(m-tl+1),m+1,tr,a);
  }
  void push(int v,int tl,int tr,int m){
    if(!marked[v]) return;
    t[1+v]=t[v+2*(m-tl+1)]=t[v];
    marked[v+1]=marked[v+2*(m-tl+1)]=true;
    marked[v]=false;
  }
  void upd(int v,int tl,int tr,int l,int r,int new_v){
    if(l>r) return;
    if(tr==r&&tl==l){
      t[v]=new_v;
      marked[v]=true;
      return;
    }
    int m=(tr+tl)>>1;
    push(v,tl,tr,m);
    upd(v+1,tl,m,l,Math.min(r,m),new_v);
    upd(v+2*(m-tl+1),m+1,tr,Math.max(l,m+1),r,new_v);
  }
  int qry(int v,int tl,int tr,int pos){
    if(marked[v]) return  t[v];
    int m=(tr+tl)>>1;
    if(pos<=m)
      return qry(v+1,tl,m,pos);
    else
      return qry(v+2*(m-tl+1),m+1,tr,pos);
  }
}

//####################################### Trie
class Trie{
     Trie[] curr;
     boolean b;
     Trie() {
        curr=new Trie[26];
        b=false;
    }
}
  Trie root=new Trie();
    /** Inserts a word into the trie. */
    public void add(String w) {
        Trie root1=root;
        for(int i=0;i<w.length();i++){
            int j=w.charAt(i)-'a';
            if(root1.curr[j]==null) root1.curr[j]=new Trie();
            root1=root1.curr[j];
        }
        root1.b=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String w) {
        Trie root1=root;
        for(int i=0;i<w.length();i++){
            int j=w.charAt(i)-'a';
            if(root1.curr[j]==null) return false;
            root1=root1.curr[j];
        }
        return root1.b;
    }


//################################### Binary Search
static void binarySearch(){
    while(start<=end){   // C2 - Vs    while (start<end)
        int mid=(start+end)/2;
        if(condition1){
          end=mid-1;        //      end=mid;
        }
        else{
          start=mid+1;
        }
    }
    return start;     // Note:- for case 1 we can't return end
}

// Traveling salesman problem/ Hamiltonian path O(n^2*2^n)
static boolean Hamiltonian_Path(boolean[][] adj, int n){
  boolean[][] dp=new boolean[n][1<<n];
  for(int i=0;i<n;i++){
    dp[i][1<<i]=true;
  }

  for(int mask=0;mask<1<<n;mask++){
    for(int i=0;i<n;i++){
      if((mask&1<<i)!=0){
        for(int j=0;j<n;j++){
          if(j!=i&&(mask&1<<j)!=0&&adj[j][i]){
            if(dp[j][mask^(1<<i)]){
              dp[i][mask]=true;
            }
          }
        }
      }
    }
  }

  for(int i=0;i<n;i++){
    if(dp[i][(1<<n)-1]){
      return true;
    }
  }
  return false;
}

//  Ford-Fulkerson Edmond-Krap
static int bfs(int[][] g, int[] parent,int n, int m){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,100000000});
        boolean[] b=new boolean[n+m+2];
        b[0]=true;
        while(!q.isEmpty()){
            int[] x=q.poll();
            int curr=x[0],flow=x[1];
            for(int i=1;i<=n+m+1;i++){
                if(g[curr][i]==0||b[i]) continue;
                parent[i]=curr;
                if(i==n+m+1){
                    return Math.min(flow,g[curr][i]);
                }
                b[i]=true;
                q.add(new int[]{i,Math.min(flow,g[curr][i])});
            }
        }
        return 0;
 }
  static int max_flow(int[][] g, int n, int m){
        int max_flow=0;
        int[] parent=new int[n+m+2];
        int curr_flow=0;
        while((curr_flow=bfs(g,parent,n,m))>0){
            max_flow+=curr_flow;
            int curr=n+m+1;
            while(curr!=0){
                int pre=parent[curr];
                g[curr][pre]+=curr_flow;
                g[pre][curr]-=curr_flow;
                curr=pre;
            }
        }
        return max_flow;
  }
//.....................
// Compute factors of all number from 1 to N
static void spf(int n, int[] spf){
        for(int i=2;i<=(int)Math.sqrt(n);i++){
          if(spf[i]!=0) continue;
          spf[i]=i;
          for(int j=i*i;j<=n;j+=i){
            if(spf[j]!=0) continue;
            spf[j]=i;
          }
        }
        for(int i=(int)Math.sqrt(n);i<=n;i++){
          if(spf[i]==0) spf[i]=i;
        }
    }
//

//  Binary Index Tree
void update(int x, int delta,int[] BIT){
       while(x<BIT.length){
            BIT[x] += delta;
           x+=x&-x;
       }
}
int query(int x,int[] BIT){
    int sum = 0;
        while(x>0){
            sum += BIT[x];
            x-=x&-x;
        }
     return sum;
} 
// 
static void mat_mul(long[][] a, long[][] b, long[][]tmp,long m){
	int n=a.length;
	for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
              long sum=0;
              for(int k=0;k<n;k++){
                    sum+=b[i][k]*a[k][j];
                    sum%=m;
               }
               tmp[i][j]=sum;
        }
     }
     for(int i=0;i<n;i++){a[i]=tmp[i].clone();}
}
static void fast_mat_exp(long[][] a,long m, long p){
      int n=a.length;
      long[][] res=new long[n][n];
      long[][] res1=new long[n][n];
      long[][] tmp=new long[n][n];
      for(int i=0;i<n;i++){res[i][i]=1;}// identity matrix;
      while(p>0){
            if(p%2==1){
                  mat_mul(res,a,res1,m); // multiply res*a. res1 storing res*a and again assigning it to res.
            }
            p/=2;
                 mat_mul(a,a,tmp,m);
      } 
      //res contains result   
 }
// end
static long[] f;

  static long phi(long n){
  	int k=(int)Math.sqrt(n);
  	long x=1,y=n;
  	for(int i=2;i<=k;i++){
  		boolean b=false;
  		while(n%i==0){
  			n/=i;b=true;
  		}
  		if(b){
  			 y/=i;
  		x*=(long)(i-1);
  		}
  	}
  	if(n>1){x*=(n-1);y/=n;}
  	return x*y;
  }
//
  //  OTHER LCA simpler

  f[1][0]=1;
  for(int i=2;i<=n;i++){
      f[i][0]=int_v(read());
      h[i]=h[f[i][0]]+1;
  }
  for(int i=1;i<20;i++){
      for(int j=2;j<=n;j++){
          f[j][i]=f[f[j][i-1]][i-1];
      }
  }
  // base case
  static int lca(int u, int v){
    if(h[u]>h[v]){
        u^=v;v^=u;u^=v;
    }
    int diff=h[v]-h[u];
    for(int i=19;i>=0;i--){
        if((diff&(1<<i))!=0){
            v=f[v][i];
        }
    }
    for(int i=19;i>=0;i--){
        if(f[u][i]!=f[v][i]){
            u=f[u][i];
            v=f[v][i];
        }
    }
    return u==v?u:f[v][0];
}
static int shortest_path(int u,int v){
    int a=lca(u,v);
    return h[u]-h[a]+h[v]-h[a];
}
  //  (Binary lifting)LCS implementation <O(NlogN,logN)>...<preprocessing,query>
static int l,time;
static int[][] f; // f[n][l]..
static int[] tin, tout;
static List<Integer>[] adj;
static boolean ok(int u, int v){
  return tin[u]<=tin[v]&&tout[u]>=tout[v]; 
}
static void dfs(int u, int p){
  tin[u]=time++;
  f[u][0]=p;
  for(int i=1;i<=l;i++){
    f[u][i]= f[f[u][i-1]][i-1];
  }

  for(int v: adj[u]){
    if(v!=p) dfs(v,u);
  }
  tout[u]=time++;
}
static int lca(int u, int v){
  if(ok(u,v)){return u;}
  if(ok(v,u)){return v;}

  for(int i=l;i>=0;i--){
    if(!ok(f[u][i],v)){
      u=f[u][i];
    }
  }
  return f[u][0];
}


// Kruskals with DSU    

static int[] parent;
static int[] rank;

// dsu disjoint set union
 static void make_set(int x){
    parent[x]=x;
    rank[x]=0;
 }
 static int find_set(int x){
    if(parent[x]==x){return x;}
    return parent[x]=find_set(parent[x]);
 }
 static void union_set(int x, int y){
    x=find_set(x);
    y=find_set(y);
    if(x==y){rank[x]++;}
    else if(rank[x]<rank[y]){int k=x;x=y;y=k;}
    parent[y]=x;
 }

class OrderStatisticTree{
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
}
       
static double f(int n, int k,double p) {
    double res=1d,c=(double)n;//n/(n-k)*k
    double k1=(double)k,n_k=(double)n-k;
    while(c>1d){
        res*=c;c--;
        while(res>(double)1e5){
            if(k1>=1d){
                res/=k1;k1--;
                res*=p;
            }
            else if(n_k>=1d){
                res/=n_k;n_k--;
                res*=(1d-p);
            }
        }
    }
    while(true){
        if(k1>=1d){
            res/=k1;k1--;
            res*=p;
        }
        else if(n_k>=1d){
            res/=n_k;n_k--;
            res*=(1d-p);
        }
        else break;
    }
    ///out.write(res+" ");
    return res;
} 
 
 // Eucledian GCD
static long[] egcd(long a, long b) {
    if (b == 0) 
      return new long[] { a, 1, 0 };
    else {
      long[] ret = egcd(b, a % b);
      long tmp = ret[1] - ret[2] * (a / b);
      ret[1] = ret[2]; 
      ret[2] = tmp; 
      return ret; 
    } 
  }
  static long modInv(long x, long m) { 
    return (egcd(x, m)[1] + m) % m; 
  }

 
    public static void main(String[] args) { 
       //assign();
        FileReader in = new FileReader("Task1.txt");
        File file = new File("Task1_out.txt");
        FileWriter f1 = new FileWriter("Task1_out.txt");
        s1 = new BufferedReader(in);
        int t=int_v(read()),cn=1;
        while(t--!=0){
          
        }
          
          out.flush();
    } 
} 