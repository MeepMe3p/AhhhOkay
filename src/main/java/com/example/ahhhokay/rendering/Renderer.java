package com.example.ahhhokay.rendering;


import com.example.ahhhokay.mapStuff.FirstMap;
import com.example.ahhhokay.models.Block;
import com.example.ahhhokay.models.Entity;
import com.example.ahhhokay.models.Player;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

import static com.example.ahhhokay.mapStuff.FirstMap.blocks;

public class Renderer {

    Canvas canvas;
    GraphicsContext context;

    Image background;

    List<Player> entities = new ArrayList<>();
    List<Block> tiles = new ArrayList<>();

    public Renderer(Canvas canvas) {
        this.canvas = canvas;
        this.context = canvas.getGraphicsContext2D();
    }

    public void addPlayer(Player entity) {
        entities.add(entity);

    }
    public void addTiles(ArrayList<Block> tile){
        tiles.addAll(tile);
    }


    public void setBackground(Image background) {
        this.background = background;
    }

    public void render() {
//        context.save();

        //CLEARS EVERYTME IT RENDERS TO MAKE TRAILING DISAPPEAR
        context.clearRect(0,0,canvas.getWidth(),canvas.getHeight());

        //draws the entities and hitboxes
        for (Entity entity : entities) {
            if(entity instanceof Player){
                Point2D pos = entity.getDrawPosition();
                context.drawImage(entity.getImage(), pos.getX(), pos.getY(), entity.getWidth(), entity.getHeight());
//          for showing the hitbox in scene for debugging purposes
                Rectangle hitbox = ((Player) entity).getHitbox();
                context.strokeRect(hitbox.getX(),hitbox.getY(),hitbox.getWidth(),hitbox.getHeight());

            }

           }
        for(Block b: tiles){
            Rectangle hitbox = b.getHitbox();
            context.strokeRect(hitbox.getX(),hitbox.getY(),hitbox.getWidth(),hitbox.getHeight());
        }


//        context.restore();
    }





}

