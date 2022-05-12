package inventory;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class InventoryNode extends StackPane {


    Rectangle inventorySlot;// Tile that's going to be displayed


    // Takes in a hex value
    public void setTileColor(String color){
        inventorySlot.setFill(Color.web(color));
    }
    public void setTileTexture(Image texture){
        inventorySlot.setFill(new ImagePattern(texture));
    }

    
    /*
        Constructor
        size -> Dimensions of the tile i.e. if size is 25 then tile would be 25x25
        x,y -> Coords on the grid
     */
    public InventoryNode(String tileName, double x, double y, int size){

        inventorySlot = new Rectangle(size,size);
        inventorySlot.setFill(Color.GREY);
        inventorySlot.setStroke(Color.BLACK);




        
        
        // set position
        setTranslateX(x*size);
        setTranslateY(y*size);
        getChildren().addAll(inventorySlot);
    }


}
