package javase基础封装继承和多态.day18;

public class HourEmployee extends Employee {
    private double hourlyWage;
    private int hours;

    public HourEmployee(String name, int birthMonth, double hourlyWage, int hours) {
        super(name, birthMonth);
        this.hourlyWage = hourlyWage;
        this.hours = hours;
    }

    @Override
    public double getSalary(int month) {
        if (month == getBirthMonth()) {
            if (hours > 160) {
                return (hours - 160) * hourlyWage * 1.5 + 160 * hourlyWage + 100;
            } else {
                return hourlyWage * hours + 100;
            }
        }
        if (hours > 160) {
            return (hours - 160) * hourlyWage * 1.5 + 160 * hourlyWage;
        } else {
            return hourlyWage * hours;
        }
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
