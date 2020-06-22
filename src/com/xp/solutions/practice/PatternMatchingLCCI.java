package com.xp.solutions.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yukong
 * @date 2020/6/22 22:18
 */
public class PatternMatchingLCCI {
    // lp = ca * la + cb + lb
    public boolean patternMatching(String pattern, String value) {
        // 原串为空
        if (value.length() == 0) {
            // 判断pattern 是不是 只有0个或者1个a 如果存在ab模式 则直接返回false
            if (pattern.length() > 0) {
                char a = pattern.charAt(0);
                for (int i = 0; i < pattern.length(); i++) {
                    if (pattern.charAt(i) != a) {
                        return false;
                    }
                }
            } else {
                return true;
            }
        }
        // 如果原串不为空 模式串为 直接返回false
        if (pattern.length() == 0) {
            return false;
        }
        int lp = value.length();
        int la = 0, ca = 0;
        ;
        int lb = 0, cb = 0;
        char a = pattern.charAt(0);
        // 计算ca cb个数
        for (char x : pattern.toCharArray()) {
            if (x == a) {
                ca++;
            } else {
                cb++;
            }
        }
        if (cb == 0) {
            // 满足 ca * la = lp
            if (lp % ca != 0) {
                return false;
            }
            la = lp / ca;

            String aa = value.substring(0, la);
            for (int i = la; i < lp; i += la) {
                if (!aa.equals(value.substring(i, i + la))) {
                    return false;
                }
            }
            return true;
            // 判断
        } else {
            // 枚举所有长度的la, lb = (lp - (la * ca)) / cb
            for (la = 0; la * ca <= lp; la++) {
                // 剩余长度
                int rest = lp - (la * ca);
                if (rest % cb != 0) {
                    continue;
                }
                lb = rest / cb;
                String aa = "";
                String bb = "";
                boolean isMatched = true;
                int idx = 0;
                // 根据枚举的la 验证模式串是否匹配
                for (char x : pattern.toCharArray()) {
                    if (x == a) {
                        String currentA = value.substring(idx, idx + la);
                        idx = idx + la;
                        if (aa.length() == 0) {
                            aa = currentA;
                        }
                        // 不匹配直接返回false
                        if (!aa.equals(currentA)) {
                            isMatched = false;
                            break;
                        }
                    } else {
                        String currentB = value.substring(idx, idx + lb);
                        idx = idx + lb;
                        if (bb.length() == 0) {
                            bb = currentB;
                        }
                        // 不匹配直接返回false
                        if (!bb.equals(currentB)) {
                            isMatched = false;
                            break;
                        }
                    }
                }
                if (isMatched && !aa.equals(bb)) {
                    return true;
                }
            }
            return false;
        }
    }

    private final Map<Character, String> patternMap = new HashMap<>();

    // 回溯算法
    public boolean patternMatching1(String pattern, String value) {
        patternMap.put('a', "*");
        patternMap.put('b', "*");
        return isMatched(pattern, 0, value, 0);
    }

    private boolean isMatched(String pattern, int pIndex, String value, int vIndex) {
        // 出口条件
        if (pattern.length() == pIndex && value.length() == vIndex) {
            return true;
        }
        if (pIndex >= pattern.length() || vIndex > value.length()) {
            return false;
        }
        char ch = pattern.charAt(pIndex);
        String aa = patternMap.get(ch);
        if ("*".equals(aa)) {
            // 匹配所有可能的a
            for (int i = vIndex; i <= value.length(); i++) {
                String currentA = value.substring(vIndex, i);
                patternMap.put(ch, currentA);
                if (!patternMap.get('a').equals(patternMap.get('b')) && isMatched(pattern, pIndex + 1, value, i)) {
                    return true;
                }
            }
            // 如果不匹配 回溯
            patternMap.put(ch, "*");
            return false;
        } else {
            //若此前a或b已有对应的字符串匹配了，则查看当前位置时候能够匹配上。
            int end=vIndex+aa.length();
            if(end> value.length()||!value.substring(vIndex,end).equals(aa)) {
                return false;
            }
            return isMatched(pattern, pIndex + 1,value,end);
        }
    }

    public static void main(String[] args) {
        System.out.println(new PatternMatchingLCCI().patternMatching1("a",
                ""));
    }
}
