package logic;

public class Sudoku {
    int[][] board;
    int[][] unsolvedBoard;
    private final int n = 9; // number of columns/rows.
    private int diag = 3; // square root of N
    private int k; // No. Of missing digits

    Sudoku(int k) {
        this.k = k;
        board = new int[n][n];
    }

    public void generate() {
        fillDiagonal();

        fillRemaining(0, diag);

        removeKDigits();
    }

    void fillDiagonal() {

        for (int i = 0; i< n; i=i+ diag)

            // for diagonal box, start coordinates->i==j
            fillBox(i, i);
    }

    // Returns false if given 3 x 3 block contains num.
    boolean checkBox(int rowStart, int colStart, int num) {
        for (int i = 0; i< diag; i++)
            for (int j = 0; j< diag; j++)
                if (board[rowStart+i][colStart+j]==num)
                    return false;

        return true;
    }

    // Fill a 3 x 3 matrix.
    void fillBox(int row,int col) {
        int num;
        for (int i = 0; i< diag; i++)
        {
            for (int j = 0; j< diag; j++)
            {
                do
                {
                    num = randomGenerator(n);
                }
                while (!checkBox(row, col, num));

                board[row+i][col+j] = num;
            }
        }
    }

    // Random generator
    int randomGenerator(int num) {
        return (int) Math.floor((Math.random()*num+1));
    }

    // Check if safe to put in cell
    boolean CheckIfSafe(int i,int j,int num) {
        return (checkRow(i, num) &&
                checkCol(j, num) &&
                checkBox(i-i% diag, j-j% diag, num));
    }

    boolean checkRow(int i, int num) {
        for (int j = 0; j < n; j++)
            if (board[i][j] == num)
                return false;
        return true;
    }

    boolean checkCol(int j, int num) {
        for (int i = 0; i < n; i++)
            if (board[i][j] == num)
                return false;
        return true;
    }

    // A recursive function to fill remaining
    // matrix
    boolean fillRemaining(int i, int j) {
        //  System.out.println(i+" "+j);
        if (j>= n && i< n -1) {
            i = i + 1;
            j = 0;
        }
        if (i>= n && j>= n)
            return true;

        if (i < diag) {
            if (j < diag)
                j = diag;
        } else if (i < n - diag) {

            if (j == (int) (i / diag) * diag)
                j = j + diag;
        } else if (j == n - diag){
            i = i + 1;
            j = 0;

            if (i>= n)
                return true;
        }

        for (int num = 1; num<= n; num++)
        {
            if (CheckIfSafe(i, j, num))
            {
                board[i][j] = num;
                if (fillRemaining(i, j+1))
                    return true;

                board[i][j] = 0;
            }
        }
        return false;
    }

    public void removeKDigits() {
        unsolvedBoard = new int[9][9];
        for (int i = 0; i < n; i++) {
            unsolvedBoard[i] = board[i].clone();
        }

        int count = k;
        while (count != 0) {
            int cellId = randomGenerator(n * n)-1;

            // System.out.println(cellId);
            // extract coordinates i  and j
            int i = (cellId/ n);
            int j = cellId% n;

            // System.out.println(i+" "+j);
            if (unsolvedBoard[i][j] != 0) {
                count--;
                unsolvedBoard[i][j] = 0;
            }
        }
    }

    public void printSudoku(int [][] brd) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(brd[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public int[][] getBoard() {
        return board;
    }

    public int[][] getUnsolvedBoard() {
        return unsolvedBoard;
    }

    // Driver code
    public static void main(String[] args) {
        int K = 40;
        Sudoku sudoku = new Sudoku(K);
        sudoku.generate();
        sudoku.printSudoku(sudoku.getBoard());
        sudoku.printSudoku(sudoku.getUnsolvedBoard());
    }
}
