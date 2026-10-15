class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m =board[0].length;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(helper(board,i,j,0,word)){
                return true;
            }
        }
        
       }
       return false;
    }

    public boolean helper(char board[][],int i, int j, int sb,String word){
         if(sb==word.length()){
            return true;
        }
        
        if(i<0||j<0||i>=board.length||j>=board[0].length || board[i][j] != word.charAt(sb)){
            return false;
        }
       

        char temp = board[i][j];
        board[i][j] = '#';
        
       boolean found =  helper(board,i+1,j,sb+1,word)||
        helper(board,i-1,j,sb+1,word)||
        helper(board,i,j+1,sb+1,word)||
        helper(board,i,j-1,sb+1,word);
        board[i][j] = temp;

    return found;
    }
}
