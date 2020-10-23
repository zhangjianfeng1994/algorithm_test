/**
 * synchronized关键字
 * 对某个对象加锁
 * @author mashibing
 */

package com.zjf.juc.c_001;

public class T {
	
	private int count = 10;
	private Object o = new Object();
	
	public void m() {
		synchronized(o) { //�κ��߳�Ҫִ������Ĵ��룬�������õ�o����
			count--;
			System.out.println(Thread.currentThread().getName() + " count = " + count);
		}
	}
	
}

