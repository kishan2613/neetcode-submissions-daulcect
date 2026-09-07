class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        dfs(0, nums,new ArrayList<>(),res);
        return res;
    }

    public void dfs(int index, int nums[], List<Integer>path, List<List<Integer>> res){
       
            res.add(new ArrayList<>(path));
       

        for(int i=index;i<nums.length;i++){
             if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(i+1,nums,path,res);
            path.remove(path.size()-1);
        }
    }
}
