package game.tiles;

public class SpecialTile {
    private String name;
    private int price;
    private int rent;
    private int housePrice;
    private int hotelPrice;
    private int houseCount;
    private int hotelCount;
    
    public SpecialTile(String name, int price, int rent, int housePrice, int hotelPrice) {
        this.name = name;
        this.price = price;
        this.rent = rent;
        this.housePrice = housePrice;
        this.hotelPrice = hotelPrice;
        this.houseCount = 0;
        this.hotelCount = 0;
    }
}
