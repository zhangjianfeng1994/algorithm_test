package com.zjf.algorithm.offer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-12-30 00:17  //时间
 */
public class Offer46 {

	/**
	 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11
	 * 翻译成 “l”，……，25 翻译成
	 * “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
	 *
	 * 示例 1:
	 * 输入: 12258
	 * 输出: 5
	 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
	 * 提示：
	 * 0 <= num < 231
	 */
	public int translateNum(int num) {
		if (num == 0){
			return  1;
		}
		String numStr = String.valueOf(num);
		int[] dp = new int[numStr.length()+1];
		dp[0] = 1; //代表""
		dp[1] = 1; //代表第一位
		for (int i = 2; i < dp.length; i++) {
			String pre = numStr.substring(i - 2, i);
			if (pre.compareTo("10")>=0 && pre.compareTo("25")<=0){
				dp[i] = dp[i-2]+dp[i-1];
			}else {
				dp[i] = dp[i-1];
			}

		}
		return dp[numStr.length()];
	}

	public int translateNum1(int num) {
		String s = String.valueOf(num);
		int a = 1, b = 1; //a:dp[n-1] b:dp[n-2]
		for(int i = 2; i <= s.length(); i++) {
			String tmp = s.substring(i - 2, i);
			int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
			b = a;
			a = c;
		}
		return a;
	}

	/**
	 * 递归
	 */
	public int translateNum2(int num) {
		String s = String.valueOf(num);
		return backtrack(s, 0);
	}

	public int backtrack(String s, int idx){
		int n = s.length();
		if(idx == n) {
			return 1;
		}
		if(idx == n - 1 || s.substring(idx,idx+1).equals("0")
				|| s.substring(idx, idx+2).compareTo("25") >0) {
			return backtrack(s, idx + 1);
		}

		return backtrack(s, idx + 1) + backtrack(s, idx + 2);
	}


	public static void main(String[] args) {
		Offer46 test = new Offer46();
		System.out.println(test.translateNum2(12258));
	}




}
