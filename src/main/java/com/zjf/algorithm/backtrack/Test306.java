package com.zjf.algorithm.backtrack;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-07-07 21:20  //时间
 */
public class Test306 {


	/**
	 * 累加数是一个字符串，组成它的数字可以形成累加序列。
	 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，
	 * 字符串中的其他数都等于它之前两个数相加的和。
	 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
	 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
	 * 示例 1:
	 * 输入: "112358"
	 * 输出: true
	 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。
	 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
	 * 示例 2:
	 * 输入: "199100199"
	 * 输出: true
	 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
	 * 进阶:
	 * 你如何处理一个溢出的过大的整数输入?
	 * @author ZJF
	 * @date 2020/7/7 21:21
	 */
	public boolean isAdditiveNumber(String num) {
		if (num.length() < 3){
			return  false;
		}
		for (int i = 1; i < num.length(); i++) {
			String str1 = num.substring(0,i);
			if (str1.startsWith("0") && i > 1){
				return false;
			}
			for (int j = i+1; j < num.length(); j++) {
				int num1 = strTonum(str1);
				String str2 = num.substring(i,j);
				if (str2.startsWith("0") && j-i > 1){
					break;
				}
				int num2 = strTonum(str2);
				if (backtrack(num.substring(j),num1,num2)){
					return true;
				}
			}
		}
		return false;
	}

	public boolean backtrack(String num,int num1,int num2){
		if (num.length() == 0){
			return true;
		}
		for (int i = 1; i <= num.length(); i++) {
			String str3 = num.substring(0,i);
			if (str3.startsWith("0") && i > 1){
				return false;
			}
			int sum = strTonum(str3);
			if (num1 +num2 == sum){
				num1 = num2;
				num2 = sum;
				return backtrack(num.substring(i),num1,num2);
			} else if (num1 + num2 < sum) {
				break;
			}
		}
		return false;
	}

	public int strTonum(String str){
		return Integer.parseInt(str);
	}



	public boolean isAdditiveNumber1(String num) {
		return dfs(num, num.length(), 0, 0, 0, 0);
	}

	/**
	 * @param num    原始字符串
	 * @param len    原始字符串长度
	 * @param idx    当前处理下标
	 * @param sum    前面的两个数字之和
	 * @param pre    前一个数字
	 * @param k      当前是处理的第几个数字
	 */
	private boolean dfs(String num, int len, int idx, long sum, long pre, int k) {
		if (idx == len) {
			return k > 2;
		}
		for (int i = idx; i < len; i++) {
			long cur = fetchCurValue(num, idx, i);
			// 剪枝：无效数字
			if (cur < 0) {
				continue;
			}
			// 剪枝：当前数字不等于前面两数之和
			if (k >= 2 && cur != sum) {
				continue;
			}
			if (dfs(num, len, i + 1, pre + cur, cur, k + 1)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取 l ~ r 组成的有效数字
	 */
	private long fetchCurValue(String num, int l, int r) {
		if (l < r && num.charAt(l) == '0') {
			return -1;
		}
		long res = 0;
		while (l <= r) {
			res = res * 10 + num.charAt(l++) - '0';
		}
		return res;
	}



	public static void main(String[] args) {
		Test306 test = new Test306();
		String num = "112358";
		//test.strTonum("9801982396");
		int a = '1'-'0';
		String str = "12333233431211000676";
		System.out.println(test.fetchCurValue(str,0,str.length()-1));
		//System.out.println(test.isAdditiveNumber(num));
	}
}
