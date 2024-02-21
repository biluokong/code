package 新特性.Lambda表达式;

//无参无返回值
interface TestInterface01 {
    void m();
}

//带一个参数无返回值
interface TestInterface02 {
    void m(String s);
}

//带一个参数有返回值
interface TestInterface03 {
    String m(String s);
}

//有多个参数无返回值
interface TestInterface04 {
    void m(String s, int i);
}