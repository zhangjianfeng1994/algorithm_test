package com.zjf.algorithm.offer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

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


	public int[] printNumbers1(int n) {
		//使用数组来存储大数
		char[] numbers=new char[n];
		Arrays.fill(numbers,'0');
		ArrayList<Integer> res=new ArrayList<>();
		//开始运算
		while(!incrementNumber(numbers)){
			saveNumber(numbers,res);
		}
		//jdk 1.8 stream流将列表转换成数组
		int[] result = res.stream().mapToInt(Integer::valueOf).toArray();
		return result;
	}

	//递增
	public boolean incrementNumber(char[] numbers){
		//结束标识
		boolean isBreak=false;
		//进位标识
		int carryFlag=0;
		int l=numbers.length;
		for(int i=l-1;i>=0;i--){
			//char型转换成int(同时将低位的进位增加)
			int sumArr=numbers[i]-'0'+carryFlag;
			//最低位加1
			if(i==l-1){
				sumArr++;
			}
			//判断是否进位
			if(sumArr>=10){
				//判断是否已经超过最大值
				if(i==0){
					//超出最大值,结束
					isBreak=true;
				}else{
					//未超出最大值,进位,减10
					numbers[i]=(char)(sumArr-10+'0');
					carryFlag=1;
				}
			}else{
				numbers[i]=(char)(sumArr+'0');
				break;
			}
		}
		return isBreak;
	}

	//输出
	public void saveNumber(char[] numbers,ArrayList<Integer> res){
		boolean isBreak=true;
		int temp=0;
		for(int i=0;i<numbers.length;i++){
			if(isBreak && numbers[i]!='0'){
				isBreak=false;
			}
			if(!isBreak){
				//如果是超大值，肯定输出不了
				temp=temp*10+(int)(numbers[i]-'0');
				System.out.println(numbers[i]);
			}
		}
		res.add(temp);
	}

	public static void main(String[] args) {
		Offer17 test = new Offer17();
		//System.out.println(test.printNumbers1(3));

	}

}
