package com.zjf.algorithm.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2021-02-01 15:39  //时间
 */
public class Offer61 {

	/**
	 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
	 *
	 * 示例 1:
	 * 输入: [1,2,3,4,5]
	 * 输出: True
	 *
	 * 示例 2:
	 * 输入: [0,0,1,2,5]
	 * 输出: True
	 */
	/**
	 * 根据题意，此 55 张牌是顺子的 充分条件 如下：
	 *
	 * 除大小王外，所有牌 无重复 ；
	 * 设此 55 张牌中最大的牌为 maxmax ，最小的牌为 minmin （大小王除外），则需满足：
	 * max - min < 5
	 * max−min<5
	 *
	 */
	public boolean isStraight(int[] nums) {
		Set<Integer> repeat = new HashSet<>();
		int max = 0, min = 14;
		for(int num : nums) {
			if(num == 0) {
				continue; // 跳过大小王
			}
			max = Math.max(max, num); // 最大牌
			min = Math.min(min, num); // 最小牌
			if(repeat.contains(num)) {
				return false; // 若有重复，提前返回 false
			}
			repeat.add(num); // 添加此牌至 Set
		}
		return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
	}
}
