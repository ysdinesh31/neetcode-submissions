"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        ans = 0

        intervals = sorted(intervals, key=lambda x:x.start)
        rooms = []
        for i, interval in enumerate(intervals):
            while rooms:
                if rooms[0][0] <= interval.start:
                    heapq.heappop(rooms)
                else:
                    break
            heapq.heappush(rooms, (interval.end, i, interval))
            ans = max(ans, len(rooms))
        
        return ans

