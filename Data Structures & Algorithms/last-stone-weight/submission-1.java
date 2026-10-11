class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num:stones){
            pq.add(num);
        }

        while(!pq.isEmpty()&& pq.size()>1){
            int x =pq.poll();
            int y= pq.poll();

            if(x==y){
                continue;
            }

            if(x<y){
                pq.add(y-x);
            }else{
                pq.add(x-y);
            }
        }
    return pq.isEmpty()?0:pq.peek();
    }
}
