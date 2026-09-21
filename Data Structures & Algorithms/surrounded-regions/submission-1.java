class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                q.add(new int[]{i, 0});
                board[i][0] = '#';
            }

            if (board[i][n - 1] == 'O') {
                q.add(new int[]{i, n - 1});
                board[i][n - 1] = '#';
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                q.add(new int[]{0, j});
                board[0][j] = '#';
            }

            if (board[m - 1][j] == 'O') {
                q.add(new int[]{m - 1, j});
                board[m - 1][j] = '#';
            }
        }   

         int dirs[][] = {
                {-1,0},{0,1},{1,0},{0,-1}
            };

        while(!q.isEmpty()){
            int curr[] = q.poll();

           

            int r = curr[0];
            int c = curr[1];
            for(int i=0;i<dirs.length;i++){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];

                if(nr<0||nc<0||nr>=board.length||nc>=board[0].length||board[nr][nc]!='O'){
                    continue;
                }
            board[nr][nc]='#';
                q.add(new int[]{nr,nc});
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } 
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
