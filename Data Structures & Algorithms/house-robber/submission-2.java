class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];

        dp[0]=0;
        dp[1] =nums[0];

        for(int i=2;i<n+1;i++){
            //robbing 
            int inc = nums[i-1]+dp[i-2];
            int exc = dp[i-1];//not robbing

            dp[i] = Math.max(inc,exc);
        }
    return dp[n];
    }
}
