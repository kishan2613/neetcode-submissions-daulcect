class Solution {
    public boolean checkInclusion(String s1, String s2) {
      HashMap<Character,Integer>  map1 = new HashMap<>();
      for(int i=0;i<s1.length();i++){
        char ch = s1.charAt(i);
        map1.put(ch,map1.getOrDefault(ch,0)+1);
      }

      HashMap<Character,Integer>  map2 = new HashMap<>();
      int left=0;
      for(int right=0;right<s2.length();right++){
         char ch = s2.charAt(right);
          map2.put(ch, map2.getOrDefault(ch, 0) + 1);
           if (right - left + 1 > s1.length()) {
                char leftChar = s2.charAt(left);

                map2.put(leftChar, map2.get(leftChar) - 1);

                if (map2.get(leftChar) == 0) {
                    map2.remove(leftChar);
                }

                left++;
            }

            if(right-left+1==s1.length()){
              if(map1.equals(map2)){
                return true;
              }
            }
      }
    return false;
    }
}
