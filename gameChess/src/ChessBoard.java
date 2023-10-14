public class ChessBoard {
    public static final int WHITE = 0;
    public static final int BLACK = 1;

    private boolean whitePlaying = true;
    protected Square[][] squares;

    public ChessBoard() {
        squares = new Square[8][8];
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                squares[row][column] = new Square(row, column, this);
            }
        }
        squares[7][0].setPiece(new Rook(WHITE, squares[7][0]));
        squares[7][1].setPiece(new Knight(WHITE, squares[7][1]));
        squares[7][2].setPiece(new Bishop(WHITE, squares[7][2]));
        squares[7][3].setPiece(new Queen(WHITE, squares[7][3]));
        squares[7][4].setPiece(new King(WHITE, squares[7][4]));
        squares[7][5].setPiece(new Bishop(WHITE, squares[7][5]));
        squares[7][6].setPiece(new Knight(WHITE, squares[7][6]));
        squares[7][7].setPiece(new Rook(WHITE, squares[7][7]));
        for (int column = 0; column < 8; column++) {
            squares[6][column].setPiece(new Pawn(WHITE, squares[6][column]));
        }
        squares[0][0].setPiece(new Rook(BLACK, squares[0][0]));
        squares[0][1].setPiece(new Knight(BLACK, squares[0][1]));
        squares[0][2].setPiece(new Bishop(BLACK, squares[0][2]));
        squares[0][3].setPiece(new Queen(BLACK, squares[0][3]));
        squares[0][4].setPiece(new King(BLACK, squares[0][4]));
        squares[0][5].setPiece(new Bishop(BLACK, squares[0][5]));
        squares[0][6].setPiece(new Knight(BLACK, squares[0][6]));
        squares[0][7].setPiece(new Rook(BLACK, squares[0][7]));
        for (int column = 0; column < 8; column++) {
            squares[1][column].setPiece(new Pawn(BLACK, squares[1][column]));
        }
    }

    public Square getSquareAt(String location) {
        int row = Integer.parseInt(location.substring(1,2));
        int column = 0;
        String firstLetter = new String (location.substring(0,1));
        if (firstLetter.equals("a"))
            column = 0;
        if (firstLetter.equals("b"))
            column = 1;
        if (firstLetter.equals("c"))
            column = 2;
        if (firstLetter.equals("d"))
            column = 3;
        if (firstLetter.equals("e"))
            column = 4;
        if (firstLetter.equals("f"))
            column = 5;
        if (firstLetter.equals("g"))
            column = 6;
        if (firstLetter.equals("h"))
            column = 7;
        return squares[Math.abs(8 - row)][column];
    }

    public boolean isGameEnded() {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                Piece piece = squares[row][column].getPiece();
                if ((isWhitePlaying() && (piece != null && piece.color == WHITE)) || (!isWhitePlaying() && (piece != null && piece.color == BLACK)))
                    return false;
            }
        }
        return true;
    }

    public boolean isWhitePlaying() {
        return (whitePlaying);
    }

    public Piece getPieceAt(String from) {
        Square square = getSquareAt(from);
        return square.getPiece();
    }

    public Square[] getSquaresBetween(Square location, Square targetLocation) {
        int row1 = location.getRow();
        int col1 = location.getColumn();
        int row2 = targetLocation.getRow();
        int col2 = targetLocation.getColumn();
        int rowDiff = Math.abs(row1 - row2);
        int colDiff = Math.abs(col1 - col2);

        if (rowDiff != 0 && colDiff != 0 && rowDiff != colDiff) {
            // not in the same row, column or diagonal
            return new Square[0];
        }

        int minRow = Math.min(row1, row2);
        //int maxRow = Math.max(row1, row2);
        int minCol = Math.min(col1, col2);
        //int maxCol = Math.max(col1, col2);

        Square[] squaresBetween;
        if (rowDiff == 0) {
            // same row
            squaresBetween = new Square[colDiff - 1];
            for (int i = 0; i < squaresBetween.length; i++) {
                squaresBetween[i] = squares[row1][minCol + i + 1];
            }
        } else if (colDiff == 0) {
            // same column
            squaresBetween = new Square[rowDiff - 1];
            for (int i = 0; i < squaresBetween.length; i++) {
                squaresBetween[i] = squares[minRow + i + 1][col1];
            }
        } else {
            // diagonal
            squaresBetween = new Square[rowDiff - 1];
            for (int i = 0; i < squaresBetween.length; i++) {
                int rowOffset = minRow == row1 ? i + 1 : -(i + 1);
                int colOffset = minCol == col1 ? i + 1 : -(i + 1);
                squaresBetween[i] = squares[row1 + rowOffset][col1 + colOffset];
            }
        }
        return squaresBetween;
    }


    public void nextPlayer() {
        whitePlaying = !whitePlaying;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("    A   B   C   D   E   F   G   H\n").append("   --------------------------------\n");
        int num = 9;
        for (int row = 0; row < 8; ++row) {
            buf.append(--num  + " ");
            for (int col = 0; col < 8; ++col) {
                buf.append("|");
                buf.append(" " + squares[row][col] + " ");
                if (col == 7)
                    buf.append("| " + num);
            }
            buf.append("\n");
            buf.append("   --------------------------------\n");
        }
        buf.append("    A   B   C   D   E   F   G   H\n");
        return buf.toString();
    }

}

