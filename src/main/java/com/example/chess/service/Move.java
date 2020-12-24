package com.example.chess.service;

import com.example.chess.dto.Piece;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class Move {
    int x = 0;
    int y = 1;
    int z;
    int t;
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
                z = x + 2;
                t = y + 1;
               control();
                break;
          case 2:
                z = x + 2;
                t = y - 1;
              control();
                break;
            case 3:
                z = x - 2;
                t = y - 1;
                control();
                break;
            case 4:
                z = x - 2;
                t = y + 1;
                control();
                break;
            case 5:
                z = x - 1;
                t = y - 2;
                control();
                break;
            case 6:
                z = x - 1;
                t = y + 2;
                control();
                break;
            case 7:
                z = x + 1;
                t = y - 2;
                control();
                break;
            case 8:
                z = x + 1;
                t = y + 2;
                control();
                break;
        }
        return chessBoard;
}
    private void control() {
        if(z<0 || z>7 || t<0 || t>7 ){
            System.out.println("bu işlemi gerçekleştiremezsiniz");
        }
        else if (chessBoard[i][j].getColor()!=chessBoard[z][t].getColor()) {
            String tempName=chessBoard[x][y].getName();
            String tempColor = chessBoard[x][y].getColor();
            chessBoard[x][y].setName(null);
            chessBoard[x][y].setColor(null);
            chessBoard[z][t].setName(tempName);
            chessBoard[z][t].setColor(tempColor);
        }
    }

}

