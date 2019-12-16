package distributor;

import java.util.HashMap;
import java.util.Map;

public class Money {

    private Map<Coin, Integer> map = new HashMap<>();

    public double sum() {
        double sum = 0;
        for (Coin coin : map.keySet()) {
            sum += (coin.getValue() * map.get(coin));
        }
        return sum;
    }

    public void add(Money toAdd) {
        Map<Coin, Integer> toAddMap = toAdd.toMap();
        for(Coin coin : toAddMap.keySet()) {
            add(coin, toAddMap.get(coin));
        }
    }

    public void add(Coin coin) {
        add(coin, 1);
    }

    public void add(Coin coin, Integer cptCoin) {
        if(contains(coin)) {
            map.put(coin, map.get(coin) + cptCoin);
        } else {
            map.put(coin, cptCoin);
        }
    }

    public boolean contains(Coin coin) {
        if(map.containsKey(coin)) {
            return map.get(coin) > 0;
        }
        return false;
    }

    public void remove(Coin coin) {
        if(contains(coin)) {
            map.put(coin, map.get(coin) - 1);
        }
    }

    public Map<Coin, Integer> toMap() {
        return new HashMap<>(map);
    }





}
