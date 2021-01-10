package com.zjf.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * description: Offer48 <br>
 * date: 2021/1/4 16:40 <br>
 * author: 张建峰 <br>
 */
public class Offer48 {


	/**
	 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
	 * 示例 1:
	 * 输入: "abcabcbb"
	 * 输出: 3
	 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
	 * 示例 2:
	 * 输入: "bbbbb"
	 * 输出: 1
	 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
	 * 示例 3:
	 * 输入: "pwwkew"
	 * 输出: 3
	 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
	 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
	 * "abba"
	 * // i 1 j =2 char a0 b 2
	 * // j 3 i = 0
	 * 提示：
	 * s.length <= 40000
	*/
	public int lengthOfLongestSubstring(String s) {
		if(s==null || s.length() == 0){
			return 0;
		}
		//记录字符所在的位置下标
		Map<Character,Integer> chars = new HashMap<>();
		int count = 0 ,i = -1;//上一次重复的字符的下标
		//j =2: i =1; chars w:2
		//j = 4 i =1; chars w:2
		//j = 5 w i =2 ; chars:5
		for (int j = 0; j < s.length(); j++) {
			if (chars.containsKey(s.charAt(j))){
				i = Math.max(i,chars.get(s.charAt(j)));
			}
			chars.put(s.charAt(j),j); //更新下标
			count = Math.max(count,j-i);
		}
		return count;
	}


}
