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
		if (s == null || s.length()<4 || s.length() > 12){
			return  res;
		}
		backtrack(s,0,0,new ArrayList<String>());
		return res;
	}
	public void backtrack(String s,int start,int depth,List<String> list){
		if (depth == 4){
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < list.size()-1; i++) {
				stringBuffer.append(list.get(i));
				stringBuffer.append(".");
			}
			stringBuffer.append(list.get(list.size()-1));
			res.add(stringBuffer.toString());
			return;
		}
		for (int i = start; i < s.length(); i++) {
			String str;
			if (depth == 3){
				i = s.length()-1;
			}
			str = s.substring(start, i + 1);
			if (isIpStr(str)){
				list.add(str);
				backtrack(s,i+1,depth+1,list);
				list.remove(list.size()-1);
			}else{
				break;
			}
		}
	}

	public boolean isIpStr(String s){
		if (s.length() > 1 && s.charAt(0) == '0'){
			return false;
		}
		if (s.length() > 3){
			return false;
		}
		if (s.length() == 3){
			int int1 = Integer.parseInt(s);
			if (int1> 255){
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		Test93 test = new Test93();
		String s = "172162541";
		List<String> ss = test.restoreIpAddresses(s);
		//System.out.println(ss.toString());
		//System.out.println(test.isIpStr("216"));
	}

}
