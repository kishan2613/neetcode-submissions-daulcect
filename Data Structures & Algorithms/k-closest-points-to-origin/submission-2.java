class Solution {
    class Pair{
        int dist;
        int i;

        public Pair(int d, int i){
            this.dist = d;
            this.i = i;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.dist, a.dist)
        );

        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];

            int dist = x*x+y*y;
            pq.add(new Pair(dist,i));
        }

        while(pq.size()>k){
            pq.poll();
        }
    int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = points[pq.poll().i];
        }
    return result;
    }
}
