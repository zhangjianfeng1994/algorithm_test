package com.zjf.algorithm.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * description: Offer50 <br>
 * date: 2021/1/4 17:09 <br>
 * author: 张建峰 <br>
 */
public class Offer50 {

	/**
	 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
	 * s 只包含小写字母。
	 *
	 * 示例:
	 *
	 * s = "abaccdeff"
	 * 返回 "b"
	 *
	 * s = ""
	 * 返回 " "
	 *
	*/
	public char firstUniqChar(String s) {
		Map<Character,Boolean> chars = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			chars.put(s.charAt(i),!chars.containsKey(s.charAt(i)));
		}
		for (Map.Entry<Character,Boolean> entry:chars.entrySet()) {
			if (entry.getValue()){
				return entry.getKey();
			}
		}
		return ' ' ;
	}
	public char firstUniqChar1(String s) {
		int[] chars = new int[26];
		int len = s.length();
		for (int i = 0; i < len; i++) {
			chars[s.charAt(i)-'a']++;
		}
		for (int i = 0; i < len; i++) {
			if (chars[s.charAt(i)-'a'] ==1){
				return s.charAt(i);
			}
		}
		return ' ' ;
	}
}
