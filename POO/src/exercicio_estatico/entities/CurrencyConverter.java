package exercicio_estatico.entities;

public class CurrencyConverter {
    public static final double IOF = 0.06;

    public static double amountToBePaid (double dollarPrice, double dollarsBought) {
        double amount = dollarPrice * dollarsBought;
        amount += amount * IOF;
        return amount;
    }

}
