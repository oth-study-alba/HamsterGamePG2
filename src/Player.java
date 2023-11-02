import java.util.Scanner;

public class Player
{

    //-----------------------------------------------------------------------
    //Variables
    public PositionAndOrientation playerPosition = PositionAndOrientation.getInstance();
    private final Map map = Map.getInstance();
    public int score;

    //-----------------------------------------------------------------------
    //General Methods
    private void spawn()
    {
        playerPosition.setX(1);
        playerPosition.setY(1);
    }

    private String playerSpirit()
    {
        String spirit = " ^ ";
        switch(playerPosition.getOrientation())
        {
            case UP:
                spirit = " ^ ";
                break;
            case DOWN:
                spirit = " ˅ ";
                break;
            case LEFT:
                spirit = " < ";
                break;
            case RIGHT:
                spirit = " > ";
                break;
        }
    return spirit;
    }

    public void control (String input){
            switch(input.toLowerCase())
            {
                case "w":
                    forward();
                    break;
                case "a":
                     rotateLeft();
                     break;
                case "d":
                    rotateRight();
                    break;

            }

    }

    //-----------------------------------------------------------------------
    //Movement Methods
    public void rotateLeft(){
        switch(playerPosition.getOrientation())
        {
            case UP:
                playerPosition.setOrientation(Orientation.LEFT);
                break;
            case DOWN:
                playerPosition.setOrientation(Orientation.RIGHT);
                break;
            case LEFT:
                playerPosition.setOrientation(Orientation.DOWN);
                break;
            case RIGHT:
                playerPosition.setOrientation(Orientation.UP);
                break;
        }

    }

    public void rotateRight(){
        switch(playerPosition.getOrientation())
        {
            case UP:
                playerPosition.setOrientation(Orientation.RIGHT);
                break;
            case DOWN:
                playerPosition.setOrientation(Orientation.LEFT);
                break;
            case LEFT:
                playerPosition.setOrientation(Orientation.UP);
                break;
            case RIGHT:
                playerPosition.setOrientation(Orientation.DOWN);
                break;
        }
    }

    public void forward() {
        int nextX;
        int nextY;
        switch (playerPosition.getOrientation()) {
            case UP:
                nextX = playerPosition.getX();
                nextY = playerPosition.getY() - 1;
                if (map.getRoomTile(nextX, nextY).equals(" ⚘ ")) {
                    consume(nextX, nextY);
                }
                if (map.getRoomTile(nextX, nextY).equals("   ")) {
                    playerPosition.setY(nextY);
                }
                break;
            case DOWN:
                nextX = playerPosition.getX();
                nextY = playerPosition.getY() + 1;
                if (map.getRoomTile(nextX, nextY).equals(" ⚘ ")) {
                    consume(nextX, nextY);
                }
                if (map.getRoomTile(nextX, nextY).equals("   ")) {
                          playerPosition.setY(nextY);
                }
                break;
            case LEFT:
                nextX = playerPosition.getX() - 1;
                nextY = playerPosition.getY();
                if (map.getRoomTile(nextX, nextY).equals(" ⚘ ")) {
                    consume(nextX, nextY);
                }
                if (map.getRoomTile(nextX, nextY).equals("   ")) {
                           playerPosition.setX(nextX);
                }
                    break;
                case RIGHT:
                    nextX = playerPosition.getX() + 1;
                    nextY = playerPosition.getY();
                    if (map.getRoomTile(nextX, nextY).equals(" ⚘ ")) {
                        consume(nextX, nextY);
                    }
                    if (map.getRoomTile(nextX, nextY).equals("   ")) {
                            playerPosition.setX(nextX);
                    }
                    break;

                }
        }



    private void consume(int x, int y){
                score++;
                map.changeTile(x,y);
                }


    //----------------------------------------------------------------------
    //Getters and Setters
    public int getPlayerPositionX(){

        return playerPosition.getX();
    }

    public int getPlayerPositionY(){

        return playerPosition.getY();
    }

    public String getSpirit(){
        return playerSpirit();
    }
    public int getScore(){
        return score;
    }

    //----------------------------------------------------------------------
    //SingletonConstructor
    private static Player INSTANCE;
    private Player() {
        spawn();
    }

    public static Player getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Player();

        }

        return INSTANCE;
    }

}
