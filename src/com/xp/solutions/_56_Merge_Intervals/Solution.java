package com.xp.solutions._56_Merge_Intervals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yukong
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Solution {

    public class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
     }


    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
    public List<Interval> merge(List<Interval> intervals) {

        // 根据x排序
        Collections.sort(intervals, (x,y) -> (x.start - y.start));
        LinkedList<Interval> res = new LinkedList<>();
        for (Interval inerval: intervals
             ) {
            if (res.isEmpty() || res.peekLast().end < inerval.start) {
                res.addLast(inerval);
            } else {
                res.peekLast().end = Math.max(inerval.end, res.peekLast().end );
            }
        }
        return res;
    }


}
