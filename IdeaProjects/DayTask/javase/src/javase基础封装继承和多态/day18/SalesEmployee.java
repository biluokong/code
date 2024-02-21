package javase基础封装继承和多态.day18;

public class SalesEmployee extends Employee {
    private double monthlySales;
    private double reyaltyRate;

    public SalesEmployee(String name, int birthMonth, double monthlySales, double reyaltyRate) {
        super(name, birthMonth);
        this.monthlySales = monthlySales;
        this.reyaltyRate = reyaltyRate;
    }

    @Override
    public double getSalary(int month) {
        if (month == getBirthMonth()) {
            return monthlySales * reyaltyRate + 100;
        }
        return monthlySales * reyaltyRate;
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
}
