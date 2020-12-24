package com.example.chess.service;

import com.example.chess.dto.Piece;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class Move {
    int horse1i = 0;
    int horse1j = 1;
    int horse2i = 0;
    int horse2j = 6;
    int newi1;
    int newj1;
    int newi2;
    int newj2;
    int i = 0;
    int j = 0;
    ChessService chessService = new ChessService();
    Piece[][] chessBoard = chessService.createBoard();
    public Piece[][] movePiece() {
        chessService.createBoard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Yapmak istediğiniz hamleyi seçiniz");
        int horse = scanner.nextInt();
        switch (horse) {
            case 1:
                newi1 = horse1i + 2;
                newj1 = horse1j + 1;
                newi2 = horse2i + 2;
                newj2 = horse2j + 1;
                control1();
                control2();
                break;
            case 2:
                newi1 = horse1i + 2;
                newj1 = horse1j - 1;
                newi2 = horse2i + 2;
                newj2 = horse2j - 1;
                control1();
                control2();
                break;
            case 3:
                newi1 = horse1i - 2;
                newj1 = horse1j - 1;
                newi2 = horse2i - 2;
                newj2 = horse2j - 1;
                control1();
                control2();
                break;
            case 4:
                newi1 = horse1i - 2;
                newj1 = horse1j + 1;
                newi2 = horse2i - 2;
                newj2 = horse2j + 1;
                control1();
                control2();
                break;
            case 5:
                newi1 = horse1i - 1;
                newj1 = horse1j - 2;
                newi2 = horse2i - 1;
                newj2 = horse2j - 2;
                control1();
                control2();
                break;
            case 6:
                newi1 = horse1i - 1;
                newj1 = horse1j + 2;
                newi2 = horse2i - 1;
                newj2 = horse2j + 2;
                control1();
                control2();
                break;
            case 7:
                newi1 = horse1i + 1;
                newj1 = horse1j - 2;
                newi2 = horse2i + 1;
                newj2 = horse2j - 2;
                control1();
                control2();
                break;
            case 8:
                newi1 = horse1i + 1;
                newj1 = horse1j + 2;
                newi2 = horse2i + 1;
                newj2 = horse2j + 2;
                control1();
                control2();
                break;
        }
        return chessBoard;
}
    private void control1() {
        if(newi1 <0 || newi1 >7 || newj1 <0 || newj1 >7 ){
            System.out.println("At 1 bu hamleyi yapamaz");
        }
        else if (!chessBoard[i][j].getColor().equals(chessBoard[newi1][newj1].getColor())) {
            String tempName = chessBoard[horse1i][horse1j].getName();
            String tempColor = chessBoard[horse1i][horse1j].getColor();
            chessBoard[horse1i][horse1j].setName(null);
            chessBoard[horse1i][horse1j].setColor(null);
            chessBoard[newi1][newj1].setName(tempName);
            chessBoard[newi1][newj1].setColor(tempColor);
        }
    }
    private void control2() {
        if (newi2 < 0 || newi2 > 7 || newj2 < 0 || newj2 > 7) {
            System.out.println("At 2 bu hamleyi yapamaz");
        } else if (!chessBoard[i][j].getColor().equals(chessBoard[newi2][newj2].getColor())) {
            String tempName = chessBoard[horse2i][horse2j].getName();
            String tempColor = chessBoard[horse2i][horse2j].getColor();
            chessBoard[horse2i][horse2j].setName(null);
            chessBoard[horse2i][horse2j].setColor(null);
            chessBoard[newi2][newj2].setName(tempName);
            chessBoard[newi2][newj2].setColor(tempColor);
        }
    }
    private List<Piece[][]> totalMove(){

        

        return totalMove();
    }
}

