public abstract class Piece {
    protected int color;
    protected Square location;

    public Piece(int color, Square location) {
        this.color = color;
        this.location = location;
    }

    public abstract boolean canMove(String to);


    public void move(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        location.setPiece(null);
        targetLocation.setPiece(this);
        location = targetLocation;
    }

    public int getColor() {
        return color;
    }

}
