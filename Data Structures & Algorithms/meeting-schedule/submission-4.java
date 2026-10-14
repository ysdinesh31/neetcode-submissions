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
        Collections.sort(intervals, (Interval a, Interval b) -> {
            return (a.start - b.start) == 0? (a.end - b.end):(a.start - b.start);
        });

        for(int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start >= intervals.get(i - 1).end) continue;
            return false;
        }
        return true;
    }
}
