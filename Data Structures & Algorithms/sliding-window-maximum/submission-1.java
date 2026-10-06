class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n-k+1];

        int left =0;
       
         PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );
        for(int right=0;right<n;right++){
            pq.add(new int[]{nums[right],right});

            while(pq.peek()[1]<left){
                pq.poll();
            }

            if(right-left+1==k){
                res[right+1-k]=pq.peek()[0];
                left++;
            }
        }
    return res;
    }
}
