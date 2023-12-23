package ConsoleChessGame;

public class Bishop extends Piece {

    public Bishop(PieceColour colour, boolean pieceStatus) {
        super(colour, pieceStatus);
    }

    @Override
    public boolean checkMoves(int fromPosX, int fromPosY, int toPosX, int toPosY, boolean color) {
        for (Direction direction : Direction.values()) {
            if (tryMoveInDirection(fromPosX, fromPosY, toPosX, toPosY, direction, false)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean moves(int fromPosX, int fromPosY, int toPosX, int toPosY, boolean color) {
        for (Direction direction : Direction.values()) {
            if (tryMoveInDirection(fromPosX, fromPosY, toPosX, toPosY, direction, true)) {
                return true;
            }
        }
        return false;
    }

    private boolean tryMoveInDirection(int fromPosX, int fromPosY, int toPosX, int toPosY, Direction direction, boolean performMove) {
        int i = fromPosX;
        int j = fromPosY;

        while (true) {
            switch (direction) {
                case UP_LEFT:
                    i--;
                    j--;
                    break;
                case UP_RIGHT:
                    i--;
                    j++;
                    break;
                case DOWN_LEFT:
                    i++;
                    j--;
                    break;
                case DOWN_RIGHT:
                    i++;
                    j++;
                    break;
            }

            if (i == toPosX && j == toPosY) {
                if (performMove) {
                    if (isValidMove(toPosX, toPosY)) {
                        if (captureCondition(toPosX, toPosY)) {
                            capturePiece(toPosX, toPosY);
                        }
                        movePiece(fromPosX, fromPosY, toPosX, toPosY);
                    }
                }
                return true;
            }

            if (!Board.isValidPosition(i, j) || Board.piece[i][j] != null) {
                return false;
            }
        }
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

    // Enum for directions
    private enum Direction {
        UP_LEFT,
        UP_RIGHT,
        DOWN_LEFT,
        DOWN_RIGHT
    }
}
