package com.zjf.algorithm.backtrack;

import java.util.*;

public class Test51_1 {

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
	 * ]
	 * 解释: 4 皇后问题存在两个不同的解法。
	 * 提示：
	 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。
	 * 当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步，可进可退。
	 * （引用自 百度百科 - 皇后 ）
	 */
	/**
	 * 优化isValid的查询，通过3个set来分别记录列、主对角线、副对角线上Q的情况，减少迭代的查询
	 * Key值：colIndex, [r-c], [r + c] 作为set的key
	 */
	private List<List<String>> res = new LinkedList<>();
	private Set<Integer> colSet = new HashSet<>();
	//主对角线
	private Set<Integer> masterSet = new HashSet<>();
	//副对角线
	private Set<Integer> slaveSet = new HashSet<>();

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
			updateRecords(board, row, i);
			dfs(row+1,board);
			updateRecords(board, row, i);
		}
	}
	private void updateRecords(char[][] board, int row, int col) {
		if (colSet.contains(col)) {
			board[row][col] = '.';
			colSet.remove(col);
			masterSet.remove(row - col);
			slaveSet.remove(row + col);
		} else {
			board[row][col] = 'Q';
			colSet.add(col);
			masterSet.add(row - col);
			slaveSet.add(row + col);
		}
	}

	private boolean isValid(char[][] board, int row, int col) {
		return !colSet.contains(col)
				&& !masterSet.contains(row - col)
				&& !slaveSet.contains(row + col);
	}


	private  List<String> charToString(char[][] array) {
		List<String> result = new ArrayList<>();
		for (char[] chars : array) {
			result.add(String.valueOf(chars));
		}
		return result;
	}



	


	public static void main(String[] args) {
		Test51_1 test = new Test51_1();
		List<List<String>> resl=test.solveNQueens(4);
		for (int i = 0; i < resl.size(); i++) {
			List<String> list = resl.get(i);
			System.out.println(list.toString());
		}
	}
}
