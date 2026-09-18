class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 &&vis[i][j]==false){
                    
                    max = Math.max(max,dfs(grid,i,j,vis));
                    System.out.println(max);
                }
            }
        }
    return max;
    }

    public int dfs(int[][] grid, int sr, int sc, boolean vis[][]){
        if(sr<0||sc<0||sr>=grid.length||sc>=grid[0].length||vis[sr][sc]||grid[sr][sc]==0){
            return 0;
        }

        
        vis[sr][sc]=true;
        int count=1;
        count +=dfs(grid,sr-1,sc,vis);
        count +=dfs(grid,sr+1,sc,vis);
        count +=dfs(grid,sr,sc-1,vis);
        count +=dfs(grid,sr,sc+1,vis);
    
    return count;
    }
}










