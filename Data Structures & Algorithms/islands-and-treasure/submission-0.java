class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q= new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }

        int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};

        while(!q.isEmpty()){
            int curr[] = q.poll();

            int r =curr[0];
            int c = curr[1];

            for(int i=0;i<dirs.length;i++){
                int nr = r+dirs[i][0];
                int nc = c+dirs[i][1];

                if(nr<0||nc<0||nr>=grid.length||nc>=grid[0].length){
                    continue;
                }

                if(grid[nr][nc]!=Integer.MAX_VALUE){
                    continue;
                }

                grid[nr][nc] = 1+grid[r][c];

                q.offer(new int[]{nr,nc});
            }
        }
    }
}
