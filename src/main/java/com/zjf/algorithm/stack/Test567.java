package com.zjf.algorithm.stack;

import java.util.HashSet;
import java.util.Set;

/**
 * description: 滑动窗口类
 * date: 2020/6/16 16:44 <br>
 * author: 张建峰 <br>
 */

public class Test567 {
	/*
	 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
		换句话说，第一个字符串的排列之一是第二个字符串的子串。
		示例1:
		输入: s1 = "ab" s2 = "eidbaooo"
		输出: True
		解释: s2 包含 s1 的排列之一 ("ba").
		示例2:
		输入: s1= "abb" s2 = "eadboaoo"
		输出: False
		注意：
		输入的字符串只包含小写字母
		两个字符串的长度都在 [1, 10,000] 之间
	 *
	 *https://blog.csdn.net/assiduous_me/article/details/91358465
	*/



	/**
	 * 为此，我们维护一个 countcount 变量，该变量存储字符数（26个字母表中的数字），
	 * 这些字符在 s1s1 中具有相同的出现频率，当前窗口在 s2s2
	 * 中。当我们滑动窗口时，如果扣除最后一个元素并添加新元素导致任何字符的新频率匹配，
	 * 我们将 countcount 递增1.如果不是，我们保持 countcount
	 * 完整。但是，如果添加频率相同的字符（添加和删除之前）相同的字符，
	 * 现在会导致频率不匹配，这会通过递减相同的 countcount 变量来考虑。如果在移动窗口后，countcount
	 * 的计算结果为26，则表示所有字符的频率完全匹配。所以，我们立即返回一个True。
	 *  s1= "abb" s2 = "eacaoaoo"
	 *
	 */
	public class Solution {

		public boolean checkInclusion(String s1, String s2) {
			if (s1.length() > s2.length()) {
				return false;
			}
			int[] s1map = new int[26];
			int[] s2map = new int[26];
			for (int i = 0; i < s1.length(); i++) {
				s1map[s1.charAt(i) - 'a']++;
				s2map[s2.charAt(i) - 'a']++;
			}
			int count = 0;
			for (int i = 0; i < 26; i++) {
				if (s1map[i] == s2map[i]) {
					count++;
				}
			}
			for (int i = 0; i < s2.length() - s1.length(); i++) {
				int r = s2.charAt(i + s1.length()) - 'a';
				int	l = s2.charAt(i) - 'a';
				if (count == 26) {
					return true;
				}
				s2map[r]++;
				if (s2map[r] == s1map[r]) {
					count++;

				} else if (s2map[r] == s1map[r] + 1) {
					//进入此if:之前的s2map[r] == s1map[r],现在不等于了,所以要--
					count--;
				}
				s2map[l]--;
				if (s2map[l] == s1map[l]) {
					count++;
				} else if (s2map[l] == s1map[l] - 1) {
					count--;
				}
			}
			return count == 26;
		}
	}



}
