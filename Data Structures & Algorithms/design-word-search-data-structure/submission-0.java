class WordDictionary {
    class Node{
        Node children[] = new Node[26];
        boolean eow;
    }

    public Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;

        for(char ch: word.toCharArray()){
            int  idx = ch-'a';

            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }

            curr = curr.children[idx];
        }
        curr.eow=true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    public boolean dfs(Node curr, String word, int index){
        if(index==word.length()){
            return curr.eow;
        }

        char ch = word.charAt(index);

        if(ch=='.'){
             for (Node child : curr.children) {
                if (child != null && dfs(child, word, index + 1)) {
                    return true;
                }
            }
            return false;
        }else{
            int idx = ch - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            return dfs(curr.children[idx], word, index + 1);
        }
    }
}
