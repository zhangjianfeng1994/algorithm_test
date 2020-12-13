package com.zjf.algorithm.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-12-02 23:57  //时间
 */
public class Offer38 {


	/**
	 * 输入一个字符串，打印出该字符串中字符的所有排列。
	 *
	 *  
	 *
	 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
	 *
	 *  
	 *
	 * 示例:
	 *
	 * 输入：s = "abc"
	 * 输出：["abc","acb","bac","bca","cab","cba"]
	 *  
	 *
	 * 限制：
	 *
	 * 1 <= s 的长度 <= 8
	 *
	 */
	List<String> res;
	public String[] permutation(String s) {
		if (s == null){
			return null;
		}
		if (s.equals("")){
			return new String[]{""};
		}
		if (s.length()==1){
			return new String[]{s};
		}
		res = new ArrayList<String>();
		dfs(s.toCharArray(),0,s.length()-1);
		return res.toArray(new String[]{});
	}

	private void dfs(char[] chars, int l, int r) {
		if (l == r){
			//保存结果
			String resS = new String(chars);
			res.add(resS);

		}
		Set<Character> set = new HashSet<>();//判断重复
		for (int i = l; i <=r; i++) {
			if (set.contains(chars[i])){
				continue;
			}
			set.add(chars[i]);
			swap(chars,i,l);
			dfs(chars,l+1,r);
			swap(chars,i,l);
		}
	}

	private void swap(char[] chars, int l, int r) {
		if (r == l){
			return ;
		}
		char temp = chars[l];
		chars[l] = chars[r];
		chars[r] = temp;
	}


}
