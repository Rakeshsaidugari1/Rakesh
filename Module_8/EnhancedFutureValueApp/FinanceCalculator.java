public class FinanceCalculator {

    // constant to store number of months in a year
    private static final int MONTHS_IN_YEAR = 12;

    // method to calculate future value based on monthly payment, rate and years
    public static double calculateFutureValue(double monthlyPayment, double rate, int years) {
        // formula for calculating future value
        int months = years * MONTHS_IN_YEAR;
        double interestRate = 1 + (rate / 100);
        double presentValue = monthlyPayment * months;
        double futureValue = presentValue * Math.pow(interestRate, months);
        return futureValue;
    }
}
