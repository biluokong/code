package javase基础封装继承和多态.day18;

public class BasePlusSalesEmployee extends Employee {
    private double monthlySales;
    private double reyaltyRate;
    private double basicSalary;

    public BasePlusSalesEmployee(String name, int birthMonth, double monthlySales, double reyaltyRate, double basicSalary) {
        super(name, birthMonth);
        this.monthlySales = monthlySales;
        this.reyaltyRate = reyaltyRate;
        this.basicSalary = basicSalary;
    }

    @Override
    public double getSalary(int month) {
        if (month == getBirthMonth()) {
            return basicSalary + monthlySales * reyaltyRate + 100;
        }
        return basicSalary + monthlySales * reyaltyRate;
    }

    public double getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales(double monthlySales) {
        this.monthlySales = monthlySales;
    }

    public double getReyaltyRate() {
        return reyaltyRate;
    }

    public void setReyaltyRate(double reyaltyRate) {
        this.reyaltyRate = reyaltyRate;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }
}
