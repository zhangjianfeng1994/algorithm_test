package com.zjf.algorithm.array;

import java.util.*;

/**
 * description: TestFindSumNumbers <br>
 * date: 2020/9/28 10:26 <br>
 * author: 张建峰 <br>
 */
public class TestFindSumNumbers {

	/**
	 * 从整型数组中找到所有和为特定值的一对整数,输出它们的下标
	*/
	public static List<List<Integer>> twoSum(int[] nums,int target){
		Map<Integer,Integer> map = new HashMap<>();
		List<List<Integer>> resultList = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int num = target - nums[i];
			if (map.containsKey(num)){
				resultList.add(Arrays.asList(map.get(num),i));
			}
			map.put(nums[i],i);
		}
		return resultList;
	}

	public static void main(String[] args) {
		int[] nums = {5,12,6,3,9,2,1,7};
	    List<List<Integer>> resultList = twoSum(nums,13);
		for (List<Integer> list:resultList) {
			System.out.println(Arrays.toString(list.toArray()));
		}
	}
}
