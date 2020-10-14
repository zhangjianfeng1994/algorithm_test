package com.zjf.algorithm.array;

import java.util.*;

/**
 * description: FindSumNumbers <br>
 * date: 2020/10/12 10:24 <br>
 * author: 张建峰 <br>
 */
public class FindSumNumbers {

	/**
	 * 从整型数组中找到所有和为特定值的一对整数,输出它们的下标
	 */
	public static List<List<Integer>> twoSumV2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		List<List<Integer>> resultList = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int other = target - nums[i];
			if (map.containsKey(other)) {
				resultList.add(Arrays.asList(map.get(other), i));
			}
			map.put(nums[i], i);
		}
		return resultList;
	}

	public static List<List<Integer>> threeSumv2(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		//大循环
		for (int i = 0; i < nums.length; i++) {
			int d = target - nums[i];
			// j和k双指针循环定位，j在左端，k在右端
			for (int j=i+1,k=nums.length-1; j<nums.length; j++) {
				// k指针向左移动
				while (j<k && (nums[j]+nums[k])>d) {
					k--;
				}
				//双指针重合，跳出本次循环
				if (j == k) {
					break;
				}
				if (nums[j] + nums[k] == d) {
					List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
					resultList.add(list);
				}
			}
		}
		return resultList;
	}
}
