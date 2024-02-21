package javase基础封装继承和多态.day14;

public class Test {
    public static void main(String[] args) {
        Husband ZhangSan = new Husband("421222197003022335", "张三", "1970年3月2日",
                new Wife());
        Wife LiXiaoFang = new Wife("421222196805092345", "李晓芳", "1968年5月9日", ZhangSan);
        ZhangSan.setWife(LiXiaoFang);
        System.out.println(ZhangSan.getWife());
        LiXiaoFang = null;
        System.out.println(LiXiaoFang.getHusband());
    }

}
