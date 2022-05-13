package com.example.gamegui;

import javafx.scene.image.Image;
import misc.Constants;
import misc.PerlinNoise;

import static misc.Constants.SPRITE_DIMENSION;

public class GameWorld {

    private TileNode[][] worldMap;

    public boolean isOutOfBounds(int x, int y){
        try{
            TileNode stuff = worldMap[x][y];
            return false;
        }catch(Exception e){
            return true;
        }
    }

    public TileNode getTile(int x, int y){
        return worldMap[x][y];
    }
    public TileNode[][] getWorldMap(){
        return worldMap;
    }
    public int length(){
        return worldMap.length;
    }
    public int width(){
        return worldMap[0].length;
    }

    // Constructor
    public GameWorld(int length, int width){
        generateRandMap(length,width);
    }


    // Creates a new world map of size: size x (size*3)
    // Uses perlin noise
    public void generateRandMap(int length, int width){

        worldMap = new TileNode[length][width];
        double scale = .045;// Play around with it should be under 0.1
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++) {
                double noiseVal = PerlinNoise.noise(i * scale, j * scale, 7);// Generates number between -1 and 1
                if (noiseVal < -.3) {// Water
                    worldMap[i][j] = new TileNode(i,j,SPRITE_DIMENSION,false);
                    worldMap[i][j].setTileColor("#4BB6EF");
                } else if (noiseVal < -.25) {// Sand
                    worldMap[i][j] = new TileNode(i,j,SPRITE_DIMENSION,true);
                    worldMap[i][j].setTileColor("#C2B280");
                } else if (noiseVal < 0) {// Grasslands
                    worldMap[i][j] = new TileNode(i,j,SPRITE_DIMENSION,true);
                    //worldMap[i][j].setTileColor("#398c0a");
                    Image img = new Image(getClass().getResourceAsStream("grass.jpg"));
                    worldMap[i][j].setTileTexture(img);
                } else if (noiseVal < .2) {// Forest1
                    worldMap[i][j] = new TileNode(i,j,SPRITE_DIMENSION,true);
                    worldMap[i][j].setTileColor("#327c09");
                } else if (noiseVal < .3) {// Forest2
                    worldMap[i][j] = new TileNode(i,j,SPRITE_DIMENSION,true);
                    worldMap[i][j].setTileColor("#2c6d08");
                } else if (noiseVal < .4) {// Low Hills
                    worldMap[i][j] = new TileNode(i,j,SPRITE_DIMENSION,true);
                    worldMap[i][j].setTileColor("#265d07");
                } else if (noiseVal < .6) {// Tall Hills
                    worldMap[i][j] = new TileNode(i,j,SPRITE_DIMENSION,true);
                    worldMap[i][j].setTileColor("#567d46");
                } else if (noiseVal <= 1) {// Mountain
                    worldMap[i][j] = new TileNode(i,j,SPRITE_DIMENSION,true);
                }
                worldMap[i][j].setTileLabel(i +"," +j);
            }
        }
    }

    @Override
    public String toString() {
        String tmp = "";
        for(TileNode[] row:worldMap){
            for(TileNode s:row){
                tmp+= s.toString();
            }
            tmp+="\n";
        }
        return tmp;
    }
}
