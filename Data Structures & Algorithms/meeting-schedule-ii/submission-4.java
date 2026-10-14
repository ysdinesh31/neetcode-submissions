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
        PriorityQueue<Interval> pq = new PriorityQueue<>((Interval a, Interval b) -> a.end - b.end);
        int rooms = 0;
        intervals.sort((Interval a, Interval b) -> a.start - b.start);

        for(int i = 0; i < intervals.size();i++){
            while(!pq.isEmpty()){
                if(intervals.get(i).start >= pq.peek().end) {
                    pq.poll();
                }else{
                    break;
                }
            }
            pq.offer(intervals.get(i));
            rooms = Math.max(rooms, pq.size());
        }

        return rooms;
    }
}
