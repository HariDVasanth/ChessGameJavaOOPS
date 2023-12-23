package ConsoleChessGame;

public class Board {
    private static final int BOARD_SIZE = 8;

    public static Piece[][] piece=new Piece[8][8];

    public static boolean isValidPosition(int x, int y) {
        return x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE;
    }


}
