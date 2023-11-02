public class PositionAndOrientation {

    //-----------------------------------------------------------------------
    //Position
    private int x;
    private int y;

    private Orientation orientation = Orientation.UP;


    //-----------------------------------------------------------------------
    //Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Orientation getOrientation() {
        return orientation;
    }
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    //----------------------------------------------------------------------
    //SingletonConstructor
    private static PositionAndOrientation Instance;
    private PositionAndOrientation() {}
    public static PositionAndOrientation getInstance() {
        if (Instance == null) {
            Instance = new PositionAndOrientation();
        }
        return Instance;
    }


}
