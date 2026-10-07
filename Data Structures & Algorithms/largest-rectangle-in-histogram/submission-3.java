class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nse[] = new int[n];
        int pse[] = new int[n];
        
        Arrays.fill(nse,heights.length);
        Arrays.fill(pse,-1);
        nse(heights,nse);
        pse(heights,pse);
        int max=0;
        for(int i=0;i<n;i++){
            int width = (nse[i]-pse[i]-1)*heights[i];

            max = Math.max(max,width);
        }
    return max;
    }

    public void nse(int heights[], int nse[]){
        Stack<Integer> st =new Stack<>();

        for(int i=heights.length-1;i>=0;i--){
            while(!st.isEmpty()&& heights[st.peek()]>=heights[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                nse[i]=st.peek();
            }
            st.push(i);
        }
    }

    public void pse(int heights[], int pse[]){
        Stack<Integer> st =new Stack<>();

        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty()&& heights[st.peek()]>=heights[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                pse[i]=st.peek();
            }
            st.push(i);
        }
    }
}
