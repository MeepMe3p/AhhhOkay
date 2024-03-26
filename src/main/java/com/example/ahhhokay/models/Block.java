package com.example.ahhhokay.models;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//      TODO: FOR NOW AKO LANG SA GIRECTANGLE KAY WALA PAKOY IMAGE PARA SA BLOCKS SO YEA
public class Block{
    Rectangle rect;
    double x,y;
    double width,height;

    public Block(Rectangle rect,double x,double y, double width, double height) {
        this.rect = rect;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public Rectangle getHitbox(){
        Rectangle hitbox = new Rectangle(this.getX(),this.getY(),this.getWidth(),this.getHeight());
        hitbox.setFill(Color.TRANSPARENT);
        hitbox.setStroke(Color.RED);
        return hitbox;
    }
}
