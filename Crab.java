public class Crab extends SeaCreature {
    
    private String symbol;
    private static final String COLOR = "\u001B[31m";
    
    public Crab(String name, int position, int speed, int direction, String s) throws InvalidCreatureException  {
        super(name, position, speed, direction);
        symbol = s;
        if (symbol.length() < 1) {
            throw new InvalidCreatureException("Invalid crab symbol: symbol must be non-empty.");
        }
    }
    
    @Override
    public void move(int tankWidth) {
        if ( (int)(Math.random() * 10) != 0) {
            position += speed * direction;
            keepInsideTank(tankWidth);
            if ( (int)(Math.random() * 4) == 0 )
                direction *= -1;
        } else {
            dash(tankWidth);
        }
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    public void dash(int tankWidth) {
        position += speed * direction * 5;
        keepInsideTank(tankWidth);
    }

    @Override
    public String getColor() {
        return COLOR;
    }
}
// ʚ„[•ᴗ•]„ɞ
