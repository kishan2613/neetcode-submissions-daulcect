class Solution {
    static int par[];
    static int rank[];

    public void init(int n ){
        par = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }

    public static int find(int x){
        if(x==par[x]){
            return x;
        }

        return find(par[x]);
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA]==rank[parB]){
            par[parA]=parB;
            rank[parA]++;
        }else if(rank[parA]<rank[parB]){
            par[parA] = parB;
        }else{
            par[parB] = parA;
        }
    }


    public boolean validTree(int n, int[][] edges) {
    init(n);

    for(int i=0;i<edges.length;i++){
         if (edges.length != n - 1) {
            return false;
        }
        int src = edges[i][0];
        int dest = edges[i][1];
        
        int parA = find(src);
        int parB = find(dest);

        if(parA==parB){
            return false;
        }
        union(src,dest);
    }
    return true;
    }
}
