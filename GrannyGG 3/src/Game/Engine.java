package Game;


import Game.Screens.Level1;
import GameObjects.Guga;
import GameObjects.ObjectFactory;

public class Engine {

    private int delay;
    private Map map;
    private ObjectFactory factory;

    private Guga guga;


    public Engine(int delay){
        this.delay = delay;
        this.map = new Map();
        this.factory = new ObjectFactory();
        //map.getStartGame();
        map.getLevel1();
        this.guga = factory.spawnGuga( map.getHeight() -Map.Padding *7.5,map.getY() + Map.Padding );
        //map.getLevel2();



    }


    public void startGame(){
        guga.keyboardInit();
        while(true) {
            //slows down game, so we see it happen, and not just the result

            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());

            }

            guga.gravity(map);


        }

        //StartGame startGame = new StartGame();




    }
}
