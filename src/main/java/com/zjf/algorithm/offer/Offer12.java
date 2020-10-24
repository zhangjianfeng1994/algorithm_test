package com.zjf.algorithm.offer;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;

/**
 * description: Offer12 <br>
 * date: 2020/10/23 17:55 <br>
 * author: 张建峰 <br>
 */
public class Offer12 {

	/**
	 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
	 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
	 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
	 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
	 *
	 * [["a","b","c","e"],
	 * ["s","f","c","s"],
	 * ["a","d","e","e"]]
	 *
	 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
	 *
	  * 示例 1：
	 *
	 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
	 * 输出：true
	 * 示例 2：
	 *
	 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
	 * 输出：false
	 * 提示:
	 * 1 <= board.length <= 200
	 * 1 <= board[i].length <= 200
	 *
	 */

	int[][] next = {{0,1},{1,0},{0,-1},{-1,0}};
	char[][] board;
	int m,n;
	char[] words;
	boolean[][] mark; //标记已经走过位置,不能再次走该位置
	public boolean exist(char[][] board, String word) {
		this.m = board.length;
		this.n = board[0].length;
		this.board = board;
		this.words = word.toCharArray();
		mark = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(dfs(0,i,j)){
					return true;
				}
			}
		}
		return false;
	}

	private Boolean dfs(int pos, int m1, int n1) {
		if (m1 < 0 || m1 >= m || n1 < 0 || n1 >= n || mark[m1][n1]){
			return false;
		}
		if (board[m1][n1] != words[pos]){
			return false;
		}
		if (pos == words.length-1){
			return true;
		}
		mark[m1][n1] = true;
		for (int[] ints:next) {
			if(dfs(pos+1,m1+ints[0],n1+ints[1])){
				return true;
			}
		}
		mark[m1][n1] = false;
		return false;
	}

	public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
		};
		Offer12 test = new Offer12();
		String word = "ABCCED";
		System.out.println(test.exist(board,word));
	}
}
