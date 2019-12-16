package distributor;

import java.util.*;

public enum Coin {

    FIVE_CENTS, TEN_CENTS, TWENTY_CENTS, FIFTY_CENTS, ONE_EURO, TWO_EUROS;

    public static List<Coin> orderByValueDesc() {
        List<Coin> coins = Arrays.asList(values());
        Collections.sort(coins, new Comparator<Coin>() {
            @Override
            public int compare(Coin coin1, Coin coin2) {
                return Double.compare(coin1.getValue(), coin2.getValue());
            }
        });
        Collections.sort(coins, Collections.reverseOrder());
        return coins;
    }

    public double getValue() {
        switch (this) {
            case FIVE_CENTS:
                return 0.05;
            case TEN_CENTS:
                return 0.1;
            case TWENTY_CENTS:
                return 0.2;
            case FIFTY_CENTS:
                return 0.5;
            case ONE_EURO:
                return 1;
            case TWO_EUROS:
                return 2;
            default:
                return 0;
        }
    }
}
