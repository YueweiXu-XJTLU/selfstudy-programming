package S9_Case_ATM;

public class Account {
    //instance variables
    private String cardID;
    private String name;
    private char gender;
    private String password;
    private double balance;
    private double WithdrawalLimits;

    //constructors
    public Account() {
    }

    public Account(String cardID, String name, char gender, String password, double balance, double withdrawalLimits) {
        this.cardID = cardID;
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.balance = balance;
        WithdrawalLimits = withdrawalLimits;
    }

    //getter & setter
    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getWithdrawalLimits() {
        return WithdrawalLimits;
    }

    public void setWithdrawalLimits(double withdrawalLimits) {
        WithdrawalLimits = withdrawalLimits;
    }
}