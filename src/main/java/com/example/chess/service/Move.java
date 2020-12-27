package com.example.chess.service;

import com.example.chess.dto.Piece;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;

@Service
public class Move {
    int horse1i = 3;
    int horse1j = 3;
    int horse2i = 3;
    int horse2j = 4;
    int newi1;
    int newj1;
    int i = 0;
    int j = 0;

    ChessService chessService = new ChessService();
    Piece[][] chessBoard = chessService.createBoard();
    List<Piece> list = new ArrayList<Piece>();

    public List<Piece> movePiece() {
        // chessService.createBoard();
        //int horse = 1;
     for (int a = 0; a < 2; a++) {
            for (int horse = 1; horse < 9; horse++) {
                switch (horse) {
                    case 1:
                        newi1 = horse1i + 2;
                        newj1 = horse1j + 1;
                        control1();
                        break;
                    case 2:
                        newi1 = horse1i + 2;
                        newj1 = horse1j - 1;
                        control1();
                        break;
                    case 3:
                        newi1 = horse1i - 2;
                        newj1 = horse1j - 1;
                        control1();
                        break;
                    case 4:
                        newi1 = horse1i - 2;
                        newj1 = horse1j + 1;
                        control1();
                        break;
                    case 5:
                        newi1 = horse1i - 1;
                        newj1 = horse1j - 2;
                        control1();
                        break;
                    case 6:
                        newi1 = horse1i - 1;
                        newj1 = horse1j + 2;
                        control1();
                        break;
                    case 7:
                        newi1 = horse1i + 1;
                        newj1 = horse1j - 2;
                        control1();
                        break;
                    case 8:
                        newi1 = horse1i + 1;
                        newj1 = horse1j + 2;
                        control1();
                        break;
                }
            }

           horse1i = horse2i;
          horse1j = horse2j;
        }
        return list;
    }

    private List<Piece> control1() {
        if (newi1 < 0 || newi1 > 7 || newj1 < 0 || newj1 > 7) {
            System.out.println("At 1 bu hamleyi yapamaz");
        } else if (!chessBoard[i][j].getColor().equals(chessBoard[newi1][newj1].getColor())) {
            Piece piece = new Piece();
            String tempName = chessBoard[horse1i][horse1j].getName();
            String tempColor = chessBoard[horse1i][horse1j].getColor();
            //chessBoard[horse1i][horse1j].setName(null);
            //chessBoard[horse1i][horse1j].setColor(null);
            chessBoard[newi1][newj1].setName(tempName);
            chessBoard[newi1][newj1].setColor(tempColor);
            piece.setName(tempName);
            piece.setColor(tempColor);
            chessBoard[newi1][newj1] = piece;
            list.add(piece);
        }
        return list;
    }
}
