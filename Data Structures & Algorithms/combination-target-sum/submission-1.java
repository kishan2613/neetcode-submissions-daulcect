class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
     List<List<Integer>> res = new ArrayList<>();

     dfs(0,nums,new ArrayList<>(),res,target,0);

     return res;
    }

    public void dfs(int index, int nums[], List<Integer> path, List<List<Integer>>res, int target, int sum){
        if(sum==target){
             res.add(new ArrayList<>(path));
            return;
        }
         if (sum > target) {
            return;
        }
        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            
            dfs(i,nums,path,res,target,sum+nums[i]);
            path.remove(path.size()-1);
        }
    
    }
}
