package com.example.ahhhokay.models;

import com.example.ahhhokay.Platform;
import javafx.scene.shape.Rectangle;

public class Hitbox {
    Player player;

    public Hitbox(Player player) {
        this.player = player;
    }
    public void drawHitbox(){
        Rectangle box = new Rectangle(player.getHeight(),player.getWidth());

    }
}
