class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
       Arrays.sort(nums);

      dfs(0,nums,res,new ArrayList<>());

      return res;
    }

    public void dfs(int k, int nums[],List<List<Integer>> res,List<Integer> path){
        // if(!res.contains(path)){
        //     res.add(new ArrayList<>(path));
        // }
        res.add(new ArrayList<>(path));
        
        for(int i=k;i<nums.length;i++){

            if (i > k && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            dfs(i+1,nums,res,path);
            path.remove(path.size()-1);
        }
    }
}
