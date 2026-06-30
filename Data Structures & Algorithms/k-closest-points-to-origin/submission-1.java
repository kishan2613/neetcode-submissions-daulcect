class Solution {
    class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.first - a.first
        );

        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];

            int d = x*x+y*y;

            pq.add(new Pair(d,i));
             if (pq.size() > k) {
                pq.poll();
            }
        }

         int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            Pair p = pq.poll();
            ans[i] = points[p.second];
        }

        return ans;
    }
}
