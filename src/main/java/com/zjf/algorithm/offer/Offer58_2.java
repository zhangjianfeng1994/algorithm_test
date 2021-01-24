package com.zjf.algorithm.offer;

/**
 * description: Offer57_2 <br>
 * date: 2021/1/21 19:03 <br>
 * author: 张建峰 <br>
 */
public class Offer58_2 {

	/**
	 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
	 * 示例 1：
	 * 输入: s = "abcdefg", k = 2
	 * 输出: "cdefgab"
	 * 示例 2：
	 * 输入: s = "lrloseumgh", k = 6
	 * 输出: "umghlrlose"
	*/
	public String reverseLeftWords(String s, int n) {
		if(n == 0){
			return s;
		}
		int len = s.length();
		int k = n%len; //要左旋的字段长度
		String left = s.substring(0,k);
		String right = s.substring(k);
		return right+left;
	}

	public static void main(String[] args) {
		Offer58_2 test = new Offer58_2();
		System.out.println(test.reverseLeftWords("lrloseumgh",6));
	}
}
