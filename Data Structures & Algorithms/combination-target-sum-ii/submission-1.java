class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res =new ArrayList<>();
        dfs(0, candidates,new ArrayList<>(),res, target, 0);

    return res;
    }

    public void dfs(int index, int nums[], List<Integer> path, List<List<Integer>> res, int target, int sum){
        if(sum==target){
           
            res.add(new ArrayList<>(path));
            return;
            
        }

        for(int i=index;i<nums.length;i++){
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
             if (sum + nums[i] > target) {
                break;
            }

            path.add(nums[i]);
            dfs(i+1,nums,path,res,target,sum+nums[i]);
            path.remove(path.size()-1);
        }
    }
}
