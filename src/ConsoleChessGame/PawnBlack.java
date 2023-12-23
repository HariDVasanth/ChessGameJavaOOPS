package ConsoleChessGame;

public class PawnBlack extends Piece{
    private int[] checkToMove={-1,-1,-1,-1,-1,-1,-1,-1};
    public PawnBlack(PieceColour colour,boolean pieceStatus){
        super(colour,pieceStatus);
    }

    @Override
    public boolean checkMoves(int fromPosX, int fromPosY, int toPosX, int toPosY, boolean color) {

        return false;
    }

    @Override
    public boolean moves(int fromPosX, int fromPosY, int toPosX, int toPosY, boolean color) {

        return false;
    }
}
