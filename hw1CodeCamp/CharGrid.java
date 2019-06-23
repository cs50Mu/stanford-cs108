import java.util.ArrayList;
import java.util.Collections;

// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		ArrayList<Integer> rows = new ArrayList<Integer>();
		ArrayList<Integer> cols = new ArrayList<Integer>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == ch) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		if (rows.size() == 1) {
			return 1;
		} else if (rows.size() > 1) {
			Collections.sort(rows);
			Collections.sort(cols);
			int maxRow = rows.get(rows.size()-1);
			int minRow = rows.get(0);
			int maxCol = cols.get(cols.size()-1);
			int minCol = cols.get(0);
			return (maxRow - minRow + 1) * (maxCol - minCol + 1);
		} else {
		return 0; // YOUR CODE HERE
		}
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int cnt = 0;
		int maxCol = grid[0].length;
		int maxRow = grid.length;
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxCol; j++) {
				//System.out.println(grid[i][j]);
				if (this.isPlus(i, j, maxCol, maxRow)) {
					cnt++;
				}
			}
		}
		return cnt; // YOUR CODE HERE
	}
	
	private boolean isPlus(int x, int y, int maxCol, int maxRow) {
		char val = grid[x][y];
		// left
		int leftCnt = 0;
		for (int i = y-1; i >= 0; i--) {
			if (grid[x][i] == val) {
				leftCnt++;
			}
		}
		// up
		int upCnt = 0;
		for (int i = x-1; i >= 0; i--) {
			if (grid[i][y] == val) {
				upCnt++;
			}
		}
		
		if (leftCnt != upCnt) {
			return false;
		}
		
		// right
		int rightCnt = 0;
		for (int i = y+1; i < maxCol; i++) {
			if (grid[x][i] == val) {
				rightCnt++;
			}
		}
		
		if (rightCnt != upCnt) {
			return false;
		}
		
		// down
		int downCnt = 0;
		for (int i = x+1; i < maxRow; i++) {
			if (grid[i][y] == val) {
				downCnt++;
			}
		}
		
		if (downCnt != rightCnt) {
			return false;
		} else {
			return true;
		}
		
	}	
}
