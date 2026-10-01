package S5_Cases;

public class P62_FlightTickets {
    public static void main(String[] args) {
        double price = priceCalculator(8, 1000, "economyClass");
        System.out.println(price);
    }
    
    public static double priceCalculator(int month, double originalPrice, String seatType) {
    double invalidInput = -1;
    if (month >= 5 && month <= 10) {
        switch (seatType) { //use switch-branch to deal with value-match: a better way of source usage
            case ("firstClass"):
                return originalPrice * 0.9; //quit the method when return, so "break;" id not needed
            case ("economyClass"):
                return originalPrice * 0.85;
            default:
                return invalidInput;
        }
    } else if ((month >= 1 && month <= 4) || (month >= 10 && month <= 12)) {
        switch (seatType) {
            case ("firstClass"):
                return originalPrice * 0.7; //quit the method when return, so "break;" id not needed
            case ("economyClass"):
                return originalPrice * 0.65;
            default:
                return invalidInput;
        }
    } else {
            return invalidInput;
    }
    }
    
}
