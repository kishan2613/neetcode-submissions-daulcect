class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<strs.size();i++){
            String s = strs.get(i);
            sb.append(s.length()).append("#").append(s);
        }

    return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0;

        while(i<str.length()){
            int j=i;

            while(str.charAt(j)!='#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            int start = j + 1;
            String s = str.substring(start,start+len);
            res.add(s);

            i=start+len;
        }
    return res;
    }
}
