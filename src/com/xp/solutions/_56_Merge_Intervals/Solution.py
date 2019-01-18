# Definition for an interval.
class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e


class Solution:
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        intervals.sort(key=lambda x : x.start)
        res = []
        for interval in intervals:
            if len(res) <= 0 or res[len(res)-1].end < interval.start:
                res.append(interval)
            else:
                res[len(res)-1].end  = max(res[len(res)-1].end, interval.end)
        return res
