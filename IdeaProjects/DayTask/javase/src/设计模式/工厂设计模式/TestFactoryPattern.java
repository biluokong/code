package 设计模式.工厂设计模式;

public class TestFactoryPattern {
    public static void main(String[] args) {
        Computer huawei = FactoryPattern.createComputer("huawei");
        huawei.start();

        Computer mac = FactoryPattern.createComputer("mac");
        mac.start();
    }
}
