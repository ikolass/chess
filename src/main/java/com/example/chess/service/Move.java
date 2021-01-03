package com.example.chess.service;

import com.example.chess.dto.Piece;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.chess.type.ColorEnum.BLACK;
import static com.example.chess.type.ColorEnum.WHITE;
import static com.example.chess.type.NameEnum.*;

@Service
public class Move {

    ChessService chessService = new ChessService();
    Piece[][] chessBoard = chessService.createBoard();
    List<Piece[][]> possibleMoves = new ArrayList<>();

    public List<Piece[][]> movePiece() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece p = chessBoard[i][j];
                /*if (p.getName() == HORSE && p.getColor() == BLACK) {
                    calculateHorseMoves(p, i, j, possibleMoves);
                }*/
                if (p.getName() == PAWN && p.getColor() == BLACK) {
                    calculatePawnMoves(p, i, j, possibleMoves);
                }
                /*if (p.getName() == ROOK && p.getColor() == BLACK) {
                    calculateRookMoves(p, i, j, possibleMoves);
                }*/
               /* if (p.getName() == KING && p.getColor() == BLACK) {
                    calculateKingMoves(p, i, j, possibleMoves);
                }*/
               /* if (p.getName() == BISHOP && p.getColor() == BLACK) {
                    calculateBishopMoves(p, i, j, possibleMoves);
                }*/
              /*  if (p.getName() == QUENN && p.getColor() == BLACK) {
                    calculateQuennMoves(p, i, j, possibleMoves);
                }*/

            }
        }
        return possibleMoves;
    }

    /*void calculateQuennMoves(Piece p, int posX, int posY, List<Piece[][]> list) {
        for (int quenn = 1; quenn < 9; quenn++) {
            int toX, toY;
            int newX, newY;
            switch (quenn) {
                case 1:
                    for (int pos = 1; pos < 8; pos++) {
                        try {
                            Piece controlPiece = chessBoard[posX + pos][posY + pos];
                            newX = posX + pos;
                            newY = posY + pos;
                            if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
                            } else if (controlPiece.getColor() == BLACK) {
                                break;
                            } else if (controlPiece.getColor() == WHITE) {
                                toX = posX + pos;
                                toY = posY + pos;
                                control(toX, toY, posX, posY, p, list);
                                break;
                            } else {
                                toX = posX + pos;
                                toY = posY + pos;
                                control(toX, toY, posX, posY, p, list);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
                case 2:
                    //x++,y--
                    for (int pos = 1; pos < 8; pos++) {
                        try {
                            Piece controlPiece = chessBoard[posX + pos][posY - pos];
                            newX = posX + pos;
                            newY = posY - pos;
                            if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
                            } else if (controlPiece.getColor() == BLACK) {
                                break;
                            } else if (controlPiece.getColor() == WHITE) {
                                toX = posX + pos;
                                toY = posY - pos;
                                control(toX, toY, posX, posY, p, list);
                                break;
                            } else {
                                toX = posX + pos;
                                toY = posY - pos;
                                control(toX, toY, posX, posY, p, list);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
                case 3:
                    //x--,y++
                    for (int pos = 1; pos < 8; pos++) {
                        try {
                            Piece controlPiece = chessBoard[posX - pos][posY + pos];
                            newX = posX - pos;
                            newY = posY + pos;
                            if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
                            } else if (controlPiece.getColor() == BLACK) {
                                break;
                            } else if (controlPiece.getColor() == WHITE) {
                                toX = posX - pos;
                                toY = posY + pos;
                                control(toX, toY, posX, posY, p, list);
                                break;
                            } else {
                                toX = posX - pos;
                                toY = posY + pos;
                                control(toX, toY, posX, posY, p, list);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
                case 4:
                    //x--,y--
                    for (int pos = 1; pos < 8; pos++) {
                        try {
                            Piece controlPiece = chessBoard[posX - pos][posY - pos];
                            newX = posX - pos;
                            newY = posY - pos;
                            if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
                            } else if (controlPiece.getColor() == BLACK) {
                                break;
                            } else if (controlPiece.getColor() == WHITE) {
                                toX = posX - pos;
                                toY = posY - pos;
                                control(toX, toY, posX, posY, p, list);
                                break;
                            } else {
                                toX = posX - pos;
                                toY = posY - pos;
                                control(toX, toY, posX, posY, p, list);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
                case 5:
                    //x++
                    for (int pX = 1; pX < 8; pX++) {
                        try {
                            Piece controlPiece = chessBoard[posX + pX][posY];
                            newX = posX + pX;
                            if (newX < 0 || newX > 7) {
                            } else if (controlPiece.getColor() == BLACK) {
                                break;
                            } else if (controlPiece.getColor() == WHITE) {
                                toX = posX + pX;
                                toY = posY;
                                control(toX, toY, posX, posY, p, list);
                                break;
                            } else {
                                toX = posX + pX;
                                toY = posY;
                                control(toX, toY, posX, posY, p, list);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
                case 6:
                    //x--
                    for (int nX = 1; nX < 8; nX++) {
                        try {
                            Piece controlPiece = chessBoard[posX - nX][posY];
                            newX = posX - nX;
                            if (newX < 0 || newX > 7) {
                            } else if (controlPiece.getColor() == BLACK) {
                                break;
                            } else if (controlPiece.getColor() == WHITE) {
                                toX = posX - nX;
                                toY = posY;
                                control(toX, toY, posX, posY, p, list);
                                break;
                            } else {
                                toX = posX - nX;
                                toY = posY;
                                control(toX, toY, posX, posY, p, list);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
                case 7:
                    //y++
                    for (int pY = 1; pY < 8; pY++) {
                        try {
                            Piece controlPiece = chessBoard[posX][posY + pY];
                            newY = posY + pY;
                            if (newY < 0 || newY > 7) {
                            } else if (controlPiece.getColor() == BLACK) {
                                break;
                            } else if (controlPiece.getColor() == WHITE) {
                                toX = posX;
                                toY = posY + pY;
                                control(toX, toY, posX, posY, p, list);
                                break;
                            } else {
                                toX = posX;
                                toY = posY + pY;
                                control(toX, toY, posX, posY, p, list);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
                case 8:
                    //y--
                    for (int nY = 1; nY < 8; nY++) {
                        try {
                            Piece controlPiece = chessBoard[posX][posY - nY];
                            newY = posY - nY;
                            if (newY < 0 || newY > 7) {
                            } else if (controlPiece.getColor() == BLACK) {
                                break;
                            } else if (controlPiece.getColor() == WHITE) {
                                toX = posX;
                                toY = posY - nY;
                                control(toX, toY, posX, posY, p, list);
                                break;
                            } else {
                                toX = posX;
                                toY = posY - nY;
                                control(toX, toY, posX, posY, p, list);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
            }
        }
    }*/
    /*void calculateBishopMoves(Piece p, int posX, int posY, List<Piece[][]> list) {
        for (int bishop = 1; bishop < 5; bishop++) {
            int toX, toY;
            int newX, newY;
            switch (bishop) {
                case 1:
                    //x++,y++
                    for (int pos = 1; pos < 8; pos++) {
                        try {
                            Piece controlPiece = chessBoard[posX + pos][posY + pos];
                            newX = posX + pos;
                            newY = posY + pos;
                            if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
                            } else if (controlPiece.getColor() == WHITE) {
                                toX = posX + pos;
                                toY = posY + pos;
                                control(toX, toY, posX, posY, p, list);
                            } else {
                                toX = posX + pos;
                                toY = posY + pos;
                                control(toX, toY, posX, posY, p, list);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
                case 2:
                    //x++,y--
                    for (int pos = 1; pos < 8; pos++) {
                        try {
                            Piece controlPiece = chessBoard[posX + pos][posY - pos];
                            newX = posX + pos;
                            newY = posY - pos;
                            if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
                            } else if (controlPiece.getColor() == WHITE) {
                                toX = posX + pos;
                                toY = posY - pos;
                                control(toX, toY, posX, posY, p, list);
                            } else {
                                toX = posX + pos;
                                toY = posY - pos;
                                control(toX, toY, posX, posY, p, list);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
                case 3:
                    //x--,y++
                    for (int pos = 1; pos < 8; pos++) {
                        try {
                            Piece controlPiece = chessBoard[posX - pos][posY + pos];
                            newX = posX - pos;
                            newY = posY + pos;
                            if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
                            } else if (controlPiece.getColor() == WHITE) {
                                toX = posX - pos;
                                toY = posY + pos;
                                control(toX, toY, posX, posY, p, list);
                            } else {
                                toX = posX - pos;
                                toY = posY + pos;
                                control(toX, toY, posX, posY, p, list);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
                case 4:
                    //x--,y--
                    for (int pos = 1; pos < 8; pos++) {
                        try {
                            Piece controlPiece = chessBoard[posX - pos][posY - pos];
                            newX = posX - pos;
                            newY = posY - pos;
                            if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
                            } else if (controlPiece.getColor() == WHITE) {
                                toX = posX - pos;
                                toY = posY - pos;
                                control(toX, toY, posX, posY, p, list);
                            } else {
                                toX = posX - pos;
                                toY = posY - pos;
                                control(toX, toY, posX, posY, p, list);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
            }
        }
    }*/
    /* void calculateKingMoves(Piece p, int posX, int posY, List<Piece[][]> list) {
        for (int king = 1; king < 9; king++) {
            int toX, toY;
            switch (king) {
                case 1:
                    // x+1,y-1
                    toX = posX + 1;
                    toY = posY - 1;
                    control(toX, toY, posX, posY, p, list);
                    break;
                case 2:
                    //x+1,y
                    toX = posX + 1;
                    toY = posY;
                    control(toX, toY, posX, posY, p, list);
                    break;
                case 3:
                    //x+1,y+1
                    toX = posX + 1;
                    toY = posY + 1;
                    control(toX, toY, posX, posY, p, list);
                    break;
                case 4:
                    //x,y+1
                    toX = posX;
                    toY = posY + 1;
                    control(toX, toY, posX, posY, p, list);
                    break;
                case 5:
                    //x-1,y+1
                    toX = posX - 1;
                    toY = posY + 1;
                    control(toX, toY, posX, posY, p, list);
                    break;
                case 6:
                    //x-1,y
                    toX = posX - 1;
                    toY = posY;
                    control(toX, toY, posX, posY, p, list);
                    break;
                case 7:
                    //x-1,y-1
                    toX = posX -1;
                    toY = posY-1;
                    control(toX, toY, posX, posY, p, list);
                    break;
                case 8:
                    //x,y-1
                    toX = posX;
                    toY = posY-1;
                    control(toX, toY, posX, posY, p, list);
                    break;
            }
        }
    }*/
    /*  void calculateRookMoves(Piece p, int posX, int posY, List<Piece[][]> list) {
        for (int rook = 1; rook < 5; rook++) {
            int toX, toY;
            int newX, newY;
            switch (rook) {
                case 1:
                    //x++
                    for (int pX = 1; pX < 8; pX++) {
                        try {
                            Piece controlPiece = chessBoard[posX + pX][posY];
                            newX = posX + pX;
                            if (newX < 0 || newX > 7) {
                            }else if (controlPiece.getColor() == BLACK) {
                                break;
                            } else if (controlPiece.getColor() == WHITE) {
                                toX = posX + pX;
                                toY = posY;
                                control(toX, toY, posX, posY, p, list);
                                break;
                            } else {
                                toX = posX + pX;
                                toY = posY;
                                control(toX, toY, posX, posY, p, list);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
                case 2:
                    //x--
                    for (int nX = 1; nX < 8; nX++) {
                        try {
                            Piece controlPiece = chessBoard[posX - nX][posY];
                            newX = posX - nX;
                            if (newX < 0 || newX > 7) {
                            }else if (controlPiece.getColor() == BLACK) {
                                break;
                            } else if (controlPiece.getColor() == WHITE) {
                                toX = posX - nX;
                                toY = posY;
                                control(toX, toY, posX, posY, p, list);
                                break;
                            } else {
                                toX = posX - nX;
                                toY = posY;
                                control(toX, toY, posX, posY, p, list);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
                case 3:
                    //y++
                    for (int pY = 1; pY < 8; pY++) {
                        try {
                            Piece controlPiece = chessBoard[posX][posY + pY];
                            newY = posY + pY;
                            if (newY < 0 || newY > 7) {
                            }else if (controlPiece.getColor() == BLACK) {
                                break;
                            } else if (controlPiece.getColor() == WHITE) {
                                toX = posX;
                                toY = posY + pY;
                                control(toX, toY, posX, posY, p, list);
                                break;
                            } else {
                                toX = posX;
                                toY = posY + pY;
                                control(toX, toY, posX, posY, p, list);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
                case 4:
                    //y--
                    for (int nY = 1; nY < 8; nY++) {
                        try {
                            Piece controlPiece = chessBoard[posX][posY - nY];
                            newY = posY - nY;
                            if (newY < 0 || newY > 7) {
                            } else if (controlPiece.getColor() == BLACK) {
                                break;
                            }else if (controlPiece.getColor() == WHITE) {
                                toX = posX;
                                toY = posY - nY;
                                control(toX, toY, posX, posY, p, list);
                                break;
                            } else {
                                toX = posX;
                                toY = posY - nY;
                                control(toX, toY, posX, posY, p, list);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
            }
        }
    }*/
    void calculatePawnMoves(Piece p, int posX, int posY, List<Piece[][]> list) {
        for (int pawn = 1; pawn < 4; pawn++) {
            int toX, toY;
            int newX, newY;
            switch (pawn) {
                case 1:
                    try {
                        Piece controlPiece = chessBoard[posX + 1][posY + 1];
                        if (controlPiece.getColor() == BLACK) {
                            break;
                        } else {
                            toX = posX + 2;
                            toY = posY;
                            control(toX, toY, posX, posY, p, list);
                        }
                    } catch (Exception e) {
                    }
                    break;
                case 2:
                    toX = posX + 1;
                    toY = posY;
                    control(toX, toY, posX, posY, p, list);
                    break;
                case 3:
                    newX = posX + 1;
                    newY = posY - 1;
                    if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
                    } else {
                        Piece controlPiece = chessBoard[posX + 1][posY - 1];
                        toX = posX + 1;
                        toY = posY + 1;
                        if (controlPiece.getColor() == WHITE) {
                            control(toX, toY, posX, posY, p, list);
                        }
                    }
                    break;
                case 4:
                    newX = posX + 1;
                    newY = posY + 1;
                    if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
                    } else {
                        Piece controlPiece = chessBoard[posX + 1][posY + 1];
                        toX = posX + 1;
                        toY = posY + 1;
                        if (controlPiece.getColor() == WHITE) {
                            control(toX, toY, posX, posY, p, list);
                        }
                    }

                    break;
            }
        }
    }
    /*  void calculateHorseMoves(Piece p, int posX, int posY, List<Piece[][]> list) {
        for (int horse = 1; horse < 9; horse++) {
            int toX, toY;
            switch (horse) {
                case 1:
                    toX = posX + 2;
                    toY = posY + 1;
                    control(toX, toY, posX, posY, p, list);
                    break;
                case 2:
                    toX = posX + 2;
                    toY = posY - 1;
                    control(toX, toY, posX, posY, p, list);
                    break;
                case 3:
                    toX = posX - 2;
                    toY = posY - 1;
                    control(toX, toY, posX, posY, p, list);
                    break;
                case 4:
                    toX = posX - 2;
                    toY = posY + 1;
                    control(toX, toY, posX, posY, p, list);
                    break;
                case 5:
                    toX = posX - 1;
                    toY = posY - 2;
                    control(toX, toY, posX, posY, p, list);
                    break;
                case 6:
                    toX = posX - 1;
                    toY = posY + 2;
                    control(toX, toY, posX, posY, p, list);
                    break;
                case 7:
                    toX = posX + 1;
                    toY = posY - 2;
                    control(toX, toY, posX, posY, p, list);
                    break;
                case 8:
                    toX = posX + 1;
                    toY = posY + 2;
                    control(toX, toY, posX, posY, p, list);
                    break;
            }
        }
    }*/

    private List<Piece[][]> control(int toX, int toY, int x, int y, Piece curentPiece, List<Piece[][]> list) {
        try {
            Piece toPiece = chessBoard[toX][toY];
            if (toX < 0 || toX > 7 || toY < 0 || toY > 7) {
            } else if (toPiece.getColor() != curentPiece.getColor()) {
                toPiece = new Piece();
                toPiece.setName(curentPiece.getName());
                toPiece.setColor(curentPiece.getColor());
                Piece[][] tempBoard = clone(chessBoard);
                tempBoard[x][y].setName(null);
                tempBoard[x][y].setColor(null);
                tempBoard[toX][toY] = toPiece;
                list.add(tempBoard);
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
                }
            }
        }
        return newBoard;
    }
}



