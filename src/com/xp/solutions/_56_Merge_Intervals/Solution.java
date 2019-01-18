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
 *
 * 解题思路：
 *  根据对象的start 升序排序
 *  遍历对象列表
 *  - 如果当前结果列表最后一个元素end比下一个元素的start小   则把下一个加入到结果列表
 *  - 否则 将当前结果列表中最后一个元素的end赋值 = max(res.get(last()).end, current.end)
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
