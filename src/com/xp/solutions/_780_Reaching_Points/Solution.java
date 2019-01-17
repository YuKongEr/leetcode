package com.xp.solutions._780_Reaching_Points;

/**
 * @author yukong
 * 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
 *
 * 给定一个起点 (sx, sy) 和一个终点 (tx, ty)，如果通过一系列的转换可以从起点到达终点，则返回 True ，否则返回 False。
 *
 * 示例:
 * 输入: sx = 1, sy = 1, tx = 3, ty = 5
 * 输出: True
 * 解释:
 * 可以通过以下一系列转换从起点转换到终点：
 * (1, 1) -> (1, 2)
 * (1, 2) -> (3, 2)
 * (3, 2) -> (3, 5)
 *
 * 输入: sx = 1, sy = 1, tx = 2, ty = 2
 * 输出: False
 *
 * 输入: sx = 1, sy = 1, tx = 1, ty = 1
 * 输出: True
 *
 * 注意:
 *
 * sx, sy, tx, ty 是范围在 [1, 10^9] 的整数。
 *
 * 解题思路
 * 由于本题按照题目给的思路正向一步一步走下去会存在多种情况，我们可以逆向推导。反推起点，因为这样只存在两种种情况。
 *
 * if : tx > ty then : tx = tx % ty
 * if : ty > tx then : ty = ty % tx
 */
public class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx > sx && ty > sy) {
            if (tx > ty) {
                tx = tx % ty;
            } else {
                ty = ty % tx;
            }
        }
        if (tx == sx) {
            return  (ty - sy)   % tx == 0;
        } else if(ty == sy) {
            return (tx  - sx) % ty  == 0;
        } else {
            return false;
        }

    }
}
