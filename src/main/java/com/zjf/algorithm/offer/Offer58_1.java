package com.zjf.algorithm.offer;

/**
 * description: Offer57 <br>
 * date: 2021/1/21 18:52 <br>
 * author: 张建峰 <br>
 */
public class Offer58_1 {

	/**
	 *输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
	 *
	 * 示例 1：
	 *
	 * 输入: "the sky is blue"
	 * 输出: "blue is sky the"
	 * 示例 2：
	 *
	 * 输入: "  hello world!  "
	 * 输出: "world! hello"
	 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
	 * 示例 3：
	 * 输入: "a good   example"
	 * 输出: "example good a"
	 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
	 * 说明：
	 * 无空格字符构成一个单词。
	 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
	 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
	*/
	public String reverseWords(String s) {
		String[] strings = s.trim().split(" ");
		StringBuilder res = new StringBuilder();
		for (int i = strings.length-1; i >=0; i--) {
			String ss = strings[i];
			if(ss.equals("")){
				continue;
			}
			res.append(ss).append(" ");
		}
		//""字符串会造成数组越界
		return res.toString().trim();
	}

	public String reverseWords1(String s) {
		s = s.trim(); // 删除首尾空格
		int j = s.length() - 1, i = j;
		StringBuilder res = new StringBuilder();
		while(i >= 0) {
			while(i >= 0 && s.charAt(i) != ' ') {
				i--; // 搜索首个空格
			}
			res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
			while(i >= 0 && s.charAt(i) == ' ') {
				i--; // 跳过单词间空格
			}
			j = i; // j 指向下个单词的尾字符
		}
		return res.toString().trim(); // 转化为字符串并返回
	}


	public static void main(String[] args) {
		Offer58_1 test = new Offer58_1();
		System.out.println(test.reverseWords("a good   example"));
	}
}
