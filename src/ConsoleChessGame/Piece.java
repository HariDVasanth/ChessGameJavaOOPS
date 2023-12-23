package ConsoleChessGame;
public abstract class Piece {
    protected PieceColour color;
    protected boolean pieceStatus;

    public Piece(PieceColour color,boolean pieceStatus) {
        this.color = color;
        this.pieceStatus=pieceStatus;
    }

    public PieceColour getColor() {
        return color;
    }

    public abstract boolean checkMoves(int fromPosX, int fromPosY, int toPosX, int toPosY, boolean color);

    public abstract boolean moves(int fromPosX, int fromPosY, int toPosX, int toPosY, boolean color);
}

