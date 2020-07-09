package com.zjf.algorithm.backtrack;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * description: Test93 <br>
 * date: 2020/7/9 17:25 <br>
 * author: 张建峰 <br>
 */
public class Test93 {
	
	/**
	 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
	 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
	 * 示例:
	 * 输入: "25525511135"
	 * 输出: ["255.255.11.135", "255.255.111.35"]
	 *
	 * author: 张建峰
	*/
	List<String> res = new ArrayList<>();
	public List<String> restoreIpAddresses(String s) {
		if (s == null || s.length()<4){
			return  res;
		}
		backtrack(s,0,0,new ArrayList<String>());
		return res;
	}
	public void backtrack(String s,int start,int depth,List<String> list){
		if (s.length() == start){
			return;
		}
		if (depth == 4){
			String str = StringUtils.join(list, ".");
			res.add(str);
			return;
		}
		for (int i = start; i < s.length(); i++) {
			String str;
			if (depth == 3){
				str = s.substring(start,s.length());
			}else {
				str = s.substring(start, i + 1);
			}
			int ipInt = Integer.parseInt(str);
			if (0 <= ipInt && ipInt <=255){
				list.add(String.valueOf(ipInt));
				backtrack(s,i+1,depth+1,list);
				list.remove(list.size()-1);
			}else{
				break;
			}
		}
	}

	public static void main(String[] args) {
		Test93 test = new Test93();
		String s = "25525511135";
		List<String> ss = test.restoreIpAddresses(s);
		System.out.println(ss.toString());
	}
}
