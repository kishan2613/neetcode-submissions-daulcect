class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,target,0,new ArrayList<>(),res);

        return res;
    }

    public void dfs(int nums[],int target,int index, List<Integer> path, List<List<Integer>>res){
        if(target==0){
        res.add(new ArrayList<>(path));
        return;
        }

        if(target<0){
            return;
        }
        for(int i=index;i<nums.length;i++){
           path.add(nums[i]);

           dfs(nums,target-nums[i],i,path,res);

           path.remove(path.size()-1);
        }
    }
}
