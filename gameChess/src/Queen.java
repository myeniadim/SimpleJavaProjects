public class Queen extends Piece {
    public Queen(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = targetLocation.getRowDistance(location);
        int colDistance = targetLocation.getColumnDistance(location);
        if (Math.abs(rowDistance) == Math.abs(colDistance) || location.isAtSameRow(targetLocation) || location.isAtSameColumn(targetLocation)) {
            if (targetLocation.isEmpty() || (!targetLocation.isEmpty() && color != targetLocation.getPiece().getColor())) {
                Square[] between = location.getBoard().getSquaresBetween(location, targetLocation);
                for (Square square : between) {
                    if (!square.isEmpty()) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public void move(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        targetLocation.setPiece(this);
        location.clear();
        location = targetLocation;
        location.getBoard().nextPlayer();
    }

    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "Q" : "q";
    }
}
