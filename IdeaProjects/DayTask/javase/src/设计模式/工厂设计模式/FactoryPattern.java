package 设计模式.工厂设计模式;

public class FactoryPattern {
    /**
     * 定义已一个方法，创建对象返回
     */
    public static Computer createComputer(String info) {
        switch (info) {
            case "huawei":
                Computer c1 = new Huawei();
                c1.setName("huawei pro 16");
                c1.setPrice(5999);
                return c1;
            case "mac":
                Computer c2 = new Mac();
                c2.setName("MacBook pro");
                c2.setPrice(11900);
                return c2;
            default:
                return null;
        }
    }
}

