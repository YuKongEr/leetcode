package com.xp.solutions;

import javafx.util.Pair;

import java.util.*;

/**
 * @author yukong
 * @date 2020/4/1 22:00
 */
public class ZzTest {



    private void reslove(Integer[] hp, Pair<Integer, Integer>[] damage) {
        Arrays.sort(hp, Collections.reverseOrder());
        Arrays.sort(damage, (o1, o2) -> o2.getValue().compareTo(o1.getKey()));
        int costs = 0;
        int n = hp.length;
        int m = damage.length;
        int damageIndex = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            while (damageIndex < m && damage[damageIndex].getKey() >= hp[i]) {
                queue.add(damage[damageIndex++].getValue());
            }
            if (queue.isEmpty()) {
                System.out.println("NO");
                break;
            }
            costs += queue.poll();
        }
        System.out.println("consts = " + costs);
    }


    private static void reverse(String num) {
        char[] chs = num.toCharArray();
        int p = 0, q = 0;
        int res = 0;
        while (p < chs.length - 1) {
            while (p < chs.length && chs[p] == '0') {
                p++;
            }
            if((p + 1) < chs.length) {
                doReverse(chs, p );
                res++;
            } else {
                break;
            }
        }
        if(p == chs.length - 1) {
            System.out.println("no");
        } else {
            System.out.println(res);
        }
    }

    private static void doReverse(char[] chs,int begin) {
        int i = 0;
        while (begin < chs.length && i <  3) {
            if(chs[begin] == '0') {
                chs[begin] = '1';
            } else {
                chs[begin] = '0';
            }
            begin++;
            i++;
        }
    }

    public static void main(String[] args) {
        reverse("00001000 ");
        reverse("00001000");
        reverse("00001001");
    }


}
