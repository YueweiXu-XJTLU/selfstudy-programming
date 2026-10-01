package P177_P178_ThreadSafety;

public class AccountThread extends Thread{
    private Account account;

    public AccountThread(Account account, String name) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        account.drawMoney(100000.00);
    }
}
