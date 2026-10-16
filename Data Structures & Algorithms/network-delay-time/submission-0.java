class Solution {
    class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src =s;
            this.dest =d;
            this.wt =w;
        }
    }

    class Pair{
        int node;
        int n;

        public Pair(int s, int n){
            this.node = s;
            this.n = n;
        }
    }

    public void createGraph(ArrayList<Edge> graph[], int times[][]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<times.length;i++){
            int src = times[i][0];
            int dest = times[i][1];
            int wt = times[i][2];

            graph[src].add(new Edge(src,dest,wt));
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n+1];
        createGraph(graph, times);
         int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(a.n,b.n)
        );

       pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;

            if(curr.n>dist[node]){
                continue;
            }

            for(int i=0;i<graph[node].size();i++){
                Edge e = graph[node].get(i);

                int u = e.src;
                int v = e.dest;
                int w = e.wt;

                if(dist[node]+w<dist[v]){
                    dist[v] = dist[node]+w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        int ans=0;

        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }

            ans=Math.max(ans,dist[i]);
        }
    return ans;
    }
}
