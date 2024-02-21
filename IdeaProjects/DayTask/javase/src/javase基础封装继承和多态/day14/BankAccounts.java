package javase基础封装继承和多态.day14;
//设计银行账户类，每个账户都有账号、密码、余额等信息。
public class BankAccounts {
    private String account;
    private String password;
    private double balances;

    public BankAccounts(String account, String password, double balances) {
        this.account = account;
        this.password = password;
        this.balances = balances;
    }

    public double getBalances() {
        return balances;
    }

    public void setBalances(double balances) {
        this.balances = balances;
    }
}
