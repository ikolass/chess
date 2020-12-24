package com.example.chess.resource;

//Lombok ile 2 boyutlu arraylistimin getter, setter ve toString metotlarını oluşturdum.

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
public class BoardResource {

    private List<String> chessBoard;

}

