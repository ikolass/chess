package com.example.chess.type;

//Satranç taşlarının isim özelliğini enumla oluşturdum.
   public enum NameEnum {
    KING("SAH"),
    QUENN("VEZİR"),
    BISHOP("FIL"),
    HORSE("AT"),
    ROOK("KALE"),
    PAWN("PIYON");
    private final String name;

    NameEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}