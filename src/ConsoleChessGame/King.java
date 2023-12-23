package ConsoleChessGame;

public class King extends Piece {
    private enum Direction {
        UP_LEFT,
        UP,
        UP_RIGHT,
        LEFT,
        RIGHT,
        DOWN_LEFT,
        DOWN,
        DOWN_RIGHT
    }
    public King(PieceColour colour, boolean pieceStatus) {
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

        int[] move = getMoveForDirection(direction);

        i += move[0];
        j += move[1];

        if (isValidPosition(i, j)) {
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
        }

        return false;
    }

    private int[] getMoveForDirection(Direction direction) {
        int[] move = new int[2];

        switch (direction) {
            case UP_LEFT:
                move[0] = -1;
                move[1] = -1;
                break;
            case UP:
                move[0] = -1;
                move[1] = 0;
                break;
            case UP_RIGHT:
                move[0] = -1;
                move[1] = 1;
                break;
            case LEFT:
                move[0] = 0;
                move[1] = -1;
                break;
            case RIGHT:
                move[0] = 0;
                move[1] = 1;
                break;
            case DOWN_LEFT:
                move[0] = 1;
                move[1] = -1;
                break;
            case DOWN:
                move[0] = 1;
                move[1] = 0;
                break;
            case DOWN_RIGHT:
                move[0] = 1;
                move[1] = 1;
                break;
        }

        return move;
    }

    private boolean isValidPosition(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
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
