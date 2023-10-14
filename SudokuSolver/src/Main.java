public class Main {
    public static void main(String[] args) {
        int [][] board = {
                {5, 4, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 8, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 9, 0, 7, 0, 3},
                {0, 7, 0, 0, 0, 8, 0, 0, 0},
                {6, 0, 0, 4, 2, 3, 0, 0, 7},
                {0, 0, 0, 1, 0, 0, 0, 5, 0},
                {2, 0, 4, 0, 6, 0, 9, 0, 0},
                {0, 0, 0, 0, 0, 4, 2, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 3, 8}
        };
        printBoard(board);
        if (canSolveBoard(board))
            System.out.println("Solved Succesfully");
        else
            System.out.println("It is impossible");
    }
    public static void printBoard(int[][] board){
        StringBuffer buf = new StringBuffer();
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                buf.append(board[row][col]).append(" ");
                if ((col+1) % 3 == 0)
                    buf.append("| ");
            }
            if ((row+1) % 3 == 0)
                buf.append("\n" + "-----------------------" + "\n");
            else
                buf.append("\n");
        }
        System.out.println(buf);
    }

    public static boolean isLegalVertically(int targetNumber, int[][] board, int colNumber){
        for (int row = 0; row < 9; ++row) {
            if (targetNumber == board[row][colNumber])
                return false;
        }
        return true;
    }
    public static boolean isLegalHorizontally(int targetNumber, int[][] board, int rowNumber){
        for (int col = 0; col < 9; ++col) {
            if (targetNumber == board[rowNumber][col])
                return false;
        }
        return true;
    }
    public static boolean isLegalInBox(int targetNumber, int[][] board, int rowNumber, int colNumber){
        int startingRow = rowNumber - (rowNumber % 3);
        int startingCol = colNumber - (colNumber % 3);
        for (int row = startingRow; row < startingRow + 3; ++row) {
            for (int col = startingCol; col < startingCol + 3; ++col) {
                if (targetNumber == board[row][col])
                    return false;
            }
        }
        return true;
    }
    public static boolean canSolveBoard(int[][] board){
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int i = 1; i < 10; i++) {
                        if (isLegalHorizontally(i, board, row) && isLegalVertically(i, board, col) && isLegalInBox(i, board, row, col)) {
                            board[row][col] = i;
                            if (canSolveBoard(board)) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }

                        }

                    }
                    return false;
                }
            }
        }
        printBoard(board);
        return true;
    }

}