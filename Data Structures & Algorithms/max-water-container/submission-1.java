class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int maxarea=0;
        int height=0;
        while(left<right){
            height = Math.min(heights[left],heights[right]);

            int area = height*(right-left);

            maxarea = Math.max(maxarea,area);

            if(heights[left]<heights[right]){
                left++;
            }else{
                right--;
            }
        }
    return maxarea;
    }
}
