package ConsoleChessGame;

public class Knight extends Piece{
    public Knight(PieceColour colour,boolean pieceStatus){
        super(colour,pieceStatus);
    }

    @Override
    public boolean checkMoves(int fromPosX, int fromPosY, int toPosX, int toPosY, boolean color) {
        int posX=Math.abs(fromPosX-toPosX);
        int posY=Math.abs(fromPosY-toPosY);
        if(posX==2 && posY==1 || posX==1 && posY==2){
            return Board.piece[toPosX][toPosY]==null || Board.piece[toPosX][toPosY].color!=this.color;
        }
        return false;
    }
    @Override
    public boolean moves(int fromPosX, int fromPosY, int toPosX, int toPosY, boolean color) {
        int deltaX = Math.abs(toPosX - fromPosX);
        int deltaY = Math.abs(toPosY - fromPosY);

        if ((deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1)) {
            if (isValidMove(toPosX, toPosY)) {
                if (captureCondition(toPosX, toPosY)) {
                    capturePiece(toPosX, toPosY);
                }
                movePiece(fromPosX, fromPosY, toPosX, toPosY);
                return true;
            }
        }

        return false;
    }

    private boolean isValidMove(int toPosX, int toPosY) {
        return Board.piece[toPosX][toPosY] == null || Board.piece[toPosX][toPosY].color != this.color;
    }

    private boolean captureCondition(int toPosX, int toPosY) {
        return Board.piece[toPosX][toPosY] != null && Board.piece[toPosX][toPosY].color != this.color;
    }

    private void movePiece(int fromPosX, int fromPosY, int toPosX, int toPosY) {
        Board.piece[toPosX][toPosY] = Board.piece[fromPosX][fromPosY];
        Board.piece[fromPosX][fromPosY] = null;
    }

    private void capturePiece(int toPosX, int toPosY) {
        Board.piece[toPosX][toPosY].pieceStatus = false;
        System.out.println(Board.piece[toPosX][toPosY].toString() + " Piece has been captured.");
    }

}
