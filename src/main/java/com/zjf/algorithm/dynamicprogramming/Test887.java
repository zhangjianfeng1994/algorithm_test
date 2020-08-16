package com.zjf.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-08-13 00:51  //时间
 */
public class Test887 {

	/**
	 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
	 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
	 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
	 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
	 * 你的目标是确切地知道 F 的值是多少。
	 * int[][][]  楼层 鸡蛋个数  碎不碎
	 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
	 * 示例 1：
	 * 输入：K = 1, N = 2
	 * 输出：2
	 * 解释：
	 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
	 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
	 * 如果它没碎，那么我们肯定知道 F = 2 。
	 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
	 * 示例 2：
	 * 输入：K = 2, N = 6
	 * 输出：3    2层1个鸡蛋 2
	 *  第一次3层,碎了取基础值;没碎, 5 然后碎没碎  4 5 6 2
	 * 示例 3：
	 * 输入：K = 3, N = 14
	 * 输出：4
	 *  1:7  碎了: 6层2个鸡蛋:3 ; 没碎:  3 2  8 9 10  11  12 13 14  3 3   7 3
	 *   6 8    5 9
	 *   f(K,N) = min(res,max(f(K-1,X-1), f(k,N-X)) + 1)
	 *
	 *   第一步: 移动到X层   次数1
	 *   第二: 碎了  k-1 x-1层; 10 次数
	 *   第三  n-x k 层 5次数 确定F值
	 *    n-x k 层
	 *    第一步: 移动到X层   次数1
	 * 	 *   第二: 碎了  k-1 x-1层;
	 * 	 *   第三  n-x k 层
	 *
	 */
	public int superEggDrop(int K, int N) {

		if (K==1 || N <=2){
			return N;
		}
		//k个鸡蛋n层楼的最小移动次数
		int[][] dp = new int[K][N+1];
		for (int i = 1; i < K; i++) {
			for (int j = 3; j < N+1; j++) {
				dp[i][j] = j;
			}
		}
		//初始化 N=2 N=1的初始值是0 1 2
		for (int i = 1; i < K; i++) {
			dp[i][0]  = 0;
			dp[i][1]  = 1;
			dp[i][2]  = 2;
		}
		//初始化鸡蛋 k=1的初始值是n
		for (int i = 0; i < N+1; i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i < K; i++) {
			for (int j = 3; j < N+1; j++) {
				//int a = Integer.MAX_VALUE;
				/*for (int x = j; x >= 1; x--) {
					int b = dp[i-1][x-1],c = dp[i][j-x];
					int d = Math.max(b, c) + 1;
					//a = Math.max(d, a);
					if (a>d){
						a= d;
						System.out.println(j+":第一次第几层:"+x);
					}
				}*/
				// 在区间 [1, j] 里确定一个最优值
				int left = 1;
				int right = j;
				while (left < right) {
					// 找 dp[k - 1][j - 1] <= dp[i - mid][j] 的最大值 k
					int mid = left + (right - left + 1) / 2;

					int breakCount = dp[i-1][mid-1];
					int notBreakCount = dp[i][j-mid];
					if (breakCount > notBreakCount) {
						// 排除法（减治思想）写对二分见第 35 题，先想什么时候不是解
						// 严格大于的时候一定不是解，此时 mid 一定不是解
						// 下一轮搜索区间是 [left, mid - 1]
						right = mid - 1;
					} else {
						// 这个区间一定是上一个区间的反面，即 [mid, right]
						// 注意这个时候取中间数要上取整，int mid = left + (right - left + 1) / 2;
						left = mid;
					}
				}
				dp[i][j] = Math.max(dp[i-1][left-1],dp[i][j-left])+1;
			}
		}
		return  dp[K-1][N];
	}

	public static void main(String[] args) {
		Test887 test = new Test887();
		System.out.println(test.superEggDrop(2,100));
		//14层  13 1  13+1   86层 2鸡蛋
	}
}
