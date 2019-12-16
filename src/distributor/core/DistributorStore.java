package distributor.core;

import distributor.product.Drink;
import distributor.product.DrinkType;

import java.util.ArrayList;
import java.util.List;

public class DistributorStore {

    private List<Drink> list = new ArrayList<>();

    private Drink loaded = null;

    public boolean addAll(List<Drink> drinks) {
        return list.addAll(drinks);
    }

    public boolean findAndLoad(DrinkType drinkType) {
        loaded = null;
        for(Drink drink: list) {
            if(drink.getDrinkType().equals(drinkType)) {
                loaded = drink;
                return true;
            }
        }
        return false;
    }

    public Drink pullLoaded() {
        Drink loadedTempo = loaded;
        list.remove(loaded);
        loaded = null;
        return loadedTempo;
    }

    public boolean isLoaded() {
        return loaded != null;
    }
}
