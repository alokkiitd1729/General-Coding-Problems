import java.util.*;
import java.io.*;
import java.math.BigInteger; 
// long B=972663749,A=911382323;
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

static String setpreciosion(double d,int k){BigDecimal d1 = new BigDecimal(Double.toString(d));return d1.setScale(k,RoundingMode.UP).toString();} //UP DOWN,  .doubleValue() 
// rec Inv
static class Inv{
    void Inv(){
        long[] inv=new long[1000001];inv[0]=inv[1]=1;
        inv[i]=mod-Modmul(mod/i,inv[mod%i],mod);
    }
}
// find (a*b) mod c; a,b,c ~ 10^18
// useful for Hasing but time complexity is O(bits*...)
static class long_mult{
    // Hashing using a pair of mod1,mod2<=1e9
    // https://pastebin.com/iaVp6ypH
    long mult_mod(long a,long b,long c){
        if (a < b){a^=b^=a^=b;} //swap(a, b);
        long r = 0, m = a;
        for (int i = 0; i < 64; ++i){
            if ((1l<<i) > b) break;
            if (b&1l<<i) r = (r+m)%c;
            m = (m*2)%c;
        }
        return r;
    }
}

  
// KMP/Z function String processing... S-riginal string
// KMP ->  P[i] = length  of longest prefix which is also suffix of S[0.....i](S.substring(0,i));
// Z[i] = length of longest prefix of S which is also prefix of (the suffix string S[i,i+1,...n] - i.e suffix of S starting at i)
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

// Floyad warshell print path+All pair shortest path
static void All_pair_shortest(){
  // problem example
  // https://atcoder.jp/contests/abc051/tasks/abc051_d
     int[] x=int_arr();
      int n=x[0],m=x[1];
      int[][] g=new int[n+1][n+1];
      int[][] next=new int[n+1][n+1];
      boolean[][] b=new boolean[n+1][n+1];
      for(int i=0;i<m;i++){
        int[] e=int_arr();
        g[e[0]][e[1]]=e[2];
        g[e[1]][e[0]]=e[2];
      }
      for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
          if(g[i][j]==0)g[i][j]=(int)mod;
          else next[i][j]=j;
        }
      }

      for(int k=1;k<=n;k++){
        for(int i=1;i<=n;i++){
          for(int j=1;j<=n;j++){
            if(g[i][j]>g[i][k]+g[k][j]){
              g[i][j]=g[i][k]+g[k][j];
              next[i][j]=next[i][k];
            }
          }
        }
      }
      
      for(int i=1;i<=n;i++){
        for(int j=i+1;j<=n;j++){
          int u=i,v=j;
          while(u!=v){
            b[u][next[u][v]]=true;
            u=next[u][v];
          }
        }
      }
}
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
// Digit DP
static class digitDp{

static pair[][] dp;
static class pair{
    long e;long o;
    pair(long e1,long o1){e=e1;o=o1;}
}
static pair ok(String s,int k,int tight) throws  IOException {
    if(k==1){
        if(tight==0){
            return dp[k][tight]=new pair(5,5);
        }
        else{
            int c=s.charAt(s.length()-k)-'0';
            return dp[k][tight]=new pair(c/2+1,(c+1)/2);
        }
    }
    if(dp[k][tight]!=null) return dp[k][tight];
    int ub=tight==1?(s.charAt(s.length()-k)-'0'):9;
    long e=0,o=0;
    for(int i=0;i<=ub;i++){
        int f=i<ub?0:1; int ss=f&tight;
        pair p=ok(s,k-1,ss);
        if(i%2==1) o+=p.e;
        else e+=p.o;
    }
    return dp[k][tight]=new pair(e,o);
}

}
// finad all cycle in the undirected Graph
static class All_Ccycles{
  static List<int[]>[] g;
  static boolean[] b;
  static List<List<Integer>> cycle;
  static int[] mark,bap;
  static void dfs(int u,int p) throws  IOException{
      if(mark[u]==2) return; 
      if(mark[u]==1){    // visited but in system
          List<Integer> l=new ArrayList<>();
          l.add(u);
          int curr=p;
          while(curr!=u){
              l.add(curr);
              curr=bap[curr];
          }
          l.add(u); 
          cycle.add(l);
          return;
      }
      mark[u]=1;bap[u]=p;
      for(int[] c:g[u]){
          int v=c[0];
          if(v!=p) dfs(v,u);
      }
      mark[u]=2;// finished
  }
}
// Strongly Connected Components
static class Strongly_Connected_Components{

    static Stack<Integer> s=new Stack<>();
    static int[] in,low; static int timer=0;
    static List<Integer>[] g;
    static List<List<Integer>> l;
    static boolean[] instack;
    static void dfs(int u){
        in[u]=low[u]=timer++;
        s.push(u); instack[u]=true;
        for(int v:g[u]){
            if(in[v]==-1){
                dfs(v);
                low[u]=Math.min(low[u],low[v]);
            }
            else if(instack[v]){
                low[u]=Math.min(low[u],in[v]);
            }
        }
        if(in[u]==low[u]){
            List<Integer> comp=new ArrayList<>();
            while(true){
                int j=s.pop();
                instack[j]=false;
                comp.add(j);
                if(u==j) break;
            }
            l.add(comp);
        }
    }
}
// Articulation point..cut vertex

static class Articulation_point{
    List<Integer>[] g;int n;
    int[] in,low; boolean[] b;
    int count,timer;
    Set<Integer> s=new HashSet<>();

     void dfs(int u,int p){
        in[u]=low[u]=timer++;
        int child=0; b[u]=true;
        for(int v:g[u]){
            if(v==p) continue;
            if(!b[v]){
                dfs(v,u);
                low[u]=Math.min(low[u],low[v]);
                child++;
                if(low[v]>=in[u]&&p!=-1) s.add(u);//p!=-1 means u is not rot
            }
            else{
                low[u]=Math.min(low[u],in[v]);
            }
        }
        if(p==-1&&child>1) s.add(u);
    }
     void go(){
        for(int i=1;i<=n;i++){
            if(!b[i]) dfs(i,-1);
        }
    }
}
// Brdiges...cut edges
static class Bridge{
    List<Integer>[] g;int n;
    int[] in,low; boolean[] b;
    int count,timer;
    List<int[]> l=new ArrayList<>();
    
     void dfs(int u,int p){
        in[u]=low[u]=timer++;
        b[u]=true;
        for(int v:g[u]){
            if(v==p) continue;
            if(!b[v]){
                dfs(v,u);
                low[u]=Math.min(low[u],low[v]);
                if(low[v]>in[u]) l.add(new int[]{u,v});
            }
            else{
                low[u]=Math.min(low[u],in[v]);
            }
        }
    }
     void go(){
        for(int i=1;i<=n;i++){
            if(!b[i]) dfs(i,-1);
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
//.....................dijkstra shortest path
  static void dijkstra(List<int[]>[] g, int s, int[] d,int n){
    PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->f(x,y));
    boolean[] b=new boolean[n+1];
    d[s]=0; pq.add(new int[]{s,0});
    while(!pq.isEmpty()){
        int[] curr=pq.poll();
        int p=curr[0];
        //if(b[p]) continue;
        //b[p]=true;
        if(d[p[0]]>p[1]) continue;
        for(int[] c:g[p]){
            if(b[c[0]]) continue;
            if(d[p]+c[1]<d[c[0]]){
                d[c[0]]=d[p]+c[1];
                pq.add(new int[]{c[0],d[c[0]]});
            }
        }
    }
}
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

  //f[1][0]=1;
 static void construct_for_lca(){
    for(int i=2;i<=n;i++){
        f[i][0]=int_v(read());
        h[i]=h[f[i][0]]+1;
    }
    for(int i=1;i<20;i++){
        for(int j=2;j<=n;j++){
            f[j][i]=f[f[j][i-1]][i-1];
        }
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

/*

static void usaco1() throws  IOException{
        FileReader in = new FileReader("gymnastics.in");
        File file = new File("gymnastics.out");
        FileWriter f1 = new FileWriter(file);
        s1 = new BufferedReader(in);
        out= new BufferedWriter(f1);
        solve();
}
*/
 
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



/*
#include <iostream>
#include <vector>
#include <map>
#include <queue>
#include <utility>

typedef std::pair<int, int> ii;

template <class T = int>
class Dinic {
public:
  struct Edge {
    Edge(int a, T b){to = a;cap = b;}
    int to;
    T cap;
  };

  Dinic(int n) {
    edges.resize(n);
    this->n = n;
  }

  T maxFlow(int src, int sink) {
    T ans = 0;
    while(bfs(src, sink)) {
      T flow;
      pt = std::vector<int>(n, 0);
      while(flow = dfs(src, sink)) {
        ans += flow;
      }
    }
    return ans;
  }

  void addEdge(int from, int to, T cap = 1) {
    edges[from].push_back(list.size());
    list.push_back(Edge(to, cap));
    edges[to].push_back(list.size());
    list.push_back(Edge(from, 0));
  }
private:
  int n;
  std::vector<std::vector<int> > edges;
  std::vector<Edge> list;
  std::vector<int> h, pt;

  T dfs(int on, int sink, T flow = 1e9) {
    if(flow == 0) {
      return 0;
    } if(on == sink) {
      return flow;
    }
    for(; pt[on] < edges[on].size(); pt[on]++) {
      int cur = edges[on][pt[on]];
      if(h[on] + 1 != h[list[cur].to]) {
        continue;
      }
      T got = dfs(list[cur].to, sink, std::min(flow, list[cur].cap));
      if(got) {
        list[cur].cap -= got;
        list[cur ^ 1].cap += got;
        return got;
      }
    }
    return 0;
  }

  bool bfs(int src, int sink) {
    h = std::vector<int>(n, n);
    h[src] = 0;
    std::queue<int> q;
    q.push(src);
    while(!q.empty()) {
      int on = q.front();
      q.pop();
      for(auto a : edges[on]) {
        if(list[a].cap == 0) {
          continue;
        }
        int to = list[a].to;
        if(h[to] > h[on] + 1) {
          h[to] = h[on] + 1;
          q.push(to);
        }
      }
    }
    return h[sink] < n;
  }
};

std::vector<ii> divs(int n) {
  std::vector<ii> ans;
  for(int i = 2; i * i <= n; i++) {
    int f = 0;
    while(n % i == 0) {
      n /= i;
      f++;
    }
    if(f) {
      ans.emplace_back(i, f);
    }
  }
  if(n > 1) {
    ans.emplace_back(n, 1);
  }
  return ans;
}

int main() {
  std::ios_base::sync_with_stdio(false); std::cin.tie(NULL);
  int n, m;
  std::cin >> n >> m;
  std::vector<int> a(n);
  for(int i = 0; i < n; i++) {
    std::cin >> a[i];
  }
  std::map<int, std::map<int, int>> freqs;
  std::vector<ii> edges;
  Dinic<int> base(n + 2);
  int src = n, sink = n + 1;
  for(int i = 0; i < m; i++) {
    int u, v;
    std::cin >> u >> v;
    u--;
    v--;
    if(u % 2 == 1) {
      std::swap(u, v);
    }
    edges.emplace_back(u, v);
    base.addEdge(u, v, 100);
  }
  for(int i = 0; i < n; i++) {
    auto v = divs(a[i]);
    for(auto d : v) {
      freqs[d.first][i] = d.second;
    }
  }
  int ans = 0;
  for(auto g : freqs) {
    Dinic<int> graph = base;
    //std::cout << "for " << g.first << std::endl;
    for(auto f : g.second) {
      int u = f.first;
      int c = f.second;
      //std::cout << "cap " << c << ", ";
      if(u % 2 == 0) {
        //std::cout << "adding first type for " << u << std::endl;
        graph.addEdge(src, u, c);
      } else {
        //std::cout << "adding second type for " << u << std::endl;
        graph.addEdge(u, sink, c);
      }
    }
    ans += graph.maxFlow(src, sink);
  }
  std::cout << ans << std::endl;
}
*/
