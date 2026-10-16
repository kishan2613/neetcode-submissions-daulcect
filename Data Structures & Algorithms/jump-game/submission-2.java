class Solution {
    public boolean canJump(int[] nums) {
       int max=0;
        int n = nums.length;
       for(int i=0;i<nums.length;i++){
        if(i>max){
            return false;
        }
        max = Math.max(max,i+nums[i]);

        if(max>=n-1){
            return true;
        }
       }

    return false;
    }
}
