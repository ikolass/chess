package com.example.chess.resource;

//Lombok ile 2 boyutlu arraylistimin getter, setter ve toString metotlarını oluşturdum.

import com.example.chess.dto.Piece;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardResource {
    private Piece[][] chessBoard;
}

