package com.zjf.algorithm.offer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-11-04 01:38  //时间
 */
public class Offer20 {

	/**
	 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
	 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
	 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
	 *
	 *  
	 *
	 */
	public boolean isNumber(String s) {
		if(s == null || s.length() == 0) {
			return false; // s为空对象或 s长度为0(空字符串)时, 不能表示数值
		}
		boolean isNum = false, isDot = false, ise_or_E = false; // 标记是否遇到数位、小数点、‘e’或'E'
		char[] str = s.trim().toCharArray();  // 删除字符串头尾的空格，转为字符数组，方便遍历判断每个字符
		for(int i=0; i<str.length; i++) {
			if(str[i] >= '0' && str[i] <= '9') {
				isNum = true; // 判断当前字符是否为 0~9 的数位
			} else if(str[i] == '.') { // 遇到小数点
				// 小数点之前可以没有整数，但是不能重复出现小数点、或出现‘e’、'E'
				if(isDot || ise_or_E) {
					return false;
				}
				// 标记已经遇到小数点
				isDot = true;
			}
			else if(str[i] == 'e' || str[i] == 'E') { // 遇到‘e’或'E'
				if(!isNum || ise_or_E) {
					return false; // ‘e’或'E'前面必须有整数，且前面不能重复出现‘e’或'E'
				}
				ise_or_E = true; // 标记已经遇到‘e’或'E'
				isNum = false; // 重置isNum，因为‘e’或'E'之后也必须接上整数，防止出现 123e或者123e+的非法情况
			}
			else if(str[i] == '-' ||str[i] == '+') {
				if(i!=0 && str[i-1] != 'e' && str[i-1] != 'E') {
					return false; // 正负号只可能出现在第一个位置，或者出现在‘e’或'E'的后面一个位置
				}
			}
			else {
				return false; // 其它情况均为不合法字符
			}
		}
		return isNum;
	}
}
