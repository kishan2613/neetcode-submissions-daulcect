class Solution {
    class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src =s;
            this.dest =d;
        }
    }
    public void createGraph(ArrayList<Edge> graph[], int [][] prerequisites){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<prerequisites.length;i++){
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];

            graph[src].add(new Edge(src,dest));
        }
    }

    public void calcIndeg(ArrayList<Edge> graph[], int indeg[]){
        for(int i=0;i<graph.length;i++){
            int v = i;
            for(int j=0;j<graph[v].size();j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Edge> graph[] = new ArrayList[numCourses];
        createGraph(graph,prerequisites);
        int indeg[] = new int[numCourses];
        calcIndeg(graph, indeg);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int k=0;
        int res[] = new int[numCourses];
        while(!q.isEmpty()){
            int curr = q.poll();
            res[k++]=curr;

            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
         if (k != numCourses) {
            return new int[0];
        }
    return res;
    }
}
