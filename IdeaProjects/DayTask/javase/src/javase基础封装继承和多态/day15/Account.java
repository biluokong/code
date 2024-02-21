package javase基础封装继承和多态.day15;
/*写一个名为Account的类模拟账户
该类的属性和方法如下所示。
该类包括的属性：账户id，余额balance，年利率annualInterestRate；
包含的方法：各属性的set和get方法。取款方法withdraw()，存款方法deposit()

写一个测试程序
（1）创建一个Customer，名字叫Jane Smith，他有一个账号为1000，余额为2000，年利率为1.23%的账户
（2）对Jane Smith操作：
存入100元，再取出960元，再取出2000。
打印Jane Smith的基本信息
信息如下显示：
成功存入：100
成功取出：960
余额不足，取钱失败*/
public class Account {
    private String id;
    private double balance;
    private String annualInterestRate;

    public Account() {
    }

    public Account(String id, double balance, String annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public void withdraw(double balance) {
        if (this.balance < balance) {
            System.out.println("对不起，取钱失败，您的余额不足。");
        } else {
            this.balance -= balance;
            System.out.println("您成功取出了：" + balance);
        }
    }

    public void deposit(double balance) {
        this.balance += balance;
        System.out.println("您成功存入了：" + balance);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(String annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                ", annualInterestRate='" + annualInterestRate + '\'' +
                '}';
    }
}

class AccountTest {
    public static void main(String[] args) {
        Account JaneSmith = new Account("1000", 2000, "1.23%");
        JaneSmith.deposit(100);
        JaneSmith.withdraw(960);
        JaneSmith.withdraw(2000);
    }
}