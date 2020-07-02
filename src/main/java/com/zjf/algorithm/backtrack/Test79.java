package com.zjf.algorithm.backtrack;

public class Test79 {

	/**
	 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
	 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
	 * 示例:
	 * board =
	 * [
	 *   ['A','B','C','E'],
	 *   ['S','F','C','S'],
	 *   ['A','D','E','E']
	 * ]
	 * 给定 word = "ABCCED", 返回 true
	 * 给定 word = "SEE", 返回 true
	 * 给定 word = "ABCB", 返回 false
	 * 提示：
	 * board 和 word 中只包含大写和小写英文字母。
	 * 1 <= board.length <= 200
	 * 1 <= board[i].length <= 200
	 * 1 <= word.length <= 10^3
	 */
	int rows, cols;
	char[][] board;
	char[] word;
	int[][] next = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	boolean[][] marked;
	public boolean exist(char[][] board, String word) {
		this.rows = board.length;
		this.cols = board[0].length;
		this.board = board;
		this.word = word.toCharArray();
		this.marked = new boolean[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (search(0, row, col)) {
					return true;
				}
			}
		}
		return false;
	}
	private boolean search(int pos, int row, int col) {
		if (row < 0 || row >= rows || col < 0 || col >= cols || marked[row][col]) {
			return false;
		}

		if (board[row][col] != word[pos]) {
			return false;
		}

		if (pos == word.length - 1) {
			return true;
		}
		marked[row][col] = true;

		for (int[] nex : next) {
			if (search(pos + 1, row + nex[0], col + nex[1])) {
				return true;
			}
		}

		marked[row][col] = false;
		return false;
	}


}
