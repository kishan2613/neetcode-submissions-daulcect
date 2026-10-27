class Solution {
    class Edge{
        char src;
        char dest;

        public Edge(char s,char d){
            this.src =s;
            this.dest =d;
        }
    }

    public void createGraph(ArrayList<Edge> graph[], String[] words) {

    for (int i = 0; i < graph.length; i++) {
        graph[i] = new ArrayList<>();
    }

    // Compare adjacent words
    for (int i = 0; i < words.length - 1; i++) {

        String s1 = words[i];
        String s2 = words[i + 1];

        int len = Math.min(s1.length(), s2.length());

        for (int j = 0; j < len; j++) {
            if (s1.charAt(j) != s2.charAt(j)) {

                // Add directed edge
                graph[s1.charAt(j) - 'a'].add(
                    new Edge(s1.charAt(j), s2.charAt(j))
                );

                break;
            }
        }
    }
    }

    public String foreignDictionary(String[] words) {
        int n=26;
      ArrayList<Edge> graph[] = new ArrayList[n];

      createGraph(graph,words);


      for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }
        }

    int[] indeg = new int[n];
    boolean[] present = new boolean[n];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (Edge e : graph[i]) {
                indeg[e.dest - 'a']++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        int totalChars = 0;

        for (int i = 0; i < n; i++) {
            if (present[i]) {
                totalChars++;

                if (indeg[i] == 0) {
                    q.add(i);
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        while(!q.isEmpty()){
            int curr =q.poll();

            ans.append((char)(curr+'a'));

            for(Edge e :graph[curr]){
                indeg[e.dest-'a']--;

                if(indeg[e.dest-'a']==0){
                    q.add(e.dest-'a');
                }
            }

        }
    if (ans.length() != totalChars) {
            return "";
        }

    return ans.toString();
    }
}

