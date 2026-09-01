public abstract class SeaCreature {

    protected String name;
    protected int position;
    protected int speed;
    protected int direction;
    protected static final String COLOR = "";

    public SeaCreature(String name, int position, int speed, int direction) throws InvalidCreatureException {
        if (name.length() > 0 && speed >= 0 && (direction == 1 || direction == -1)) {
            this.name = name;
            this.position = position;
            this.speed = speed;
            this.direction = direction; 
        } else {
            throw new InvalidCreatureException("Invalid creature parameters: name must be non-empty, speed must be non-negative, and direction must be either 1 or -1.");
        }
        
    }

    // Each subclass decides how it moves.
    public abstract void move(int tankWidth);

    // Each subclass decides how it looks in the terminal.
    public abstract String getSymbol();

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void turnAround() {
        direction *= -1;
    }

    protected void keepInsideTank(int tankWidth) {
        int maxPosition = Math.max(0, tankWidth - getSymbol().length());

        if (position > maxPosition) {
            position = maxPosition;
            direction = -1;
        }

        if (position < 0) {
            position = 0;
            direction = 1;
        }
    }

    public String getDirectionWord() {
        return direction >= 0 ? "right" : "left";
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " | name=" + name
                + " | position=" + position
                + " | speed=" + speed
                + " | direction=" + getDirectionWord();
    }

    public String getColor() {
        return COLOR;
    }
}
