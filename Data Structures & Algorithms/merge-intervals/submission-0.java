class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        for(int i=0;i<intervals.length;i++){
            list.add(intervals[i]);
        }

        list.sort((a,b)->Integer.compare(a[0],b[0]));

        int last[] = list.get(0);
        List<int[]> merged = new ArrayList<>();
        for(int i=1;i<list.size();i++){
            int curr [] = list.get(i);

            if(curr[0]<=last[1]){
                last[1] = Math.max(curr[1],last[1]);
            }else{
                merged.add(last);
                last=curr;
            }
        }
         merged.add(last); 
    return merged.toArray(new int[merged.size()][]);
    }
}
