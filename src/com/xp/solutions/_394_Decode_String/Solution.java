package com.xp.solutions._394_Decode_String;

//给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//
// 示例:
//
//
//s = "3[a]2[bc]", 返回 "aaabcbc".
//s = "3[a2[c]]", 返回 "accaccacc".
//s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
//
// Related Topics 栈 深度优先搜索

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yukong
 * @date 2019-09-05 19:21
 */
public class Solution {

	public static String decodeString(String s) {
		StringBuilder res = new StringBuilder();
		Stack<String> chs = new Stack<>();
		int count = 0;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {

			if(chars[i] == '[') {
				count++;
			}else if(chars[i] == ']') {
				count--;
				StringBuilder sb = new StringBuilder();
				String ch = chs.pop();
				while (!isNumericzidai(ch)) {
					sb.append(ch);
					ch = chs.pop();
				}
				Integer total = Integer.valueOf(ch);
				String temp = sb.reverse().toString();
				for (int j = 0; j < total - 1; j++) {
					sb.append(temp);
				}

				if(count > 0) {
					chs.push(sb.toString());
				} else {
					res.append(sb.toString());
				}

			} else {
				chs.push(chars[i] + "");
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!chs.isEmpty()) {
			sb.append(chs.pop());
		}
		return res.append(sb.reverse()).toString();
	}

	public static boolean isNumericzidai(String str) {
		Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
	}
}
