class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,0,res,new ArrayList<>());
        return res;
    }
    public void helper(int nums[],int i, List<List<Integer>> res,List<Integer> path){
        res.add(new ArrayList<>(path));

        for(int j=i;j<nums.length;j++){
            path.add(nums[j]);
            helper(nums,j+1,res,path);
            path.remove(path.size()-1);
        }
    }
}
