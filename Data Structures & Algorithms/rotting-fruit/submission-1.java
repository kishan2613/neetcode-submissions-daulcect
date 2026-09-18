class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q= new LinkedList<>();
        int fresh=0;
        int mins=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    fresh++;
                }

                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }

        int dirs[][] = {{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty() &&  fresh > 0){
            int size=q.size();
            for(int j=0;j<size;j++){
            int curr[] = q.poll();
            
            int r = curr[0];
            int c = curr[1];

            for(int i=0;i<dirs.length;i++){
                int nr = r+dirs[i][0];
                int nc = c+dirs[i][1];

                if(nr<0||nc<0||nr>=grid.length||nc>=grid[0].length||grid[nr][nc]==0|| grid[nr][nc]==2){
                        continue;
                }

                grid[nr][nc]=2;
                
                fresh--;
                q.add(new int[]{nr, nc});
            } 
        }
        mins++;
    }
    return fresh==0?mins:-1;
    }
}
