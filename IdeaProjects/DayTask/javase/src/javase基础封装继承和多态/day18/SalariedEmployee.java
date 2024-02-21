package javase基础封装继承和多态.day18;

public class SalariedEmployee extends Employee {
    private double monthlySalary;

    @Override
    public double getSalary(int month) {
        if (month == getBirthMonth()) {
            return monthlySalary + 100;
        }
        return monthlySalary;
    }

    public SalariedEmployee(String name, int birthMonth, double monthlySalary) {
        super(name, birthMonth);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}
