package distributor;

import distributor.core.Distributor;
import distributor.core.DistributorSelectResult;
import distributor.core.DistributorSelectResultError;
import distributor.product.Drink;
import distributor.product.DrinkType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {

    public static void main(String[] arg) {

        List<Drink> magasin = new ArrayList<>();
        magasin.add(new Drink(DrinkType.EAU_GAZEUSE));
        magasin.add(new Drink(DrinkType.EAU_GAZEUSE));
        magasin.add(new Drink(DrinkType.EAU_GAZEUSE));
        magasin.add(new Drink(DrinkType.EAU_PLATE));
        magasin.add(new Drink(DrinkType.EAU_PLATE));
        magasin.add(new Drink(DrinkType.COCA));

        Map<DrinkType, Double> mapBoissonPrix = new HashMap<>();
        mapBoissonPrix.put(DrinkType.EAU_GAZEUSE, 1.95);
        mapBoissonPrix.put(DrinkType.EAU_PLATE, 1.5);
        mapBoissonPrix.put(DrinkType.COCA, 2.1);

        Money checkout = new Money();
        checkout.add(Coin.FIVE_CENTS, 5);
        checkout.add(Coin.TEN_CENTS, 5);
        checkout.add(Coin.TWENTY_CENTS, 5);
        checkout.add(Coin.FIFTY_CENTS, 5);
        checkout.add(Coin.ONE_EURO, 5);
        checkout.add(Coin.TWO_EUROS, 5);

        Distributor distributor = new Distributor(magasin, mapBoissonPrix, checkout);

        System.out.println("Début Scénario 1: Pas assez d'argent");
        Money money1 = new Money();
        money1.add(Coin.FIFTY_CENTS, 2);
        money1.add(Coin.ONE_EURO, 1);

        DistributorSelectResult result1 = distributor.select(DrinkType.COCA, money1);
        displayResult(result1);
        System.out.println("Fin Scénario 1: Pas assez d'argent");

        System.out.println("Début Scénario 2: Happy path");
        Money money2 = new Money();
        money2.add(Coin.FIFTY_CENTS, 2);
        money2.add(Coin.TWENTY_CENTS, 2);
        money2.add(Coin.ONE_EURO, 1);

        DistributorSelectResult result2 = distributor.select(DrinkType.COCA, money2);
        displayResult(result2);
        System.out.println("Fin Scénario 2: Happy path");


        System.out.println("Début Scénario 3: Plus de boisson");
        Money money3 = new Money();
        money3.add(Coin.FIFTY_CENTS, 2);
        money3.add(Coin.TWENTY_CENTS, 2);
        money3.add(Coin.ONE_EURO, 1);

        DistributorSelectResult result3 = distributor.select(DrinkType.COCA, money3);
        displayResult(result3);
        System.out.println("Fin Scénario 3: Plus de boisson");

    }

    private static void displayResult(DistributorSelectResult result) {
        if(!result.getErrors().isEmpty()) {
            System.out.println("Une ou plusieurs erreurs sont arrivées.");
            for(DistributorSelectResultError error: result.getErrors()) {
                switch (error) {
                    case NO_DRINK_FOR_TYPE:
                        System.out.println("La boisson sélectionnée n'est pas présente.");
                        break;
                    case NO_ENOUGH_MONEY:
                        System.out.println("Il n'y a pas assez d'argent pour cette boisson.");
                        break;
                }
            }
        }
        if(result.getDrink() != null) {
            System.out.println("Le distributeur a retourné une boisson de type " + result.getDrink().getDrinkType());
        }
        double moneyBack = result.getMoneyBack().sum();
        if(moneyBack > 0) {
            System.out.println("Le distributeur a retourné une monnaie égale à  " + moneyBack);
        }

    }

}
