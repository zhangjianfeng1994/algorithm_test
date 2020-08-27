package com.zjf.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-08-28 00:12  //时间
 */
public class TestCouponOptimal {

	List<Integer> res1 = new ArrayList<Integer>();
	public List<Integer> couponOptimal(int[] candidates, int target) {
		if (candidates.length == 0){
			return new ArrayList<>();
		}
		res1.add(0);
		backtrack1(candidates,target,new ArrayList<Integer>(),0,0,false);
		res1.remove(0);
		return res1;
	}

	public  void backtrack1(int[] candidates, int target,
	                        List<Integer> list, int start, int sum, Boolean flag){
		if (sum > target){
			flag = true;
			if (sum-list.get(list.size()-1) > res1.get(0)){
				res1.clear();
				res1.add(sum-list.get(list.size()-1));
				List<Integer> list1 = new ArrayList<>(list);
				list1.remove(list1.size()-1);
				res1.addAll(list1);
			}
			return;
		}
		if (sum == target){
			flag = true;
			res1.clear();
			res1.add(sum);
			List<Integer> list1 = new ArrayList<>(list);
			res1.addAll(list1);
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			int candidate = candidates[i];
			list.add(candidate);
			backtrack1(candidates,target,list,i,sum+candidate,flag);
			if (flag){
				break;
			}
			list.remove(list.size()-1);
		}
	}

	/**
	 * 先从最小的开始试,如果>目标值,记录此次结果然后从第二个数开始试
	 */

	public static void main(String[] args) {
		TestCouponOptimal test = new TestCouponOptimal();
		int[] candidates = {30,50,100};
		int target = 110;
		System.out.println(test.couponOptimal(candidates,target));

	}
}
