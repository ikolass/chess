package com.example.chess.type;

//Satranç taşlarının renk özelliğini enumla oluşturdum.
public enum ColorEnum {
    BLACK("SIYAH"),
    WHITE("BEYAZ");

    private final String color;

    ColorEnum(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
