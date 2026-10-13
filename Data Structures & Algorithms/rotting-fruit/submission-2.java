class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh=0;
        int mins=0;
       Queue<int[]> q = new LinkedList<>();
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==2){
                q.offer(new int[]{i,j});
            }else if(grid[i][j]==1){
                fresh++;
            }
        }
       }

       int dirs[][] = {
        {-1,0},{0,1},{1,0},{0,-1}
       };

       while(!q.isEmpty()&& fresh > 0){
        int size = q.size();
        for(int i=0;i<size;i++){
            int curr[] = q.poll();
      
        int r = curr[0];
        int c = curr[1];
        for(int dir[]:dirs){
            int nr = r+dir[0];
            int nc = c+dir[1];

            if(nr<0||nc<0||nr>=grid.length||nc>=grid[0].length||grid[nr][nc]!=1){
                continue;
            }

            grid[nr][nc]=2;
            fresh--;

            q.offer(new int[]{nr,nc});
        }
         }
         mins++;
       }
    return fresh==0?mins:-1;
    }
}
