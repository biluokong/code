package 注解;

/**
 * 学习自定义注解
 */
//@Book(name = "<<Java从入门到放弃>>", author = {"汪训州", "李浪"}, price = 199.5)
@MyBook("<<精通数据库>>")
public class Customize {

    @Book(name = "<<Java从入门到入坟>>", author = {"汪训州", "李浪"}, price = 12.5)
    private Customize() {}

    @Book(name = "<<Java从入门到上天>>", author = {"汪训州", "李浪"}, price = 19.5)
    public static void main(String[] args) {
        @Book(name = "<<Java从入门到精通>>", author = {"汪训州", "李浪"}, price = 9.5)
        int age = 100;
    }
}

@interface Book {
    String name();
    String[] author();
    double price();
}

@interface MyBook {
    String value();  //特殊属性
    double price() default 9.9;
}

