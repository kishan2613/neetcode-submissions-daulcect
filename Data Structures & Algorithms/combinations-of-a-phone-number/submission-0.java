class Solution {
    public List<String> letterCombinations(String digits) {
        List<String>res = new ArrayList<>();
         if (digits.length() == 0) {
            return res;
        }
        String[] key = {
    "",     // 0
    "",     // 1
    "abc",  // 2
    "def",  // 3
    "ghi",  // 4
    "jkl",  // 5
    "mno",  // 6
    "pqrs", // 7
    "tuv",  // 8
    "wxyz"  // 9
};

        helper(digits,0, key,new StringBuilder(),res);

    return res;
    }
   // def ->ghi
    public void helper(String digits,int index, String key[],StringBuilder sb, List<String> res){
        
        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }
        int num = digits.charAt(index) - '0';
        String str = key[num];

        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            helper(digits,index+1,key,sb,res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
