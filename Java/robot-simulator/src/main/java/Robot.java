public class Robot{
    private static final char RIGHT = 'R';
    private static final char LEFT = 'L';
    private static final char ADVANCE = 'A';

    private Orientation orientation;
    private GridPosition gridPosition;

    public Robot(GridPosition gridPosition ,Orientation orientation){
        this.orientation = orientation;
        this.gridPosition = gridPosition;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public void turnRight() {
        this.orientation = this.orientation.getNext();
    }

    public void turnLeft(){
        this.orientation = this.orientation.getBefore();
    }

    public void advance()
    {
        switch (orientation)
        {
            case NORTH:
                this.gridPosition = new GridPosition(this.gridPosition.x,this.gridPosition.y+1);
                break;
            case EAST:
                this.gridPosition = new GridPosition(this.gridPosition.x+1,this.gridPosition.y);
                break;
            case SOUTH:
                this.gridPosition = new GridPosition(this.gridPosition.x,this.gridPosition.y-1);
                break;
            case WEST:
                this.gridPosition = new GridPosition(this.gridPosition.x-1,this.gridPosition.y);
                break;
        }
    }

    public void simulate(String fullSteps)
    {
        for (int i = 0; i < fullSteps.length(); i++) {
            switch (fullSteps.charAt(i))
            {
                case RIGHT:
                    turnRight();
                    break;
                case ADVANCE:
                    advance();
                    break;
                case LEFT:
                    turnLeft();
                    break;
                default:
                    break;
            }
        }
    }
}