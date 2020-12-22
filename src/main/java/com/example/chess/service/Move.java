package com.example.chess.service;

import com.example.chess.dto.Piece;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class Move {
    public List<List<Piece>> movePiece() {
        int x = 0;
        int y = 1;
        int z;
        int t;
        int i=0;
        int j=0;

        ChessService chessService = new ChessService();
        List<List<Piece>> chessBoard = chessService.createBoard();
        chessBoard.get(i).get(j);
        chessService.createBoard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Yapmak istediğiniz hamleyi seçiniz");
        int horse = scanner.nextInt();
        switch (horse) {
            case 1:
                z = x + 2;
                t = y + 1;
                if (!chessBoard.get(i).get(j).getColor().equals(chessBoard.get(z).get(t).getColor())) {
                    String tempName = chessBoard.get(x).get(y).getName();
                    String tempColor = chessBoard.get(x).get(y).getColor();
                    chessBoard.get(x).get(y).setName(null);
                    chessBoard.get(x).get(y).setColor(null);
                    chessBoard.get(z).get(t).setName(tempName);
                    chessBoard.get(z).get(t).setColor(tempColor);
                }
            break;
            case 2:
                z = x + 2;
                t = y - 1;
                if (!chessBoard.get(i).get(j).getColor().equals(chessBoard.get(z).get(t).getColor())) {
                    String tempName = chessBoard.get(x).get(y).getName();
                    String tempColor = chessBoard.get(x).get(y).getColor();
                    chessBoard.get(x).get(y).setName(null);
                    chessBoard.get(x).get(y).setColor(null);
                    chessBoard.get(z).get(t).setName(tempName);
                    chessBoard.get(z).get(t).setColor(tempColor);
                }
            break;
            case 3:
                z = x - 2;
                t = y - 1;
                if (!chessBoard.get(i).get(j).getColor().equals(chessBoard.get(z).get(t).getColor())) {
                    String tempName = chessBoard.get(x).get(y).getName();
                    String tempColor = chessBoard.get(x).get(y).getColor();
                    chessBoard.get(x).get(y).setName(null);
                    chessBoard.get(x).get(y).setColor(null);
                    chessBoard.get(z).get(t).setName(tempName);
                    chessBoard.get(z).get(t).setColor(tempColor);
                }
            break;
            case 4:
                z = x - 2;
                t = y + 1;
                if (!chessBoard.get(i).get(j).getColor().equals(chessBoard.get(z).get(t).getColor())) {
                    String tempName = chessBoard.get(x).get(y).getName();
                    String tempColor = chessBoard.get(x).get(y).getColor();
                    chessBoard.get(x).get(y).setName(null);
                    chessBoard.get(x).get(y).setColor(null);
                    chessBoard.get(z).get(t).setName(tempName);
                    chessBoard.get(z).get(t).setColor(tempColor);
                }
            break;
            case 5:
                z = x - 1;
                t = y - 2;
                if (!chessBoard.get(i).get(j).getColor().equals(chessBoard.get(z).get(t).getColor())) {
                    String tempName = chessBoard.get(x).get(y).getName();
                    String tempColor = chessBoard.get(x).get(y).getColor();
                    chessBoard.get(x).get(y).setName(null);
                    chessBoard.get(x).get(y).setColor(null);
                    chessBoard.get(z).get(t).setName(tempName);
                    chessBoard.get(z).get(t).setColor(tempColor);
                }
            break;
            case 6:
                z = x - 1;
                t = y + 2;
                if (!chessBoard.get(i).get(j).getColor().equals(chessBoard.get(z).get(t).getColor())) {
                    String tempName = chessBoard.get(x).get(y).getName();
                    String tempColor = chessBoard.get(x).get(y).getColor();
                    chessBoard.get(x).get(y).setName(null);
                    chessBoard.get(x).get(y).setColor(null);
                    chessBoard.get(z).get(t).setName(tempName);
                    chessBoard.get(z).get(t).setColor(tempColor);
                }
            break;
            case 7:
                z = x + 1;
                t = y - 2;
                if (!chessBoard.get(i).get(j).getColor().equals(chessBoard.get(z).get(t).getColor())) {
                    String tempName = chessBoard.get(x).get(y).getName();
                    String tempColor = chessBoard.get(x).get(y).getColor();
                    chessBoard.get(x).get(y).setName(null);
                    chessBoard.get(x).get(y).setColor(null);
                    chessBoard.get(z).get(t).setName(tempName);
                    chessBoard.get(z).get(t).setColor(tempColor);
                }
            break;
            case 8:
                z = x + 1;
                t = y + 2;
                if (!chessBoard.get(i).get(j).getColor().equals(chessBoard.get(z).get(t).getColor())) {
                    String tempName = chessBoard.get(x).get(y).getName();
                    String tempColor = chessBoard.get(x).get(y).getColor();
                    chessBoard.get(x).get(y).setName(null);
                    chessBoard.get(x).get(y).setColor(null);
                    chessBoard.get(z).get(t).setName(tempName);
                    chessBoard.get(z).get(t).setColor(tempColor);
                }
            break;
        }
        return chessBoard;
    }
}

