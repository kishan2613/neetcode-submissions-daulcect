class Solution {
    class Pair{
        String str;
        int level;

        public Pair(String s, int i){
            this.str = s;
            this.level=i;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String str:wordList){
            set.add(str);
        }

        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()){               
        Pair curr = q.poll();
        char temp[] = curr.str.toCharArray();

        for(int i=0;i<temp.length;i++){
            char original = temp[i];

            for(char j='a';j<='z';j++){
                temp[i]=j;

                String s = new String(temp);
                if(set.contains(s)){
                    q.add(new Pair(s,curr.level+1));
                    set.remove(s);
                    if(s.equals(endWord)){
                        ans = Math.min(ans,curr.level+1);
                    }
                }
            }
            temp[i] = original;
        }

        }

    return (ans==Integer.MAX_VALUE)?0:ans;
    }
}
