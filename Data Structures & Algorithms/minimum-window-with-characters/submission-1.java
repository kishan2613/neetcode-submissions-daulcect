class Solution {
    public String minWindow(String s, String t) {
       if(s.length()<t.length()) return "";

       HashMap<Character,Integer> map = new HashMap<>();

       for(int i=0;i<t.length();i++){
        char ch = t.charAt(i);

        map.put(ch,map.getOrDefault(ch,0)+1);
       }

       int left=0,count=t.length();
       int minlen=Integer.MAX_VALUE;

       int start=0;

       for(int right=0;right<s.length();right++){
        char ch = s.charAt(right);

        if(map.containsKey(ch)){
            if(map.get(ch)>0)count--;
            map.put(ch,map.get(ch)-1);
        }

        while(count==0){
            if(right-left+1<minlen){
                minlen=right-left+1;
                start=left;
            }

            char leftChar = s.charAt(left);
            if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) count++;
            }

            left++;
        }
       }
    
    return minlen==Integer.MAX_VALUE?"":s.substring(start,start+minlen);
    }
}
