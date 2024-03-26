package com.example.ahhhokay.rendering;

import com.example.ahhhokay.models.Block;
import com.example.ahhhokay.models.Player;

import java.util.ArrayList;

//  TODO IMMA CHANGE THE PLAYER INTO AN ARRAY LATER, OR I THINK TO MAKE IT LESS REDUNDANT IMMA PLACE IT ALL IN AN ENTITY ARRAY, FOR NOW WALA LANG SA NAKO GIENTITY ANG BLOCK
//    CUZ WALA PAY IMAGE ANG TILES
//
public class CollisionHandler {
//    ArrayList<Player> players;
    ArrayList<Block> blocks;
    Player players;

    public CollisionHandler(Player players, ArrayList<Block> blocks) {
        this.players = players;
        this.blocks = blocks;
    }

    public void collision(){
        for(Block b: blocks){
            if(b.getHitbox().intersects(players.getHitbox().getBoundsInParent())){
                players.setDrawPosition((float) (players.getDrawPosition().getX()), (float) (players.getDrawPosition().getY()-2));
//                System.out.println("collision");
                players.setFalling(false);
                players.setJumping(false);

            }else{
                players.setFalling(true);
//                System.out.println("is falling");
            }
        }
    }

}
