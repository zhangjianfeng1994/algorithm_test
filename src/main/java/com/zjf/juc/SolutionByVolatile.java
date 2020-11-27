package com.zjf.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * description: SolutionByVolatile <br>
 * date: 2020/11/26 11:08 <br>
 * author: 张建峰 <br>
 */
public class SolutionByVolatile {

	/**
	 * 两个线程交互打印输出A1B2C3D4E5F6G7...23X24Y25Z26
	*/
	public static void main(String[] args) throws Exception {
		SolutionByVolatile solution = new SolutionByVolatile();
		Thread t1 = new Thread(solution::printCharsByVolatile);
		Thread t2 = new Thread(solution::printNumsByVolatile);
		t1.start();
		t2.start();
	}
	volatile boolean flag = true;
	public void printCharsByVolatile() {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < str.length(); i++) {
			while (!flag){}
			System.out.print(str.charAt(i));
			flag = false;
		}
	}
	public void printNumsByVolatile() {
		for (int i = 0; i < 26; i++) {
			while (flag) {}
			System.out.print(i+1);
			flag = true;
		}
	}


	//使用java提供的CAS锁实现
	AtomicInteger flag1 = new AtomicInteger(1);
	public void printCharsByCAS() {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < str.length(); i++) {
			while (flag1.get()!=1){}
			System.out.print(str.charAt(i));
			flag1.set(0);
		}
	}
	public void printNumsByCAS() {
		for (int i = 0; i < 26; i++) {
			while (flag1.get()==1) {}
			System.out.print(i+1);
			flag1.set(1);
		}
	}


}
