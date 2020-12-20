package com.example.chess.service;

import com.example.chess.dto.Piece;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Move {
    public List<List<Piece>> movePiece() {
        int x = 0;
        int y = 1;
        int z;
        int t;
        int c;
        //int z = (int)(Math.random()*8);
        // int t = (int)(Math.random()*8);
        ChessService chessService = new ChessService();
        List<List<Piece>> chessBoard = chessService.createBoard();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == x && j == y) {
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
                }

              /* if (i == x && j == y) {
                    if(chessBoard.get(i).get(j).getColor() != chessBoard.get(z).get(t).getColor()) {
                        String tempName = chessBoard.get(x).get(y).getName();
                        String tempColor = chessBoard.get(x).get(y).getColor();
                        chessBoard.get(x).get(y).setName(null);
                        chessBoard.get(x).get(y).setColor(null);
                        chessBoard.get(z).get(t).setName(tempName);
                        chessBoard.get(z).get(t).setColor(tempColor);
                    }
                    else{
                        System.out.println("kendi tasinizin ustune koyamazsınız");
                    }
                }*/
            }
        }
        return chessBoard;
    }
}

