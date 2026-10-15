class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,0,0,res,new ArrayList<>(), target);

        return res;
    }

    public void helper(int nums[],int k,int sum,List<List<Integer>>res, List<Integer>path, int target){
        if(sum==target){
            res.add(new ArrayList<>(path));
            return;
        }

        if(sum>target){
            return;
        }
        
        for(int i=k;i<nums.length;i++){
            path.add(nums[i]);
            helper(nums,i,sum+nums[i],res,path,target);
            path.remove(path.size()-1);

        }
    }
}
