class Solution {
    class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src =s;
            this.dest =d;
        }
    }

    public void createGraph(int prerequisites[][], ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<prerequisites.length;i++){
            int src = prerequisites[i][0];
            int dest = prerequisites[i][1];

            graph[src].add(new Edge(src,dest));
        }
    }

    public void calcindeg(ArrayList<Edge> graph[], int indeg[]){
        for(int i=0;i<graph.length;i++){
            int v =i;
            for(int j=0;j<graph[v].size();j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    int n = numCourses;
    ArrayList<Edge> graph[] = new ArrayList[n];
    createGraph(prerequisites,graph);
    int indeg[] = new int[n];
    calcindeg(graph,indeg);

    Queue<Integer> q = new LinkedList<>();

    for(int i=0;i<indeg.length;i++){
        if(indeg[i]==0){
            q.offer(i);
        }
    }
    int count=0;
    while(!q.isEmpty()){
        int curr = q.poll();
        count++;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            int src = e.src;
            int dest = e.dest;
            indeg[e.dest]--;
            if(indeg[e.dest]==0){
                q.add(e.dest);
            }
        }
    }
    return count==numCourses;
    }
}
