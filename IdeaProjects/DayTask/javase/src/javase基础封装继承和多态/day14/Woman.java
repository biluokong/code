package javase基础封装继承和多态.day14;

public class Woman {
    private String idCard;
    private String name;
    private final boolean sex = false;
    private Man man;

    public Woman(String idCard, String name, Man man) {
        this.idCard = idCard;
        this.name = name;
        this.man = man;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    @Override
    public String toString() {
        return "Woman{" +
                "idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + "女" +
                ", man=" + man +
                '}';
    }
}
