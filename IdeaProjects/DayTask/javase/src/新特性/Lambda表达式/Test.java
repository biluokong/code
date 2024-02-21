package 新特性.Lambda表达式;

/**
 * 1、Lambda表达式的标准形式：(形参,形参,...) -> {}  （形参为空时，用()表示；->后面写要做的操作；{这里写具体操作的代码}）
 *
 * 2、使用前提：
 *      ① 是一个接口
 *      ② 接口中仅有一个抽象方法
 *
 * 3、注意：
 *      （1）当重写的方法的形式参数数量为0时，调用方法不需要参数，用()表示即可。
 *      （2）类型名称可以省略。
 *      （3）形参数量为1时，直接写形参即可，可以不需要括号。
 *      （4）多个形参时，括号内用逗号隔开；且其类型名称要么都省略，要么都不省略。
 *      （5）如果要执行的语句只有一条，可以省略大括号和分号（除了return语句）。
 *      （6）如果是return语句，可以省略return这个关键字。
 *      （7）必须有上下文环境，编译器才能推导出你使用了Lambda表达式。
 *
 * 4、匿名内部类和Lambda表达式的区别：
 *      （1）所需类型不同：匿名内部类可以用于接口、抽象类和具体类；Lambda表达式只能用于接口。
 *      （2）使用限制不同：匿名内部类不论接口中方法数量为多少都可以使用，但Lambda表达式需要接口中只有一个方法。
 *      （2）实现原理不同：使用匿名内部类编译时会产生字节码文件；而使用Lambda表达式时不会，是在运行时动态生成的。
 */
public class Test {
    public static void main(String[] args) {
        //1、使用自定义类实现Runnable接口或继承Tread类，在创建此线程对象

        //2、使用匿名内部类创建线程对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程启动了");
            }
        }).start();

        //3、使用Lambda表达式创建线程对象
        new Thread( () -> System.out.println("多线程启动了")).start();
        //这样写也行，但必须有上下文环境，让编译器知道你想使用Lambda表达式
        Runnable r = () -> System.out.println("多线程启动了");
        new Thread(r).start();

        //无参无返回值
        a1(() -> System.out.println("无参无返回值的Lambda表达式"));

        //有一个参数无返回值
        a2(s -> System.out.println(s));

        //有一个参数有返回值（参数的名称随意；只有一个语句且此语句为return语句是，可以省略return这个关键字）
        a3((String s) -> {return s;});   //可以在括号内使用形参的类型加名称
        a3((String t) -> {return t;});   //名称随意，类型要确定
        a3((t) -> {return t;});  //可以在括号内只使用形参的名称（名称随意）
        a3(s -> s);    //可以用括号，只使用形参的名称；可以省略return关键字。

        //有多个参数无返回值（多个参数时，类型名要么都省略，要么都不省略）
        a4((s, i) -> System.out.println(s + i));
    }

    public static void a1(TestInterface01 t) {
        t.m();
    }

    public static void a2(TestInterface02 t) {
        t.m("有一个参数无返回值的Lambda表达式");
    }

    public static void a3(TestInterface03 t) {
        System.out.println(t.m("有一个参数有返回值的Lambda表达式"));
    }

    public static void a4(TestInterface04 t) {
        t.m("有多个参数无返回值的Lambda表达式", 4);
    }
}