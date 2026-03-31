class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;

        for(int num:nums){
            total+=num;
        }

        if(total%2!=0)return false;

        int target =total/2;

    return target(nums,target);
    }

    public boolean target(int nums[], int sum){
        int n = nums.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(nums[i-1]<=j&&dp[i-1][j-nums[i-1]]==true){
                    dp[i][j]=true;
                }else if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }
            }
        }
    return dp[n][sum];
    }
}
