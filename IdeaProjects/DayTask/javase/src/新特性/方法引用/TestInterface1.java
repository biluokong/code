package 新特性.方法引用;

interface TestInterface1 {
    void m(String s);
}

interface TestInterface2 {
    String  m(String s, int x, int y);
}

interface TestInterface3 {
    Student m(String name, String id);
}

class Student {
    String name;
    String id;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}