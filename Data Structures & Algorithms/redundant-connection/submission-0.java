class Solution {
    static int par[];
    static int rank[];

    public void init(int n){
        par = new int[n+1];
        rank = new int[n+1];

        for(int i=1;i<=n;i++){
            par[i]=i;
        }
    }

    public  int find(int x){
        if(x==par[x]){
            return x;
        }

        return find(par[x]);
    }

    public void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA]==rank[parB]){
            par[parA]=parB;
            rank[parB]++;
        }else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }else{
            par[parB]=parA;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
     init(n);


     for(int i=0;i<edges.length;i++){
        int src =edges[i][0];
        int dest = edges[i][1];

        int parA = find(src);
        int parB = find(dest);

        
        if(parA==parB ){
            return new int[]{src, dest};
        }else{
            union(src,dest);
        }
     }
    return new int[0];
    }
}
