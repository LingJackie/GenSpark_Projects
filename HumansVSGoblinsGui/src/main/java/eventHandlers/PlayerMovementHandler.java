package eventHandlers;

import com.example.gamegui.HVG;
import com.example.gamegui.Human;
import com.example.gamegui.TileNode;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class PlayerMovementHandler implements EventHandler<KeyEvent>{
    private HVG game;
    private Human player; 

    public PlayerMovementHandler(HVG game){
        this.game = game;
        player = game.getPlayer();

    }


    @Override
    public void handle(KeyEvent key) {
        if(!player.isEngagedInCombat() && !player.isDead()){// Checks if player is dead or in combat
            switch (key.getCode()){
                case UP:
                    System.out.println(player.moveActor("n",game.getGameWorld().getWorldMap()));
                    break;
                case DOWN:
                    System.out.println(player.moveActor("s",game.getGameWorld().getWorldMap()));
                    break;
                case LEFT:
                    System.out.println(player.moveActor("w",game.getGameWorld().getWorldMap()));
                    break;
                case RIGHT:
                    System.out.println(player.moveActor("e",game.getGameWorld().getWorldMap()));
                    break;
            }
        }

    }

}
