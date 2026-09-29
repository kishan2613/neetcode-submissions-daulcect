class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int open =n;
        int close =n;
        helper( n, open,close,new StringBuilder(),res);

    return res;
    }

    public static void helper(int n,int open, int close, StringBuilder sb, List<String>res){

        if(open==0 && close==0){
            res.add(sb.toString());
            return;
        }
        if(open>0){
        sb.append('(');
        helper(n,open-1,close,sb,res);
        sb.deleteCharAt(sb.length()-1);
        }

        if(close>open){
        sb.append(')');
        helper(n,open,close-1,sb,res);
        sb.deleteCharAt(sb.length()-1);
        }
    }
}
