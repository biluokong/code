package 实验六继承和多态;

public class Test01 {
    public static void main(String[] args) {
        //创建不同卡类对象
        Card elderlyCard = new ElderlyCard("张三", "01");
        Card studentCard = new StudentCard("李四", "02");
        Card generalCitizenCard = new GeneralCitizenCard("王五", "03");

        //若充值或消费的金额非法，捕捉抛出的相关异常并提示程序员
        try {
            //为卡充值
            elderlyCard.recharge(100);
            studentCard.recharge(50);
            generalCitizenCard.recharge(150);

            //刷卡消费
            elderlyCard.charge(2);
            studentCard.charge(4);
            generalCitizenCard.charge(6);
        } catch (IllegalRechargeAmountException e) {
            e.printStackTrace();
        } catch (InsufficientBalanceException e) {
            e.printStackTrace();
        }

        //输出卡的余额
        System.out.println(elderlyCard.getBalance());
        System.out.println(studentCard.getBalance());
        System.out.println(generalCitizenCard.getBalance());
    }
}

/**
 * 普通市民卡类
 */
class GeneralCitizenCard extends Card {

    /**
     * 有参构造，创建一个主人为owner，账户ID为id的普通市民卡
     * @param owner 普通市民卡的主人
     * @param id 账户ID
     */
    public GeneralCitizenCard(String owner, String id) {
        super(owner, id);
    }
}

/**
 * 学生卡类
 */
class StudentCard extends Card {

    /**
     * 有参构造，创建一个主人为owner，账户ID为id的学生卡
     * @param owner 学生卡的主人
     * @param id 账户ID
     */
    public StudentCard(String owner, String id) {
        super(owner, id);
    }
}

/**
 * 老人卡类
 */
class ElderlyCard extends Card {

    /**
     * 有参构造，创建一个主人为owner，账户ID为id的老人卡
     * @param owner 老人卡的主人
     * @param id 账户ID
     */
    public ElderlyCard(String owner, String id) {
        super(owner, id);
    }
}

/**
 * 卡类
 */
class Card implements RechargeAndCharge {
    private String owner;
    private String id;
    private double balance;

    /**
     * 有参构造，创建一个主人为owner，账户ID为id的卡
     * @param owner 卡的主人
     * @param id 账户ID
     */
    public Card(String owner, String id) {
        this.owner = owner;
        this.id = id;
        this.balance = 0;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * 对卡充值的功能
     * @param money 充值的金额
     * @throws IllegalRechargeAmountException 若充值的金额小于0，抛出非法充值金额异常
     */
    @Override
    public void recharge(double money) throws IllegalRechargeAmountException {
        if (money >= 0) {
            setBalance(money);
            System.out.println("充值成功！");
        } else {
            throw new IllegalRechargeAmountException();
        }
    }

    /**
     * 对卡消费的功能
     * @param money
     * @throws InsufficientBalanceException 如果消费金额大于余额，抛出余额不足异常
     */
    @Override
    public void charge(double money) throws InsufficientBalanceException {
        if (money <= getBalance()) {
            setBalance(getBalance() - money);
            System.out.println("刷卡成功！");
        } else {
            throw new InsufficientBalanceException();
        }
    }
}

/**
 * 余额不足异常类
 */
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException() {
    }

    @Override
    public String  getMessage() {
        return "刷卡失败，余额不足！";
    }
}

/**
 * 非法充值金额异常类
 */
class IllegalRechargeAmountException extends Exception {
    IllegalRechargeAmountException(){}

    @Override
    public String getMessage() {
        return "充值失败，非法的充值金额!";
    }
}

/**
 * 实现充值和收费的接口
 */
interface RechargeAndCharge {
    void recharge(double money) throws IllegalRechargeAmountException;
    void charge(double money) throws InsufficientBalanceException;
}


