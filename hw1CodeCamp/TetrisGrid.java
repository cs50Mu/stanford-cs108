//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private boolean[][] grid;
	
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int maxRow = this.grid.length;
		int maxCol = this.grid[0].length;
		for (int i = 0; i < maxCol; i++) {
			while (this.isFull(i, maxRow)) {
				// shift until current col is not full
				this.shiftCol(i, maxRow, maxCol);
			}
		}
	}
	
	private boolean isFull(int colIndex, int maxRow) {
		for (int i = 0; i < maxRow; i++) {
			if (!this.grid[i][colIndex]) {
				return false;
			}
		}
		return true;
	}
	// shift next col to current col (从当前列开始，直到最后一列，最后一列使用使用全false）
	private void shiftCol(int colIndex, int maxRow, int maxCol) {
		for (int i = colIndex; i < maxCol; i++) {
		for (int j = 0; j < maxRow; j++) {
			if (i == maxCol - 1) {
				this.grid[j][i] = false;
			} else {
			this.grid[j][i] = this.grid[j][i+1];
			}
		}
		}
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		this.printGrid();
		return this.grid; // YOUR CODE HERE
	}
	
	private void printGrid() {
		for (int i=0; i < this.grid.length; i++) {
			for (int j=0; j < this.grid[0].length; j++) {
				System.out.println(this.grid[i][j]);
			}
			System.out.println(" ");
		}
	}
}
