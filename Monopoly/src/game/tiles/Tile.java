package game.tiles;

public class Tile {
    private String name;
    
    public Tile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void reset() {
        this.name = "";
    }
    
    public void destroy() {
        this.name = null;
    }
    
    public boolean isDestroyed() {
        return name == null;
    }
    
    public boolean isReset() {
        return name == "";
    }
    
    public boolean isNormal() {
        return name != null && name != "";
    }
    
    public void print() {
        System.out.println(name);
    }
    
}
