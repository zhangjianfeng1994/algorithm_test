package com.zjf.algorithm.dynamicprogramming;

import java.util.HashMap;
import java.util.List;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-08-19 22:59  //时间
 */
public class Test139 {

	/**
	 *给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
	 *
	 * 说明：
	 * 拆分时可以重复使用字典中的单词。
	 * 你可以假设字典中没有重复的单词。
	 * 示例 1：
	 * 输入: s = "leetcode", wordDict = ["leet", "code"]
	 * 输出: true
	 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
	 * 示例 2：
	 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
	 * 输出: true
	 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
	 *      注意你可以重复使用字典中的单词。
	 * 示例 3：
	 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
	 * 输出: false
	 */
	public HashMap<String, Boolean> hash = new HashMap<>();
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp=new boolean[s.length()+1];
		//方便check，构建一个哈希表
		for(String word : wordDict){
			hash.put(word, true);
		}
		//初始化
		dp[0] = true;

		for (int i = 1; i <dp.length ; i++) {
			for (int j = i-1; j >=0 ; j--) {
				dp[i] = dp[j]&& check(s.substring(j, i));
				if(dp[i]){
					break;
				}
			}
		}
		return dp[s.length()];
	}

	public boolean check(String s){
		return hash.getOrDefault(s, false);
	}


}
