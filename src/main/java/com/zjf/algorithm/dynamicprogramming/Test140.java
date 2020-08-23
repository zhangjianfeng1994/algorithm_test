package com.zjf.algorithm.dynamicprogramming;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-08-21 22:36  //时间
 */
public class Test140 {

	/**
	 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
	 * 在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。
	 * 返回所有这些可能的句子。
	 *
	 * 说明：
	 * 分隔时可以重复使用字典中的单词。
	 * 你可以假设字典中没有重复的单词。
	 * 示例 1：
	 * 输入:
	 * s = "catsanddog"
	 * wordDict = ["cat", "cats", "and", "sand", "dog"]
	 * 输出:
	 * [
	 *   "cats and dog",
	 *   "cat sand dog"
	 * ]
	 */
	public HashMap<String, Boolean> hash = new HashMap<>();
	public List<String> wordBreak(String s, List<String> wordDict) {
		int len = s.length();
		List<List<String>> dp = new ArrayList<>(len+1);
		for (String wordDictS:wordDict) {
			hash.put(wordDictS,true);
		}
		List<String> dp0 = new ArrayList<>();
		dp0.add("");
		dp.add(0,dp0);
		for (int i = 1; i < len+1; i++) {
			List<String> temp = new ArrayList<>();
			for (int j = i-1; j >=0; j--) {
				if (check(s.substring(j,i)) && dp.get(j).size() > 0){
					if (j==0){
						temp.add(s.substring(j, i));
					}else{
						for (String l:dp.get(j)) {
							temp.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
						}
					}
				}
			}
			dp.add(temp);
		}
		return dp.get(len);
	}

	public Boolean check(String s){
		return hash.getOrDefault(s,false);
	}


	public List<String> wordBreak1(String s, List<String> wordDict) {
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < wordDict.size(); i++) {
			set.add(wordDict.get(i));
		}
		return wordBreakHelper(s, set, new HashMap<String, List<String>>());
	}

	private List<String> wordBreakHelper(String s, HashSet<String> set, HashMap<String, List<String>> map) {
		if (s.length() == 0) {
			return new ArrayList<>();
		}
		if (map.containsKey(s)) {
			return map.get(s);
		}
		List<String> res = new ArrayList<>();
		for (int j = 0; j < s.length(); j++) {
			//判断当前字符串是否存在
			if (set.contains(s.substring(j, s.length()))) {
				//空串的情况，直接加入
				if (j == 0) {
					res.add(s.substring(j, s.length()));
				} else {
					//递归得到剩余字符串的所有组成可能，
					// 然后和当前字符串分别用空格连起来加到结果中
					List<String> temp = wordBreakHelper(s.substring(0, j), set, map);
					for (int k = 0; k < temp.size(); k++) {
						String t = temp.get(k);
						res.add(t + " " + s.substring(j, s.length()));
					}
				}

			}
		}
		//缓存结果
		map.put(s, res);
		return res;
	}

	public static void main(String[] args) {
		Test140 test= new Test140();
		List<String> wordDict = Lists.newArrayList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		//System.out.println(test.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",wordDict));
		System.out.println(test.wordBreak1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",wordDict));
	}
}
