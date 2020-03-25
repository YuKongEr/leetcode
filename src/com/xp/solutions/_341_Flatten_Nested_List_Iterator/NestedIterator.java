package com.xp.solutions._341_Flatten_Nested_List_Iterator;

import java.util.*;

/**
 * 341. 扁平化嵌套列表迭代器 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * <p>
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],2,[1,1]] 输出: [1,1,2,1,1] 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 示例 2:
 * <p>
 * 输入: [1,[4,[6]]] 输出: [1,4,6] 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 *
 * @author yukong
 * @date 2020/3/25 21:18
 */
public class NestedIterator implements Iterator<Integer> {

    /**
     * dfs 深度优先遍历
     */
    private Queue<Integer> res;

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        res = new LinkedList<>();
        for (NestedInteger node : nestedList) {
            dfs(node);
        }
    }

    private void dfs(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            res.add(nestedInteger.getInteger());
        }
        for (NestedInteger node : nestedInteger.getList()) {
            dfs(node);
        }
    }

    @Override
    public Integer next() {
        return res.poll();
    }


    @Override
    public boolean hasNext() {
        return !res.isEmpty();
    }
}
