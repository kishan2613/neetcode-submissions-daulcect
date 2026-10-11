class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
     List<int[]> list = new ArrayList<>();
     for(int i=0;i<intervals.length;i++){
        list.add(intervals[i]);
     }
    list.sort((a,b)->Integer.compare(a[0],b[0]));
    
     int last[] = list.get(0);
     int count=0;

     for(int i=1;i<list.size();i++){
        int curr[] = list.get(i);

        if(curr[0]<last[1]){
            count++;
            last[1] = Math.min(last[1],curr[1]);
        }else{

            last=curr;
        }
     }
 

     return count;
    }
}
