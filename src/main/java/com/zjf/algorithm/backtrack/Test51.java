package com.zjf.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test51 {

	/**
	 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
	 *给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
	 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
	 * 示例:
	 * 输入: 4
	 * 输出: [
	 *  [".Q..",  // 解法 1
	 *   "...Q",
	 *   "Q...",
	 *   "..Q."],
	 *
	 *  ["..Q.",  // 解法 2
	 *   "Q...",
	 *   "...Q",
	 *   ".Q.."]
	 *
	 * ]
	 * 解释: 4 皇后问题存在两个不同的解法。
	 * 提示：
	 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。
	 * 当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步，可进可退。
	 * （引用自 百度百科 - 皇后 ）
	 */
	List<List<String>> res;

	public List<List<String>> solveNQueens(int n) {
		if (n <= 0){
			return null;
		}
		res = new ArrayList<>(n);
		char[][] board = new char[n][n];
		for (char[] chars : board) {
			for (int i = 0; i < chars.length; i++) {
				chars[i] = '.';
			}
		}
		dfs(0,board);
		return res;
	}

	public void dfs(int row, char[][] board){
		//在固定行数的下一行写入返回值
		if(row == board.length){
			res.add(charToString(board));
			return;
		}
		int n = board[row].length;
		for (int i = 0; i < n; i++) {
			if (!isValid(board,row,i)){
				continue;
			}
			board[row][i] = 'Q';
			dfs(row+1,board);
			board[row][i] = '.';
		}
	}

	private boolean isValid(char[][] board, int row, int col) {
		int rows = board.length;
		// check is valid in col
		for (char[] chars : board) {
			if (chars[col] == 'Q') {
				return false;
			}
		}
		// check is valide upright
		for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}
		// check is valide upleft
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}
		return true;
	}


	private  List<String> charToString(char[][] array) {
		List<String> result = new ArrayList<>();
		for (char[] chars : array) {
			result.add(String.valueOf(chars));
		}
		return result;
	}






	public static void main(String[] args) {
		Test51 test = new Test51();
		List<List<String>> resl=test.solveNQueens(4);
		for (int i = 0; i < resl.size(); i++) {
			List<String> list = resl.get(i);
			System.out.println(list.toString());
		}
	}
}
