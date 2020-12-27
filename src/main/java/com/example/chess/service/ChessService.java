package com.example.chess.service;

import com.example.chess.dto.Piece;
import com.example.chess.type.ColorEnum;
import com.example.chess.type.NameEnum;
import org.springframework.stereotype.Service;

@Service
public class ChessService {
    //Satranç tahtası oluşturabilmek için 2 boyutlu bir arraylist oluşturdum.
    public Piece[][] createBoard() {
        Piece[][] chessBoard = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0 && j == 0 || i == 0 && j == 7) {
                    Piece piece = new Piece();
                    piece.setName(NameEnum.ROOK.getName());
                    piece.setColor(ColorEnum.BLACK.getColor());
                    chessBoard[i][j] = piece;

                } else if (i == 0 && j == 1 || i == 0 && j == 6) {
                    Piece piece = new Piece();
                    piece.setName(NameEnum.HORSE.getName());
                    piece.setColor(ColorEnum.BLACK.getColor());
                    chessBoard[i][j] = piece;
                } else if (i == 0 && j == 2 || i == 0 && j == 5) {
                    Piece piece = new Piece();
                    piece.setName(NameEnum.BISHOP.getName());
                    piece.setColor(ColorEnum.BLACK.getColor());
                    chessBoard[i][j] = piece;
                } else if (i == 0 && j == 3) {
                    Piece piece = new Piece();
                    piece.setName(NameEnum.QUENN.getName());
                    piece.setColor(ColorEnum.BLACK.getColor());
                    chessBoard[i][j] = piece;
                } else if (i == 0 && j == 4) {
                    Piece piece = new Piece();
                    piece.setName(NameEnum.KING.getName());
                    piece.setColor(ColorEnum.BLACK.getColor());
                    chessBoard[i][j] = piece;
                } else if (i == 1 && j < 8) {
                    Piece piece = new Piece();
                    piece.setName(NameEnum.PAWN.getName());
                    piece.setColor(ColorEnum.BLACK.getColor());
                    chessBoard[i][j] = piece;
                } else if (i == 7 && j == 0 || i == 7 && j == 7) {
                    Piece piece = new Piece();
                    piece.setName(NameEnum.ROOK.getName());
                    piece.setColor(ColorEnum.WHITE.getColor());
                    chessBoard[i][j] = piece;
                } else if (i == 7 && j == 1 || i == 7 && j == 6) {
                    Piece piece = new Piece();
                    piece.setName(NameEnum.HORSE.getName());
                    piece.setColor(ColorEnum.WHITE.getColor());
                    chessBoard[i][j] = piece;
                } else if (i == 7 && j == 2 || i == 7 && j == 5) {
                    Piece piece = new Piece();
                    piece.setName(NameEnum.BISHOP.getName());
                    piece.setColor(ColorEnum.WHITE.getColor());
                    chessBoard[i][j] = piece;
                } else if (i == 7 && j == 3) {
                    Piece piece = new Piece();
                    piece.setName(NameEnum.QUENN.getName());
                    piece.setColor(ColorEnum.WHITE.getColor());
                    chessBoard[i][j] = piece;
                } else if (i == 7 && j == 4) {
                    Piece piece = new Piece();
                    piece.setName(NameEnum.KING.getName());
                    piece.setColor(ColorEnum.WHITE.getColor());
                    chessBoard[i][j] = piece;
                } else if (i == 6 && j < 8) {
                    Piece piece = new Piece();
                    piece.setName(NameEnum.PAWN.getName());
                    piece.setColor(ColorEnum.WHITE.getColor());
                    chessBoard[i][j] = piece;
                } else if (i == 3 && j == 4) {
                    Piece piece = new Piece();
                    piece.setName(NameEnum.PAWN.getName());
                    piece.setColor(ColorEnum.BLACK.getColor());
                    chessBoard[i][j] = piece;
                } else if (i == 3 && j == 3) {
                    Piece piece = new Piece();
                    piece.setName(NameEnum.BISHOP.getName());
                    piece.setColor(ColorEnum.BLACK.getColor());
                    chessBoard[i][j] = piece;
                } else if (1 < i && i < 6) {
                    if (j < 8) {
                        Piece piece = new Piece();
                        chessBoard[i][j] = piece;
                    }
                }
            }
        }
        return chessBoard;
    }
}



