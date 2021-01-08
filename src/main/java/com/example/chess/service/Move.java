package com.example.chess.service;

import com.example.chess.dto.Piece;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.chess.type.ColorEnum.BLACK;
import static com.example.chess.type.NameEnum.*;

@Service
public class Move {

    ChessService chessService = new ChessService();
    Piece[][] chessBoard = chessService.createBoard();
    List<Piece[][]> possibleMoves = new ArrayList<>();
    Piece[][] tempBoard = chessBoard;

    public List<Piece[][]> movePiece() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece p = chessBoard[i][j];
               /* if (p.getName() == ROOK && p.getColor() == BLACK) {
                    calculateRookMoves(p, i, j, possibleMoves, tempBoard);
                }*/
                /*if (p.getName() == HORSE && p.getColor() == BLACK) {
                    calculateHorseMoves(p, i, j, possibleMoves);
                }*/
                 /* if (p.getName() == BISHOP && p.getColor() == BLACK) {
                    calculateBishopMoves(p, i, j, possibleMoves);
                }*/
                 /*if (p.getName() == KING && p.getColor() == BLACK) {
                    calculateKingMoves(p, i, j, possibleMoves);
                }*/
                /*  if (p.getName() == QUENN && p.getColor() == BLACK) {
                    calculateQuennMoves(p, i, j, possibleMoves);
                }*/
                if (p.getName() == PAWN && p.getColor() == BLACK) {
                    calculatePawnMoves(p, i, j, possibleMoves, tempBoard);
                }
            }
        }
        return possibleMoves;
    }

    void calculateRookMoves(Piece p, int posX, int posY, List<Piece[][]> list, Piece[][] tempBoard) {
        for (int rook = 1; rook < 5; rook++) {
            int toX, toY;
            switch (rook) {
                case 1:
                    //x++
                    for (int pX = 1; pX < 8; pX++) {
                        toX = posX + pX;
                        toY = posY;
                        if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                            break;
                        }
                    }
                    break;
                case 2:
                    //x--
                    for (int nX = 1; nX < 8; nX++) {
                        toX = posX - nX;
                        toY = posY;
                        if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                            break;
                        }
                    }
                    break;
                case 3:
                    //y++
                    for (int pY = 1; pY < 8; pY++) {
                        toX = posX;
                        toY = posY + pY;
                        if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                            break;
                        }
                    }
                    break;
                case 4:
                    //y--
                    for (int nY = 1; nY < 8; nY++) {
                        toX = posX;
                        toY = posY - nY;
                        if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                            break;
                        }
                    }
                    break;
            }
        }
    }

    void calculateHorseMoves(Piece p, int posX, int posY, List<Piece[][]> list) {
        for (int horse = 1; horse < 9; horse++) {
            int toX, toY;
            switch (horse) {
                case 1:
                    toX = posX + 2;
                    toY = posY + 1;
                    if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                        break;
                    }
                    break;
                case 2:
                    toX = posX + 2;
                    toY = posY - 1;
                    if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                        break;
                    }
                    break;
                case 3:
                    toX = posX - 2;
                    toY = posY - 1;
                    if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                        break;
                    }
                    break;
                case 4:
                    toX = posX - 2;
                    toY = posY + 1;
                    if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                        break;
                    }
                    break;
                case 5:
                    toX = posX - 1;
                    toY = posY - 2;
                    if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                        break;
                    }
                    break;
                case 6:
                    toX = posX - 1;
                    toY = posY + 2;
                    if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                        break;
                    }
                    break;
                case 7:
                    toX = posX + 1;
                    toY = posY - 2;
                    if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                        break;
                    }
                    break;
                case 8:
                    toX = posX + 1;
                    toY = posY + 2;
                    if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                        break;
                    }
                    break;
            }
        }
    }

    void calculateBishopMoves(Piece p, int posX, int posY, List<Piece[][]> list) {
        for (int bishop = 1; bishop < 5; bishop++) {
            int toX, toY;
            switch (bishop) {
                case 1:
                    //x++,y++
                    for (int pos = 1; pos < 8; pos++) {
                        toX = posX + pos;
                        toY = posY + pos;
                        if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                            break;
                        }
                    }
                    break;
                case 2:
                    //x++,y--
                    for (int pos = 1; pos < 8; pos++) {
                        toX = posX + pos;
                        toY = posY - pos;
                        if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                            break;
                        }
                    }
                    break;
                case 3:
                    //x--,y++
                    for (int pos = 1; pos < 8; pos++) {
                        toX = posX - pos;
                        toY = posY + pos;
                        if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                            break;
                        }
                    }
                    break;
                case 4:
                    //x--,y--
                    for (int pos = 1; pos < 8; pos++) {
                        toX = posX - pos;
                        toY = posY - pos;
                        if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                            break;
                        }
                    }
                    break;
            }
        }
    }

    void calculateKingMoves(Piece p, int posX, int posY, List<Piece[][]> list) {
        for (int king = 1; king < 9; king++) {
            int toX, toY;
            switch (king) {
                case 1:
                    // x+1,y-1
                    toX = posX + 1;
                    toY = posY - 1;
                    if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                        break;
                    }
                    break;
                case 2:
                    //x+1,y
                    toX = posX + 1;
                    toY = posY;
                    if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                        break;
                    }
                    break;
                case 3:
                    //x+1,y+1
                    toX = posX + 1;
                    toY = posY + 1;
                    if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                        break;
                    }
                    break;
                case 4:
                    //x,y+1
                    toX = posX;
                    toY = posY + 1;
                    if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                        break;
                    }
                    break;
                case 5:
                    //x-1,y+1
                    toX = posX - 1;
                    toY = posY + 1;
                    if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                        break;
                    }
                    break;
                case 6:
                    //x-1,y
                    toX = posX - 1;
                    toY = posY;
                    if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                        break;
                    }
                    break;
                case 7:
                    //x-1,y-1
                    toX = posX - 1;
                    toY = posY - 1;
                    if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                        break;
                    }
                    break;
                case 8:
                    //x,y-1
                    toX = posX;
                    toY = posY - 1;
                    if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                        break;
                    }
                    break;
            }
        }
    }

    void calculateQuennMoves(Piece p, int posX, int posY, List<Piece[][]> list) {
        for (int quenn = 1; quenn < 9; quenn++) {
            int toX, toY;
            switch (quenn) {
                case 1:
                    for (int pos = 1; pos < 8; pos++) {
                        toX = posX + pos;
                        toY = posY + pos;
                        if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                            break;
                        }
                    }
                    break;
                case 2:
                    //x++,y--
                    for (int pos = 1; pos < 8; pos++) {
                        toX = posX + pos;
                        toY = posY - pos;
                        if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                            break;
                        }
                    }
                    break;
                case 3:
                    //x--,y++
                    for (int pos = 1; pos < 8; pos++) {
                        toX = posX - pos;
                        toY = posY + pos;
                        if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                            break;
                        }
                    }
                    break;
                case 4:
                    //x--,y--
                    for (int pos = 1; pos < 8; pos++) {
                        toX = posX - pos;
                        toY = posY - pos;
                        if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                            break;
                        }
                    }
                    break;
                case 5:
                    //x++
                    for (int pX = 1; pX < 8; pX++) {
                        toX = posX + pX;
                        toY = posY;
                        if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                            break;
                        }
                    }
                    break;
                case 6:
                    //x--
                    for (int nX = 1; nX < 8; nX++) {
                        toX = posX - nX;
                        toY = posY;
                        if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                            break;
                        }
                    }
                    break;
                case 7:
                    //y++
                    for (int pY = 1; pY < 8; pY++) {
                        toX = posX;
                        toY = posY + pY;
                        if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                            break;
                        }
                    }
                    break;
                case 8:
                    //y--
                    for (int nY = 1; nY < 8; nY++) {
                        toX = posX;
                        toY = posY - nY;
                        if (!control(toX, toY, posX, posY, p, list, tempBoard)) {
                            break;
                        }
                    }
                    break;
            }
        }
    }

    void calculatePawnMoves(Piece p, int posX, int posY, List<Piece[][]> list, Piece[][] tempBoard) {
        for (int pawn = 1; pawn < 2; pawn++) {
            int toX, toY;
            switch (pawn) {
                case 1:
                    toX = posX + 2;
                    toY = posY;
                    if (!control(toX, toY, posX, posY, p, list, this.tempBoard)) {
                        break;
                    }
                    break;
                case 2:
                    toX = posX + 1;
                    toY = posY;
                    if (!control(toX, toY, posX, posY, p, list, this.tempBoard)) {
                        break;
                    }
                    break;
                case 3:
                    toX = posX + 1;
                    toY = posY - 1;
                    if (!control(toX, toY, posX, posY, p, list, this.tempBoard)) {
                        break;
                    }
                    break;
                case 4:
                    toX = posX + 1;
                    toY = posY + 1;
                    if (!control(toX, toY, posX, posY, p, list, this.tempBoard)) {
                        break;
                    }
                    break;
            }
        }
    }


    private boolean control(int toX, int toY, int x, int y, Piece curentPiece, List<Piece[][]> list, Piece[][] tempBoard) {
        //Piece[][] tempBoard = null;
        try {
            Piece toPiece = chessBoard[toX][toY];
            if (toX < 0 || toX > 7 || toY < 0 || toY > 7) {
            } else if (toPiece.getColor() != curentPiece.getColor()) {
                toPiece = new Piece();
                toPiece.setName(curentPiece.getName());
                toPiece.setColor(curentPiece.getColor());
                // tempBoard = clone(chessBoard);
                tempBoard[x][y].setName(null);
                tempBoard[x][y].setColor(null);
                tempBoard[toX][toY] = toPiece;
                list.add(tempBoard);
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

   /* Piece[][] clone(Piece[][] chessBoard) {
        Piece[][] newBoard = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece oldPiece = chessBoard[i][j];
                if (oldPiece != null) {
                    Piece newPiece = new Piece();
                    newPiece.setName(oldPiece.getName());
                    newPiece.setColor(oldPiece.getColor());
                    newBoard[i][j] = newPiece;
                }
            }
        }
        return newBoard;
    }*/
}



