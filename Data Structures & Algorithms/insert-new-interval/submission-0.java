class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]>temp = new ArrayList<>();
        
        
        for(int i=0;i<intervals.length;i++){
           temp.add(intervals[i]);
        }
         temp.add(newInterval);
         temp.sort((a,b)->Integer.compare(a[0],b[0]));

         List<int[]> merged = new ArrayList<>();
        int last[] = temp.get(0);

        for(int i=1;i<temp.size();i++){
            int curr[] = temp.get(i);

            if(curr[0]<=last[1]){
                last[1] = Math.max(last[1],curr[1]);
            }else{
                merged.add(last);
                last = curr;
            }
        }
        merged.add(last); 
    return merged.toArray(new int[merged.size()][]);
    }
}


//
// 1-3 2-5 4-6
//  3-4 5-6 7-8 (1-2)
// (1-2) 