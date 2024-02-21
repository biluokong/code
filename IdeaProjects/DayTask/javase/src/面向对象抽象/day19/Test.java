package 面向对象抽象.day19;
/*属性包括：姓名、年龄、性别
属性私有化，对外提供公开的set和get方法
提供无参数构造和有参数构造
提供一个生病方法：ill()，在该方法中打印信息，例如：张三，男，29岁生病了

定义一个病毒类
属性包括：病毒名称name、病毒体积size、病毒类型type
属性私有化，对外提供公开的set和get方法
提供无参数构造和有参数构造
提供一个攻击attack()方法，该方法的参数是“人”，例如：attack(Person p)
在attack()方法中调用人对象的生病方法。

编写测试程序，创建病毒对象，创建人对象，模拟病毒攻击人。*/
public class Test {
    public static void main(String[] args) {
        Humans human = new Humans("张三", 29, "男");
        Viruses virus = new Viruses("流感", 1, "冠状病毒");
        virus.attack(human);
    }
}
