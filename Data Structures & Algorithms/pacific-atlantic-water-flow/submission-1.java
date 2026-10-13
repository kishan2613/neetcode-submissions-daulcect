class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

       boolean[][] pacific = new boolean[m][n];
       boolean[][] atlantic = new boolean[m][n];

       Queue<int[]> pq = new LinkedList<>();
       Queue<int[]> aq = new LinkedList<>();

       for(int i=0;i<m;i++){
        pacific[i][0] = true;
        pq.offer(new int[]{i,0});
       }

       for(int i=0;i<n;i++){
        pacific[0][i]=true;
        pq.offer(new int[]{0,i});
       }

       for(int i=0;i<m;i++){
        atlantic[i][n-1]=true;
        aq.offer(new int[]{i,n-1});
       }

       for(int i=0;i<n;i++){
            atlantic[m-1][i]=true;
            aq.offer(new int[]{m-1,i});
       }

        bfs(heights,pacific,pq);
        bfs(heights,atlantic,aq);

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j]&&atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    public void bfs(int[][] heights, boolean vis[][], Queue<int []> q){
        int m = heights.length;
        int n = heights[0].length;

        int dirs[][] = {
            {-1,0},{0,1},{1,0},{0,-1}
        };

        while(!q.isEmpty()){
            int curr[] = q.poll();

            int r =curr[0];
            int c = curr[1];

            for(int dir[]:dirs){
                int nr = r+dir[0];
                int nc = c+dir[1];

                if(nr<0||nc<0||nr>=m||nc>=n){
                    continue;
                }

                if(vis[nr][nc]){
                    continue;
                }

               if (heights[nr][nc] < heights[r][c]) {
                    continue;
                }

                vis[nr][nc]=true;
                q.offer(new int[]{nr,nc});
            }
        }
    }
}
