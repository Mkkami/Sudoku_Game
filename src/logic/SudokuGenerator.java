package logic;

public class SudokuGenerator {
	
	private int BLANK_BOARD[] = {
	                     0, 0, 0, 0, 0, 0, 0, 0, 0,
	                     0, 0, 0, 0, 0, 0, 0, 0, 0,
	                     0, 0, 0, 0, 0, 0, 0, 0, 0,
	                     0, 0, 0, 0, 0, 0, 0, 0, 0,
	                     0, 0, 0, 0, 0, 0, 0, 0, 0,
	                     0, 0, 0, 0, 0, 0, 0, 0, 0,
	                     0, 0, 0, 0, 0, 0, 0, 0, 0,
	                     0, 0, 0, 0, 0, 0, 0, 0, 0,
	                     0, 0, 0, 0, 0, 0, 0, 0, 0,
						};
	public SudokuGenerator() {
		printBoard(BLANK_BOARD);
		
	}
	
	public static void main(String [] args) {
		new SudokuGenerator();
		
	}
	
	private void printBoard(int[] brd) {
		for (int i = 0; i < 81; ++i) {
			System.out.print(brd[i] + " ");
			if (i%9 == 8) {
				System.out.println("");
			}
		}
	}
	
	private boolean columnSafe(int num, int index, int [] brd) {
		int col = index % 9;
		
		for (int i = col; i < 81; i+=9) {
			if (brd[i] == num) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean rowSafe(int num, int index, int [] brd) {
		
		int row = index / 9;
		
		for (int i = row*9; i < (row+1)*9; ++i) {
			if (brd[i] == num) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean boxSafe(int num, int index, int [] brd) {
	    int row = (index / 9) / 3 * 3;
	    int col = (index % 9) / 3 * 3;
	    
	    for (int i = 0; i < 3; ++i) {
	        for (int j = 0; j < 3; ++j) {
	            int boxIndex = (row + i) * 9 + (col + j);
	            if (brd[boxIndex] == num) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
	private boolean positionSafe(int num, int index, int [] brd) {
		return rowSafe(num, index, brd) && columnSafe(num, index, brd)&& boxSafe(num, index, brd);
	}
	
	
	
}
