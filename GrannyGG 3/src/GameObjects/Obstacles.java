package GameObjects;

import Game.Map;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Obstacles extends GameObjects {


    private Rectangle obstacle;


    Obstacles() {
        super(false, ObjectType.OBSTACLES);

        //Arguments are not correct, just testing
        this.obstacle = new Rectangle(10,10,10,10);
    }

    @Override
    public void move(){
        super.move();
        int timeSpawn = (int) (Math.round(Math.random()*10));
        if(timeSpawn < 5){
            isVisible = true;
            obstacle.draw();
            moveLeft();
        }
    }

    @Override
    public void moveLeft(){
        super.moveLeft();
        //if getpositiionX == 0 position =<0 (n\ao pode andar mais para a esquerda)
        //else isto :
        obstacle.translate(-Map.cellSize, 0);


    }
}
