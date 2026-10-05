class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if(nums.length==0)return 0;
    

        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        int prev= pq.poll();
        int len=1;
        int max=1;
        while(!pq.isEmpty()){
            int n = pq.poll();
            if(prev==n){
                continue;
            }
            if(prev+1==n){
                len++;  
            }else{
                len=1;
            }
            max =  Math.max(max,len);
            prev=n;
        }
    return max;
    }
}
