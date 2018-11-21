package com.xp.solutions._796_Rotate_String;

/**
 * 给定两个字符串, A 和 B。
 *
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 *
 * 示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 *
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 * 注意：
 *
 * A 和 B 长度不超过 100。
 * @author: yukong
 * @date: 2018/11/21 16:03
 */
public class Solution {
    public boolean rotateString(String A, String B) {
        if(A.equals(B)){
            return true;

        }
        char []a=A.toCharArray();
        char []b=B.toCharArray();
        int len=b.length;
        if(a.length != b.length)
        {
            return false;

        }
        for(int i=0;i<len;i++) {
            //寻找与B首字母匹配的位置
            if(a[i]==b[0]) {
                //A坐标为offset 以offset为分割线，搜索字符数组a的右半段[offset+1,len)
                int offset=i;
                int p=1,q;
                for(q=offset+1;q<len;q++,p++) {
                    if(a[q]!=b[p]){
                        break;//匹配不成功跳出

                    }
                }
                //offset 右半段匹配成功 匹配左半段[0,offset)
                if(q==len) {
                    for(int l=0;l<offset;l++,p++) {
                        if(a[l]!=b[p]){
                            break;

                        }
                    }
                    if(p>=len){
                        return true;

                    }
                }
            }
        }
        return false;
    }
}
