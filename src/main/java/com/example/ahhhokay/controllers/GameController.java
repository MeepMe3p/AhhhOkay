package com.example.ahhhokay.controllers;


import com.example.ahhhokay.animation.GameLoopTimer;
import com.example.ahhhokay.controls.KeyInput;
import com.example.ahhhokay.controls.ObjectId;
import com.example.ahhhokay.mapStuff.FirstMap;
import com.example.ahhhokay.models.Block;
import com.example.ahhhokay.models.Player;
import com.example.ahhhokay.rendering.CollisionHandler;
import com.example.ahhhokay.rendering.Renderer;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.ahhhokay.mapStuff.FirstMap.blocks;


public class GameController implements Initializable {

    public Canvas gameCanvas;
    public AnchorPane gameAnchor;
    KeyInput keys = KeyInput.getInstance();

    private /*Entity*/ Player player = new Player/*Entity*/(new Image(getClass().getResourceAsStream("/img/hutao_uwu.png")),/*0,50,*/ ObjectId.PLAYER);
    private ArrayList<Block> tiles = FirstMap.blocks;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//      INITIALIZES THE CANVAS FOR DRAWING THE ENTITIES
        initialiseCanvas();
        System.out.println("aaaaaaa initialized");
        player.setDrawPosition(25, 150);
        player.setScale(0.5f);

        Renderer renderer = new Renderer(this.gameCanvas);
        renderer.addPlayer(player);
        renderer.addTiles(tiles);




//      ANIMATION TIMER
        GameLoopTimer timer = new GameLoopTimer() {
            @Override
            public void tick(float secondsSinceLastFrame) {
//                renderer.prepare();

                updatePlayerMovement(secondsSinceLastFrame);

                renderer.render();

                CollisionHandler colHand = new CollisionHandler(player,tiles);
                colHand.collision();
            }
        };
        timer.start();
    }
//  BINDS SO THAT WHEN YOU ADJUST THE ANCHOR PANE THE GAME CANVAS IS THE SAME SIZE
    private void initialiseCanvas() {
        gameCanvas.widthProperty().bind(gameAnchor.widthProperty());
        gameCanvas.heightProperty().bind(gameAnchor.heightProperty());



    }
//  TODO:FOR PLAYER MOVEMENT CAN BECOME MORE EFFICIENT PA I THINK IMMA DO IT LATER
//  DONEEEE I THINK THIS THE MOST EFFICIENT IDK
    private void updatePlayerMovement(float frameDuration) {
        Point2D newLocation =  Point2D.ZERO;
        if (keys.isDown(KeyCode.D)) {
            newLocation = newLocation.add(2,0);

        } else if (keys.isDown(KeyCode.A)) {
            newLocation = newLocation.add(-2,0);

        } else if(keys.isDown(KeyCode.W)){
            System.out.println("dddd");
            if( !player.isJumping()) {
                player.jump();
                System.out.println("aaa");
                newLocation = newLocation.add(0,-5);
                player.setFalling(true);
            }
//            player.setJumping(true);


        } else if(keys.isDown(KeyCode.S)){
            newLocation = newLocation.add(0,2);

        }

        if(player.isFalling()/*&& player.isJumping()*/){
            Point2D gravity = new Point2D(0,2);
            newLocation = newLocation.add(gravity);
//            player.setJumping(true);
        }
        player.move(newLocation);

        player.update();
    }
}
