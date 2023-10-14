public class Square {
    private int row;
    private int column;
    private Piece piece;
    private ChessBoard board;

    public Square(int row, int column, ChessBoard board) {
        this.row = row;
        this.column = column;
        this.board = board;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isEmpty() {
        return (piece == null);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public int getRowDistance(Square location) {
        return location.row - row;
    }

    public boolean isAtSameColumn(Square targetLocation) {
        return (targetLocation.column == column);
    }

    public boolean isNeighborColumn(Square targetLocation) {
        return (targetLocation.column - 1 == column || targetLocation.column + 1 == column);
    }

    public boolean isAtLastRow(int color) {
        if (color == ChessBoard.BLACK)
            return (row == 7);
        return (row == 0);
    }

    public void putNewQueen(int color) {
        setPiece(new Queen(color, board.squares[row][column]));
    }

    public void clear() {
        setPiece(null);
    }

    @Override
    public String toString() {
        if (piece != null)
            return "" + piece;
        return " ";
    }

    public int getColumnDistance(Square location) {
        return location.column - column;
    }

    public boolean isAtSameRow(Square targetLocation) {
        return (targetLocation.row == row);
    }
}
