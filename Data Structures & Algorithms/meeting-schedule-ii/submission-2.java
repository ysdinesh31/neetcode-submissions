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
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (Interval a, Interval b)->{
            return a.start - b.start;
        });

        PriorityQueue<Interval> rooms = new PriorityQueue<>((Interval a, Interval b)->{
            return a.end - b.end;
        });

        int ans = 0;

        for(int i = 0; i < intervals.size(); i++){
            if(rooms.size() == 0){
                rooms.offer(intervals.get(i));
            }else{
                while(rooms.size() > 0 && rooms.peek().end <= intervals.get(i).start){
                    rooms.poll();
                }
                rooms.offer(intervals.get(i));
            }
            ans = Math.max(ans, rooms.size());
        }

        return ans;
    }
}
