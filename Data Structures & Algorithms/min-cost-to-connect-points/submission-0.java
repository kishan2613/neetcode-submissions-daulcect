class Solution {
    static class Pair implements Comparable<Pair>{
        int n;
        int path;

        public Pair(int n, int path){
            this.n =n;
            this.path=path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[points.length];
        int finalCost=0;
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr =pq.poll();

            if(!vis[curr.n]){
                vis[curr.n]=true;
                finalCost+=curr.path;

                for(int i=0;i<points.length;i++){
                    if(!vis[i]){
                        int cost =
                            Math.abs(points[curr.n][0] - points[i][0])
                            +
                            Math.abs(points[curr.n][1] - points[i][1]);

                        pq.add(new Pair(i,cost));
                    }
                }
            }        
        }
    return finalCost;
    }
}
