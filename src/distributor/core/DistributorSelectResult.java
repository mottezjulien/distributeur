package distributor.core;

import distributor.Money;
import distributor.product.Drink;

import java.util.ArrayList;
import java.util.List;

public class DistributorSelectResult {

    private Drink drink;

    private Money moneyBack = new Money();

    private List<DistributorSelectResultError> errors = new ArrayList<>();

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public List<DistributorSelectResultError> getErrors() {
        return errors;
    }

    public void setMoneyBack(Money moneyBack) {
        this.moneyBack = moneyBack;
    }

    public Money getMoneyBack() {
        return moneyBack;
    }
}
