class Solution {
    class Pair{
        int node;
        int n;

        public Pair(int node, int n){
            this.node =node;
            this.n = n;
        }
    }

    public int minCostConnectPoints(int[][] points) {
    PriorityQueue<Pair> pq = new PriorityQueue<>(
        (a,b)->Integer.compare(a.n,b.n)
    );
    boolean vis[] = new boolean[points.length];
    int finalcost =0;
    pq.add(new Pair(0,0));

    while(!pq.isEmpty()){
        Pair curr =pq.poll();

        if(!vis[curr.node]){
            vis[curr.node]=true;

            finalcost +=curr.n;

            for(int i=0;i<points.length;i++){
                if(!vis[i]){
                    int cost = Math.abs(points[curr.node][0]-points[i][0])+Math.abs(points[curr.node][1] - points[i][1]);

                pq.add(new Pair(i,cost));
                }
            }
        }
    }
    return finalcost;
    }
}
