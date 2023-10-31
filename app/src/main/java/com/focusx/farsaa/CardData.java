package com.focusx.farsaa;

public class CardData {
    private int imageResource;
    private String text;

    public CardData(int imageResource, String text) {
        this.imageResource = imageResource;
        this.text = text;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText() {
        return text;
    }
}

