package com.example.ahhhokay.models;
//  TODO IMMA IMPLEMENT THIS LATUR AFTER MIDTERMS


import com.example.ahhhokay.controls.ObjectId;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends Entity{
    private double gravity = 0.5f;
    ObjectId id;

    public Player(Image entityImage/*, double x, double y*/, ObjectId id) {
        super(entityImage/*,x,y*/);
        this.id = id;
    }
    public Rectangle getHitbox(){
        Point2D pos = this.getDrawPosition();
        Rectangle hitbox = new Rectangle(pos.getX(),pos.getY(),this.getWidth(),this.getHeight());
        hitbox.setFill(Color.TRANSPARENT);
        hitbox.setStroke(Color.RED);
        return hitbox;
    }
    public void jump() {
        // Apply upward velocity or change the player's position to simulate jumping
        // For example:

    }

}