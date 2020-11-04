package com.zjf.algorithm.offer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-11-04 01:20  //时间
 */
public class Offer17 {

	/**
	 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
	 * 示例 1:
	 *
	 * 输入: n = 1
	 * 输出: [1,2,3,4,5,6,7,8,9]
	 *
	 * 说明：
	 * 用返回一个整数列表来代替打印
	 * n 为正整数
	 */
	public int[] printNumbers(int n) {
		int end = (int)Math.pow(10, n) - 1;
		int[] res = new int[end];
		for(int i = 0; i < end; i++) {
			res[i] = i + 1;
		}
		return res;
	}

	/**
	 *1.由于存在大数问题，结果不能放入int数组中，故这里采用剑指offer原题的直接打印输出的模式。
	 * 2.increment函数，若发生进位则一直进行for循环，直到不产生进位则break。
	 * 如果i为0（即到了最高位）还发生了进位，则设置isOverflow为true，并返回至主函数的while判断。
	 *
	 */
	public void printNumbers1(int n) {
		StringBuilder str = new StringBuilder();
		// 将str初始化为n个'0'字符组成的字符串
		for (int i = 0; i < n; i++) {
			str.append('0');
		}
		while(!increment(str)){
			// 去掉左侧的0
			int index = 0;
			while (index < str.length() && str.charAt(index) == '0'){
				index++;
			}
			System.out.println(str.toString().substring(index));
		}
	}

	public boolean increment(StringBuilder str) {
		boolean isOverflow = false;
		for (int i = str.length() - 1; i >= 0; i--) {
			char s = (char)(str.charAt(i) + 1);
			// 如果s大于'9'则发生进位
			if (s > '9') {
				str.replace(i, i + 1, "0");
				if (i == 0) {
					isOverflow = true;
				}
			}
			// 没发生进位则跳出for循环
			else {
				str.replace(i, i + 1, String.valueOf(s));
				break;
			}
		}
		return isOverflow;
	}



	StringBuilder sb;
	int idx = 0;
	public boolean increment(int n){
		boolean carry=false;
		for(int i=0;i<sb.length();++i){
			if(carry || i==0){
				if(sb.charAt(i)=='9'){
					sb.setCharAt(i,'0');
					carry = true;
				}else{
					sb.setCharAt(i,(char) (sb.charAt(i)+1));
					carry = false;
				}
			}else{
				break; // no addition on last idx, no need to compute any more
			}
		}
		if(carry){
			sb.append("1");
		}
		return sb.length()<=n; // overflow!
	}

	public void save(int ans[]){
		ans[idx] = Integer.parseInt(sb.reverse().toString());
		sb.reverse();
	}

	public int[] printNumbers2(int n) {
		int[] ans = new int[(int) Math.pow(10,n) - 1];
		sb = new StringBuilder("0");
		while(increment(n)){
			save(ans);
			idx++;
		}
		return ans;
	}

}
