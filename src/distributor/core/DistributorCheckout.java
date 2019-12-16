package distributor.core;

import distributor.Coin;
import distributor.Money;

public class DistributorCheckout {

    private Money total = new Money();

    public void insert(Money insert) {
        total.add(insert);
    }

    public Money pay(Money money, double price) {
        insert(money);
        return pull(money.sum() - price);
    }

    private Money pull(double value) {
        Money moneyBack = new Money();
        if(value > 0) {
            for(Coin coin : Coin.orderByValueDesc()) {
                while(total.contains(coin) && value >= coin.getValue()) {
                    moneyBack.add(coin);
                    total.remove(coin);
                    value -= coin.getValue();
                }
            }
        }
        return moneyBack;
    }
}
