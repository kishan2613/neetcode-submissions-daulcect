class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int res[] = new int[n];
        for(int i=0;i<n;i++){
           
           while(!st.isEmpty()&& temperatures[i]>temperatures[st.peek()]){
            int prevIndex =st.pop();
            res[prevIndex] = i-prevIndex;
           }

           st.push(i);
        }

    return res;
    }
}
