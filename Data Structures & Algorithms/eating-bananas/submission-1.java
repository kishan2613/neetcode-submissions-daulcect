class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=0;

        for(int num:piles){
            right = Math.max(right,num);
        }

        int ans =right;

        while(left<=right){
            int mid = left+(right-left)/2;

            if(canReach(piles,h,mid)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
    return ans;
    }


    public boolean canReach(int[] piles,int h, int k){
        long hours=0;

        for(int w:piles){
            hours += (int)Math.ceil((double)w/k);
        }
    return hours<=h;
    }
}
