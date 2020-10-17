package com.zjf.algorithm.offer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-10-15 23:19  //时间
 */
public class Offer05 {
	
	/**
	 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
	 * 示例 1：
	 * 输入：s = "We are happy."
	 * 输出："We%20are%20happy."
	 * 限制：
	 * 0 <= s 的长度 <= 10000
	 */
	public String replaceSpace(String s) {
		return s.replaceAll(" ","%20");
	}

	public String replaceSpace1(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			 char c = s.charAt(i);
			 if (c == ' '){
				 sb.append("%20");
			 }else {
				 sb.append(c);
			 }
		}
		return sb.toString();
	}

	public String replaceSpace2(String s) {
		int length = s.length();
		char[] array = new char[length * 3];
		int size = 0;
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				array[size++] = '%';
				array[size++] = '2';
				array[size++] = '0';
			} else {
				array[size++] = c;
			}
		}
		String newStr = new String(array, 0, size);
		return newStr;
	}


	public static void main(String[] args) {
		Offer05 test = new Offer05();
		System.out.println(test.replaceSpace1("We are happy."));
	}
}
