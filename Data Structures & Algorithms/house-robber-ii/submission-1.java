class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
       if(n==0)return 0;
       if(n==1)return nums[0];

        int case1 = houserob(nums,0,n-2);
        int case2 = houserob(nums,1,n-1);

        return Math.max(case1, case2);
    }

    public int houserob(int nums[], int i, int j){
        int dp[] = new int[j-i+2];
        dp[0]=0;
        dp[1] = nums[i];

        for(int k=2;k<j-i+2;k++){
            dp[k] = Math.max(dp[k-1],dp[k-2]+nums[i+k-1]);
        }

    return dp[j-i+1];
    }
}
