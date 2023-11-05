package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine {

    private int totalCoins = 0;

    private static VendingMachineImpl instance = null;

    private VendingMachineImpl() {
        // Private constructor to enforce Singleton pattern
    }

    public static VendingMachine getInstance() {
      ArrayList<DrinkEntry> myDrinks = new ArrayList<>();

      myDrinks.add(new DrinkEntry(new DrinkImpl("ScottCola", true),0.75));
      myDrinks.add(new DrinkEntry(new DrinkImpl("KarenTea", false),1));

      return new VendingMachineImpl(myDrinks,0);
    }

    @Override
    public void insertQuarter() {
        totalCoins += 25;
    }

    @Override
    public Drink pressButton(String drinkName) throws NotEnoughMoneyException, UnknownDrinkException {
        if ("ScottCola".equals(drinkName)) {
            if (totalCoins >= 75) {
                totalCoins -= 75;
                return new Drink("ScottCola", true);
            } else {
                throw new NotEnoughMoneyException();
            }
        } else if ("KarenTea".equals(drinkName)) {
            if (totalCoins >= 100) {
                totalCoins -= 100;
                return new Drink("KarenTea", false);
            } else {
                throw new NotEnoughMoneyException();
            }
        } else {
            throw new UnknownDrinkException();
        }
    }
}
