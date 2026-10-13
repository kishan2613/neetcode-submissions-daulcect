class Solution {
    public void solve(char[][] board) {
        int n =board.length;
        int m = board[0].length;
        Queue<int []> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                board[i][0]='#';
                q.offer(new int[]{i,0});
            }

            if(board[i][m-1]=='O'){
                board[i][m-1]='#';
                q.offer(new int[]{i,m-1});
            }
        }

        for(int i=0;i<m;i++){
            if(board[0][i]=='O'){
                board[0][i]='#';
                q.offer(new int[]{0,i});
            }

            if(board[n-1][i]=='O'){
                board[n-1][i]='#';
                q.offer(new int[]{n-1,i});
            }
        }

        int dirs[][] = {
            {1,0},{0,1},{0,-1},{-1,0}
        };

        while(!q.isEmpty()){
            int curr[] =q.poll();
            
            int r = curr[0];
            int c = curr[1];

            for(int dir[]:dirs){
                int nr = r+dir[0];
                int nc = c+dir[1];

                if(nr<0||nc<0||nr>=n||nc>=m||board[nr][nc]!='O'){
                    continue;
                }
                board[nr][nc]='#';
                q.offer(new int[]{nr,nc});
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}
