package misc;
import static misc.Constants.spriteDimension;

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

    public void incrementX(){
        trueX++;
        updateGuiX();
    }
    public void decrementX(){
        trueX--;
        updateGuiX();
    }
    public void incrementY(){
        trueY++;
        updateGuiY();
    }
    public void decrementY(){
        trueY--;
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

    private void updateGuiX(){
        this.guiX=trueX*spriteDimension;
    }
    private void updateGuiY(){
        this.guiY=trueY*spriteDimension;
    }

}
