
package com.example.chess.dto;

import com.example.chess.type.ColorEnum;
import com.example.chess.type.NameEnum;
import lombok.Data;

@Data
public class Piece {

    NameEnum name;
    ColorEnum color;

}
