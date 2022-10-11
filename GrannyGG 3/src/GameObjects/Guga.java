package GameObjects;

import Game.Map;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Guga extends GameObjects implements KeyboardHandler {

    private int humor;
    private Picture guga;
    private double posX;
    private double posY;
    private double velX = 1;
    private double velY = 1;
    private int previousKey;

    public Guga(double x, double y){
        super(false, ObjectType.GUGA);
        this.posX = x;
        this.posY = y;
        this.humor = 0;
        this.guga = new Picture(posY , posX ,"Guga.png");
        guga.draw();
    }

    //missing colision with other platforms, if ide is implemented
    // velY = 1;
    public void gravity(Map map) {
       if(!(guga.getY() >=  map.getHeight() - Map.Padding*7.5)){
            guga.translate(0, velY*100);
        }else{
           posY = (int) (map.getHeight() - Map.Padding*7.5);
       }

    }
    public void keyboardInit(){
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent jump = new KeyboardEvent();
        jump.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        jump.setKey(KeyboardEvent.KEY_SPACE);

        keyboard.addEventListener(moveLeft);
        keyboard.addEventListener(moveRight);
        keyboard.addEventListener(jump);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch(keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                guga.translate(-velX*10, 0);
                previousKey = KeyboardEvent.KEY_LEFT;

                break;
            case KeyboardEvent.KEY_RIGHT:
                guga.translate(velX*10, 0);
                previousKey = KeyboardEvent.KEY_RIGHT;

                break;
            case KeyboardEvent.KEY_SPACE:
                if(guga.getY() != guga.getY() + 200) {
                    if (previousKey == KeyboardEvent.KEY_LEFT) {
                        guga.translate(0, -velY * 300);
                    } else {
                        guga.translate(0, -velY * 300);
                    }
                }
                break;
        }

    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
