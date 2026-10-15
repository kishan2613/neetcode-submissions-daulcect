class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,res,new ArrayList<>());

    return res;
    }

    public void dfs(int nums[], List<List<Integer>> res,List<Integer>path ){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            dfs(nums,res,path);
            path.remove(path.size()-1);
        }
    }
}
