package misc;
import com.example.gamegui.TileNode;

import static misc.Constants.SPRITE_DIMENSION;

public class Coord {

    // true x and y are the actual indices on the 2d array
    private int trueX;
    private int trueY;
    // gui x and y are the coordinates on the gui map
    private int guiX;
    private int guiY;

    public int getTrueX()   {return trueX;}
    public int getTrueY()   {return trueY;}
    public int getGuiX()    {return guiX;}
    public int getGuiY()    {return guiY;}

    public void setX(int x){
        this.trueX=x;
        updateGuiX();
    }
    public void setY(int y){
        this.trueY=y;
        updateGuiY();
    }



    // CONSTRUCTORS
    public Coord(){
        trueX=0;
        trueY=0;
        guiX=0;
        guiY=0;
    }
    public Coord(int trueX, int trueY){
        this.trueX=trueX;
        this.trueY=trueY;
        updateGuiX();
        updateGuiY();

    }

    public boolean incrementX(TileNode[][] world){
        try {
            TileNode tmp = world[trueX+1][trueY];// Checks if new coordinate is valid
            if(!tmp.isTraversable()) return false;
            trueX++;
            updateGuiX();
            return true;
        }catch(IndexOutOfBoundsException e){
            return false;
        }
    }
    public boolean decrementX(TileNode[][] world){
        try {
            TileNode tmp = world[trueX-1][trueY];// Checks if new coordinate is valid
            if(!tmp.isTraversable()) return false;
            trueX--;
            updateGuiX();
            return true;
        }catch(IndexOutOfBoundsException e){
            return false;
        }
    }
    public boolean incrementY(TileNode[][] world){
        try {
            TileNode tmp = world[trueX][trueY+1];// Checks if new coordinate is valid
            if(!tmp.isTraversable()) return false;
            trueY++;
            updateGuiY();
            return true;
        }catch(IndexOutOfBoundsException e){
            return false;
        }
    }
    public boolean decrementY(TileNode[][] world){
        try {
            TileNode tmp = world[trueX][trueY-1];// Checks if new coordinate is valid
            if(!tmp.isTraversable()) return false;
            trueY--;
            updateGuiY();
            return true;
        }catch(IndexOutOfBoundsException e){
            return false;
        }
    }


    private void updateGuiX(){
        this.guiX=trueX*SPRITE_DIMENSION;
    }
    private void updateGuiY(){
        this.guiY=trueY*SPRITE_DIMENSION;
    }

    @Override
    public String toString() {
        return "("+trueX+","+trueY+")";
    }

    @Override
    public boolean equals(Object o) {
        Coord c = (Coord) o;
        return this.trueX == c.getTrueX() && this.trueY == c.getTrueY();
    }
}
