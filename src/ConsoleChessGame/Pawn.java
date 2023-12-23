package ConsoleChessGame;

public class Pawn extends Piece {
    public Pawn(PieceColour colour, boolean pieceStatus) {
        super(colour, pieceStatus);
    }
    @Override
    public boolean checkMoves(int fromPosX, int fromPosY, int toPosX, int toPosY, boolean color) {
        int direction = (this.color == PieceColour.WHITE) ? 1 : -1;
        if (toPosX == fromPosX + direction) {
            // Moving one step forward
            return Board.piece[toPosX][toPosY] == null;
        } else if (toPosX == fromPosX + 2 * direction && fromPosX == 1 && Board.piece[toPosX][toPosY] == null) {
            // Moving two steps forward from the starting position
            return Board.piece[fromPosX + direction][toPosY] == null;
        } else if (toPosY == fromPosY + direction || toPosY == fromPosY - direction) {
            // Capturing diagonally
            return Board.piece[toPosX][toPosY] != null && Board.piece[toPosX][toPosY].color != this.color;
        }
        return false;
    }

    @Override
    public boolean moves(int fromPosX, int fromPosY, int toPosX, int toPosY, boolean color) {
        int direction = (this.color == PieceColour.WHITE) ? 1 : -1;
        if (toPosX == fromPosX + direction) {
            // Moving one step forward
            return movePiece(fromPosX, fromPosY, toPosX, toPosY);
        } else if (toPosX == fromPosX + 2 * direction && fromPosX == 1) {
            // Moving two steps forward from the starting position
            if (Board.piece[toPosX][toPosY] == null && Board.piece[fromPosX + direction][toPosY] == null) {
                return movePiece(fromPosX, fromPosY, toPosX, toPosY);
            }
        } else if (toPosY == fromPosY + direction || toPosY == fromPosY - direction) {
            // Capturing diagonally
            if (Board.piece[toPosX][toPosY] != null && Board.piece[toPosX][toPosY].color != this.color) {
                capturePiece(toPosX, toPosY);
                return movePiece(fromPosX, fromPosY, toPosX, toPosY);
            }
        }
        System.out.println("Invalid move");
        return false;
    }

    private boolean movePiece(int fromPosX, int fromPosY, int toPosX, int toPosY) {
        Board.piece[toPosX][toPosY] = Board.piece[fromPosX][fromPosY];
        Board.piece[fromPosX][fromPosY] = null;
        return true;
    }

    private void capturePiece(int toPosX, int toPosY) {
        Board.piece[toPosX][toPosY].pieceStatus = false;
        System.out.println(Board.piece[toPosX][toPosY].toString() + " Piece has been captured.");
    }
}
