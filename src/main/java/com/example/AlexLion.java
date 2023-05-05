package com.example;


public class AlexLion extends Lion {

    public AlexLion(Feline feline) throws Exception {
        super(feline, "Самец");
    }

    public String getName() {
        return "Алекс";
    }
}
