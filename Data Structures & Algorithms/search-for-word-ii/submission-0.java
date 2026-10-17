class Solution {
    class Node{
        Node children[] = new Node[26];
        boolean eow;
    }


    public Node root = new Node();

    public void addword(String word){
        Node curr = root;

        for(char ch: word.toCharArray()){
            int idx = ch-'a';

            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow=true;
    }

    public void dfs(char board[][], int r, int c,Node node, StringBuilder path, List<String>res){

        char ch = board[r][c];
        int idx= ch-'a';

        if(node.children[idx]==null){
            return;
        }

        node =node.children[idx];
        path.append(ch);


        if(node.eow){
            res.add(path.toString());
            node.eow=false;
        }
        board[r][c] = '#';

        int dirs[][] ={
            {-1,0},{0,1},{1,0},{0,-1}
        };


        for(int dir[]:dirs){
            int nr = r+ dir[0];
            int nc = c+dir[1];

            if (nr >= 0 && nr < board.length &&
                nc >= 0 && nc < board[0].length &&
                board[nr][nc] != '#') {

                dfs(board, nr, nc, node, path, res);
            }
        }

        board[r][c]=ch;
        path.deleteCharAt(path.length()-1);
    }
    public List<String> findWords(char[][] board, String[] words) {
        for(String str:words){
            addword(str);
        }

        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,root,path,res);
            }
        }
    return res;
    }
}
