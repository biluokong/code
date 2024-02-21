package javase基础封装继承和多态.day14;

public class Wife {
    private String idCard;
    private String name;
    private String birthDate;
    private Husband husband;

    public Wife() {
    }

    public Wife(String idCard, String name, String birthDate, Husband husband) {
        this.idCard = idCard;
        this.name = name;
        this.birthDate = birthDate;
        this.husband = husband;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    @Override
    public String toString() {
        return husband.getName() + "的妻子是" + name;
    }
}
