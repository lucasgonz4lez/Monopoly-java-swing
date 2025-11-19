package game;

public class Dice {
    private int value;
    
    public Dice() {
        this.value = 0;
    }

    public int roll() {
        return (int) (Math.random() * 6) + 1;
    }

    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public void reset() {
        this.value = 0;
    }
    
}
