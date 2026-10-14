class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int case1 = helper(nums,0,n-2);
        int case2 = helper(nums,1,n-1);

        return Math.max(case1,case2);
    }

    public int helper(int nums[], int start, int end){
        int dp[] = new int[end-start+2];

        dp[0] =0;

        dp[1] = nums[start];

        for(int i=2;i<end-start+2;i++){
            int inc = nums[start+i-1]+dp[i-2];
            int exc = dp[i-1];

            dp[i] = Math.max(inc,exc);
        }
    return dp[end-start+1];
    }
}
