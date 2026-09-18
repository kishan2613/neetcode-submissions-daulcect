class Solution {
    public int numIslands(char[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                    count++;
                    dfs(grid,i,j,vis);                
                }
            }
        }
    return count;
    }

    public void dfs(char[][] grid,int sr, int sc ,boolean vis[][]){
        if(sr<0||sc<0||sr>=grid.length||sc>=grid[0].length||vis[sr][sc]||grid[sr][sc]=='0'){
            return;
        }
        vis[sr][sc]=true;
        dfs(grid,sr+1,sc,vis);
        dfs(grid,sr-1,sc,vis);
        dfs(grid,sr,sc+1,vis);
        dfs(grid,sr,sc-1,vis);
    }
}
