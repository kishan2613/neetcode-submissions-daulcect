class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
            
            if(tokens[i].equals("+")){
                int b = st.pop();
                int a = st.pop();

                int total =b+a;
                st.push(total);
            }
            else if(tokens[i].equals("*")){
                int b = st.pop();
                int a = st.pop();

                int total =b*a;
                st.push(total);
            }
            else if(tokens[i].equals("-")){
                int b = st.pop();
                int a = st.pop();

                int total =a-b;
                st.push(total);
            } else if(tokens[i].equals("/")){
                int b = st.pop();
                int a = st.pop();

                int total =a/b;
                st.push(total);
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }

    return st.peek();
    }
}
