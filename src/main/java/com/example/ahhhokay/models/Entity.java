package com.example.ahhhokay.models;


import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Entity {

    Point2D position;
    double x,y;
    float scale = 1;
    double width;
    double height;

    double gravity;
    double velX = 0, velY = 0;
    double MAX_SPEED = 10;

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public boolean isFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public double getMAX_SPEED() {
        return MAX_SPEED;
    }

    public void setMAX_SPEED(double MAX_SPEED) {
        this.MAX_SPEED = MAX_SPEED;
    }

    protected boolean jumping = false;
    protected boolean falling = true;

    Image entityImage;
//constructor for creating an entity needs and image but i think BufferedImage or something if wid animations or file
    public Entity(Image entityImage/*, double x, double y*/) {
        this.entityImage = entityImage;
        this.width = entityImage.getWidth(); //I SET THIS TO 64 LANG SA CUZ BLOCKS HAVE NO IMAGE YET
        System.out.println(this.width);
        this.height = entityImage.getHeight();
        System.out.println(this.height);
//        this.position = new Point2D(x,y);
//        this.gravity = 0;
    }

//     --------------------------POSITIONAL---------------------------
//    FOR CHANGING POSITIONS USING POINT2D CUZ WHY NOT, CAN BE REFACTORED TO BE X Y
    public Point2D getDrawPosition() {
        return position;
    }

    public void setDrawPosition(float x, float y) {
        this.position = new Point2D(x, y);
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public void move(Point2D vector) {
        this.position = this.position.add(vector);
    }


    public float getScale() {
        return scale;
    }



//     --------------------------IMAGE---------------------------
//   FOR IMAGE DETAILS PURPOSES

    public Image getImage() {
        return entityImage;
    }
    public double getWidth() {
        return this.width * getScale();
    }

    public double getHeight() {
        return this.height * getScale();
    }

//     --------------------------MOVEMENT---------------------------

//    private float MAX_SPEED = 5f;

    private Point2D currentLocation = new Point2D(0, 0);

//   CHARACTER MOVES EVERYTIME UPDATE IS CALLED IN GAMECONTROLLER
    public void update() {
        move(currentLocation);

    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}
