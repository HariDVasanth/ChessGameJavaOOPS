package ConsoleChessGame;

import java.util.Scanner;

public class ChessMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player.initialisePosition();

        boolean turn = true;
        Piece piece = null;

        while (!Player.whiteKing.pieceStatus && !Player.blackKing.pieceStatus) {
            System.out.println("0\t\t\t1\t\t\t2\t\t\t3\t\t\t4\t\t\t5\t\t\t6\t\t\t7\t\t\t8");
            for (int row = 7; row >= 0; row--) {
                System.out.print(row + 1 + "\t");
                for (int col = 7; col >= 0; col--) {
                    piece = Board.piece[row][col];
                    if (piece instanceof Pawn) {
                        if(piece.color==PieceColour.WHITE) {
                            System.out.print("PawnWhite\t");
                            turn = true;
                        }else {
                            System.out.print("PawnBlack\t");
                            turn=false;
                        }
                    } else if (piece instanceof Rook) {
                        if (piece.color == PieceColour.WHITE) {
                            System.out.print("RookWhite\t");
                            turn = true;
                        } else {
                            System.out.print("RookBlack\t");
                            turn = false;
                        }
                    } else if (piece instanceof Knight) {
                        if (piece.color == PieceColour.WHITE) {
                            System.out.print("KnightWhite\t");
                            turn = true;
                        } else {
                            System.out.print("KnightBlack\t");
                            turn = false;
                        }
                    } else if (piece instanceof Bishop) {
                        if (piece.color == PieceColour.WHITE) {
                            System.out.print("BishopWhite\t");
                            turn = true;
                        } else {
                            System.out.print("BishopBlack\t");
                            turn = false;
                        }
                    } else if (piece instanceof King) {
                        if (piece.color == PieceColour.WHITE) {
                            System.out.print("KingWhite\t");
                            turn = true;
                        } else {
                            System.out.print("KingBlack\t");
                            turn = false;
                        }
                    } else if (piece instanceof Queen) {
                        if (piece.color == PieceColour.WHITE) {
                            System.out.print("QueenWhite\t");
                            turn = true;
                        } else {
                            System.out.print("QueenBlack\t");
                            turn = false;
                        }
                    } else {
                        System.out.print("Null\t\t");
                    }
                }
                System.out.println();
            }

            String whiteTurnMessage = "White's Turn";
            String blackTurnMessage = "Black's Turn";
            System.out.println(turn ? whiteTurnMessage : blackTurnMessage);
            System.out.println("From position");

            int fromPosX = scanner.nextInt();
            int fromPosY = scanner.nextInt();

            System.out.println("To Position");
            int toPosX = scanner.nextInt();
            int toPosY = scanner.nextInt();
            boolean isValid = false;
            if ((fromPosX >= 0 && fromPosX <= 8) && (toPosX >= 0 && toPosY <= 8)) {
                piece = Board.piece[fromPosX][fromPosY];
                if (piece instanceof Pawn) {
                    isValid = piece.checkMoves(fromPosX, fromPosY, toPosX, toPosY, turn);
                }else if (piece instanceof Rook) {
                    isValid = piece.checkMoves(fromPosX, fromPosY, toPosX, toPosY, turn);
                } else if (piece instanceof Knight) {
                    isValid = piece.checkMoves(fromPosX, fromPosY, toPosX, toPosY, turn);
                } else if (piece instanceof Bishop) {
                    isValid = piece.checkMoves(fromPosX, fromPosY, toPosX, toPosY, turn);
                } else if (piece instanceof Queen) {
                    isValid = piece.checkMoves(fromPosX, fromPosY, toPosX, toPosY, turn);
                } else if (piece instanceof King) {
                    isValid = piece.checkMoves(fromPosX, fromPosY, toPosX, toPosY, turn);
                }
            }
            if (isValid) {
                piece.moves(fromPosX, fromPosY, toPosX, toPosY, turn);
            }
        }
    }
}
