class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer> set = new HashSet<>();

       for(int i=0;i<nums.length;i++){
        set.add(nums[i]);
       }
        int max=0;
       for(int n:set){
        if(!set.contains(n-1)){
            int curr = n;
            int len=1;

             while (set.contains(curr + 1)) {
                    curr++;
                    len++;
            }

            max = Math.max(max,len);
        }
       }
    return max;
    }
}
