/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        intervals.sort((a,b)->Integer.compare(a.start,b.start));
        if (intervals.isEmpty()) {
            return true;
        }

        Interval last = intervals.get(0);

        for(int i=1;i<intervals.size();i++){
            Interval curr = intervals.get(i);
            if(last.end>curr.start){
                return false;
            }else{
                last=curr;
            }
        }
    return true;
    }
}
