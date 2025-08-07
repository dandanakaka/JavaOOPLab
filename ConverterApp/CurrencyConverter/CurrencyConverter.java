package CurrencyConverter;

// This class contains all the methods for currency conversions.
public class CurrencyConverter {
    // Conversion rates are hardcoded for this example.
    private final double USD_TO_INR = 83.50;
    private final double EUR_TO_INR = 90.25;
    private final double JPY_TO_INR = 0.53; // Yen to INR

    public double dollortoinr(double dollars) {
        return dollars * USD_TO_INR;
    }

    public double inrtodollor(double inr) {
        return inr / USD_TO_INR;
    }

    public double eurotoinr(double euro) {
        return euro * EUR_TO_INR;
    }

    public double inrtoeuro(double inr) {
        return inr / EUR_TO_INR;
    }

    public double yentoinr(double yen) {
        return yen * JPY_TO_INR;
    }

    public double inrtoyen(double inr) {
        return inr / JPY_TO_INR;
    }
}
