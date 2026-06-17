"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        
        start = sorted([interval.start for interval in intervals])
        end = sorted([interval.end for interval in intervals])
        if len(intervals) == 0:
            return 0

        j = 0
        max_rooms = 1
        rooms = 1

        for i in range(1, len(intervals)):
            if start[i] < end[j]:
                rooms += 1
                max_rooms = max(max_rooms, rooms)
            else:
                j += 1
        
        return max_rooms


