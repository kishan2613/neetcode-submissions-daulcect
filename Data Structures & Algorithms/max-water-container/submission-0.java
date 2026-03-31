class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        
        int maxwater =0;

        while(left<right){
            int th = Math.min(heights[left],heights[right]);
            int rh = right-left;

            maxwater = Math.max(maxwater, th*rh);

             if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

    return maxwater;
    }
}
