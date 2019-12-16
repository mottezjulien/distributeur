package distributor.product;

public class Drink {

    private final DrinkType drinkType;

    public Drink(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }
}
