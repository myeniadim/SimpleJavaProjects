public class King extends Piece {
    public King(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = targetLocation.getRowDistance(location);
        int colDistance = targetLocation.getColumnDistance(location);
        boolean canMoveMath = Math.abs(rowDistance) <= 1 && Math.abs(colDistance) <= 1;
        boolean canMoveColor = targetLocation.isEmpty() || (!targetLocation.isEmpty() && color != targetLocation.getPiece().getColor());
        if (canMoveMath && canMoveColor)
            return true;
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
        return color == ChessBoard.WHITE ? "K" : "k";
    }
}
