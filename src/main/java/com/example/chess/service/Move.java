package com.example.chess.service;

import com.example.chess.dto.Piece;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.chess.type.ColorEnum.BLACK;
import static com.example.chess.type.NameEnum.HORSE;

@Service
public class Move {

    ChessService chessService = new ChessService();
    Piece[][] chessBoard = chessService.createBoard();
    List<Piece[][]> possibleMoves = new ArrayList<>();
    public List<Piece[][]> movePiece() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece p = chessBoard[i][j];
                if (p.getName() == HORSE && p.getColor() == BLACK) {
                    calculateHorseMoves(p, i, j, possibleMoves);
                }
            }
        }
        return possibleMoves;
    }

    void calculateHorseMoves(Piece p, int posX, int posY, List<Piece[][]> list) {
        for (int horse = 1; horse < 9; horse++) {
            int toX, toY;
            switch (horse) {
                case 1:
                    toX = posX + 2;
                    toY = posY + 1;
                    control(toX, toY, p, list);
                    break;
                case 2:
                    toX = posX + 2;
                    toY = posY - 1;
                    control(toX, toY, p, list);
                    break;
                case 3:
                    toX = posX - 2;
                    toY = posY - 1;
                    control(toX, toY, p, list);
                    break;
                case 4:
                    toX = posX - 2;
                    toY = posY + 1;
                    control(toX, toY, p, list);
                    break;
                case 5:
                    toX = posX - 1;
                    toY = posY - 2;
                    control(toX, toY, p, list);
                    break;
                case 6:
                    toX = posX - 1;
                    toY = posY + 2;
                    control(toX, toY, p, list);
                    break;
                case 7:
                    toX = posX + 1;
                    toY = posY - 2;
                    control(toX, toY, p, list);
                    break;
                case 8:
                    toX = posX + 1;
                    toY = posY + 2;
                    control(toX, toY, p, list);
                    break;
            }
        }
    }

    private List<Piece[][]> control(int toX, int toY, Piece curentPiece, List<Piece[][]> list) {
        try {
            Piece toPiece = chessBoard[toX][toY];
            if (toX < 0 || toX > 7 || toY < 0 || toY > 7) {
            } else if (toPiece.getColor() != curentPiece.getColor()) {
                toPiece = new Piece();
                toPiece.setName(curentPiece.getName());
                toPiece.setColor(curentPiece.getColor());
                curentPiece = null;
                list.add(clone(chessBoard));
                return list;
            }
        } catch (Exception e) {
        }
        return list;
    }
    Piece[][] clone(Piece[][] chessBoard) {
        Piece[][] newBoard = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece oldPiece = chessBoard[i][j];
                if (oldPiece != null) {
                    Piece newPiece = new Piece();
                    newPiece.setName(oldPiece.getName());
                    newPiece.setColor(oldPiece.getColor());
                    newBoard[i][j] = newPiece;
                    possibleMoves.add(newBoard);
                }
            }
        }
        return newBoard;
    }
}



