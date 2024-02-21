package 反射机制;

import java.lang.reflect.*;

/**
 * 反编译出一个类的类名、属性名、构造方法和普通方法
 */
public class Decompiler {
    public static void main(String[] args) {
        //获得类的完整名称
        String className = User.class.getName();
        //创建一个StringBuilder对象decompiler用来储存类的反编译信息
        StringBuilder decompiler = new StringBuilder();
        try {
            //根据完整类名获得Class类对象
            Class clazz = Class.forName(className);

            //反编译出类的修饰符和类名，并存放到decompiler对象中
            decompiler.append(Modifier.toString(clazz.getModifiers()) + " class " + clazz.getSimpleName() + " {\n");

            //获取类中的所有属性
            Field[] fields = clazz.getDeclaredFields();
            //获取类中的所有构造方法
            Constructor[] constructors = clazz.getDeclaredConstructors();
            //获取类中的所有普通方法
            Method[] methods = clazz.getDeclaredMethods();

            //反编译出类中的所有属性并放到decompiler对象中
            for (Field field : fields) {
                decompiler.append("\t" + Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName() + ";\n");
            }

            //反编译出类中所有构造方法以及构造方法的参数列表信息，并放到decompiler对象中
            for (Constructor constructor : constructors) {
                //反编译构造方法的修饰符和方法名
                decompiler.append("\n\t" + Modifier.toString(constructor.getModifiers()) + " " + clazz.getSimpleName() + "(");

                //反编译出构造方法的参数列表信息
                //获得参数列表信息有两种方法：用constructor.getParameters()方法 or constructor.getParameterTypes()方法
                Class[] parameterTypes = constructor.getParameterTypes();
                for (Class parameterType : parameterTypes) {
                    decompiler.append(parameterType.getSimpleName() + ",");
                }
                //如果参数个数为0，则将多余的逗号去掉
                if (decompiler.charAt(decompiler.length() - 1) == ',') {
                    decompiler.deleteCharAt(decompiler.length() - 1);
                }
                decompiler.append(") {\n\t}\n");
            }

            //反编译出类中的所有普通方法以及普通方法的参数列表信息，并放到decompiler对象中
            for (Method method : methods) {
                //反编译出普通方法的修饰符、返回值类型名和方法名
                decompiler.append("\n\t" + Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getSimpleName() + " " + method.getName() + "(");

                //反编译出普通方法的参数列表信息
                //获得参数列表信息有两种方法：用method.getParameters()方法 or method.getParameterTypes()方法
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    decompiler.append(parameter.getType().getSimpleName() + " " + parameter.getName() + ",");
                }
                //如果参数个数为0，则将多余的逗号去掉
                if (parameters.length > 0) {
                    decompiler.deleteCharAt(decompiler.length() - 1);
                }
                decompiler.append(") {\n\t}\n");
            }
            decompiler.append("}");
            //输出最终结果
            System.out.println(decompiler);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 用来测试反编译的用户类
 */
class User {
    private static final String str = "1234567890"; //0-9数字串，用于进行生成随机数字
    private final String ID;    //用户ID
    private String username;    //用户名
    private String userPassword;    //用户密码

    /**
     * 无参构造方法，随机生成ID、用户名和用户密码
     */
    User() {
        ID = generate(10);
        username = generate(6);
        userPassword = generate(8);
    }

    /**
     * 有参构造方法，随机生成ID，用户名和用户密码由用户传入
     * @param username 用户名
     * @param userPassword 用户密码
     */
    public User(String username, String userPassword) {
        ID = generate(10);
        this.username = username;
        this.userPassword = userPassword;
    }

    /**
     * 随机生成一串数字
     * @param num 一串数的长度
     * @return 生成的一串数字
     */
    private String generate(int num) {
        String s = "";
        for (int i = 0; i < num; i++) {
            s = s + str.charAt((int) (Math.random() * 10));
        }
        return s;
    }

    /**
     * 重写toString方法
     * @return 对象信息
     */
    @Override
    public String toString() {
        return "ID为：" + ID + "\t用户名为：" + username;
    }

    /**
     * 默认权限
     * @return 对象信息
     */
    String information() {
        return "ID为：" + ID + "\t用户名为：" + username + "\t用户密码为：" + userPassword;
    }

    public String getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
