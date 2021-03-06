package com.example.chess.controller;

import com.example.chess.dto.Piece;
import com.example.chess.service.ChessService;
import com.example.chess.service.Move;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inital-board")
public class BoardController {

    @Autowired
    ChessService chessService;

    @Autowired
    Move move;


    @GetMapping("/create-board")
    public  Piece[][] createBoard() {
        return chessService.createBoard();
    }

    @GetMapping("/move")
    public List<Piece[][]> move() {
        return  move.movePiece();
    }



}
