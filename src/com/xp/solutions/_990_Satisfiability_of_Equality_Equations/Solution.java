package com.xp.solutions._990_Satisfiability_of_Equality_Equations;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author yukong
 * @date 2020/6/8 20:34
 */
public class Solution {

    Map<Character, Character> um = new HashMap<>();

    private Character find(Character data) {
        Character p = data;
        while (!p.equals(um.get(p)) && um.get(p) != null) {
            p = um.get(p);
        }
        Character q = data;
        // 压缩路径
        while (!q.equals(um.get(q)) && um.get(q) != null) {
            Character tmp = q;
            q = um.get(q);
            um.put(tmp, p);
        }
        return p;
    }

    private void union(Character c1, Character c2) {
        char p1 = find(c1);
        char p2 = find(c2);

        if (p1 != p2) {
            um.put(p1, p2);
        }
    }

    public boolean equationsPossible(String[] equations) {
        for (String equation : equations) {
            char c1 = equation.charAt(0);
            char c2 = equation.charAt(3);
            if (equation.contains("==")) {
                union(c1, c2);
            }
        }
        for (String equation : equations) {
            char c1 = equation.charAt(0);
            char c2 = equation.charAt(3);
            if (equation.contains("!=")) {
                char p1 = find(c1);
                char p2 = find(c2);
                if (p1 == p2) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().equationsPossible(new String[]{"a==b", "b!=a"}));
        System.out.println(new Solution().equationsPossible(new String[]{"b==a", "a==b"}));
        System.out.println(new Solution().equationsPossible(new String[]{"a==b", "b==c", "a==c"}));
        System.out.println(new Solution().equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));
        System.out.println(new Solution().equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));
        System.out.println(new Solution().equationsPossible(new String[]{"c!=c"}));
        System.out.println(new Solution().equationsPossible(new String[]{"d!=f", "f==e", "a==b", "a==c"}));
    }
}
