package IO流.day32序列化和反序列化;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    private List<Student> stuS;

    public StudentManagementSystem() {
        stuS = new ArrayList<>();
        ObjectOutputStream oos = null;
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎使用学生信息管理系统，请认真阅读以下使用说明：\n" +
                "请输入不同的功能编号来选择不同的功能：\n" +
                "[1]查看学生列表\n" +
                "[2]保存学生\n" +
                "[3]删除学生\n" +
                "[4]查看某个学生详细信息");
        int no = input.nextInt();
        if (1 == no) {
            InformationListDisplay();
        } else if (2 == no) {
            saveInformation();
        } else if (3 == no) {
            deleteInformation();
        } else if (4 == no) {
            detailedInformation();
        } else {
            System.out.println("非法的输入！");
        }
        input.close();
    }

    public void detailedInformation() {
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        System.out.print("请输入你要查看学生的学号：");
        String id = input.next();
        input.close();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("students"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            stuS = (ArrayList) ois.readObject();
            for (Student s : stuS) {
                if (id.equals(s.getID())) {
                    System.out.println(s);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("该学生数据不存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteInformation() {
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        System.out.print("请输入你要删除学生的学号：");
        String id = input.next();
        input.close();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("students"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            stuS = (ArrayList) ois.readObject();
            for (Student s : stuS) {
                if (id.equals(s.getID())) {
                    stuS.remove(s);
                    System.out.println("已删除此学生数据");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("该学生数据不存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        informationOutput();
    }

    public void saveInformation() {
        Scanner input = new Scanner(System.in);
        String[] stu = new String[5];
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students"));
            try {
                stuS = (ArrayList) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            ois.close();
        } catch (IOException e) {
        }
        System.out.print("请输入你要保存学生的人数：");
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("请输入第" + (i + 1) + "个学生的信息：");
            System.out.print("学号：");
            stu[0] = input.next();
            System.out.print("姓名：");
            stu[1] = input.next();
            System.out.print("生日：");
            stu[2] = input.next();
            char sex;
            System.out.print("性别：");
            stu[3] = input.next();
            if ("男".equals(stu[3])) {
                sex = '男';
            } else if ("女".equals(stu[3])) {
                sex = '女';
            } else {
                System.out.println("非法的输入！");
                return;
            }
            System.out.print("邮箱：");
            stu[4] = input.next();
            Student student = new Student(stu[0], stu[1], stu[2], sex, stu[4]);
            stuS.add(student);
        }
        input.close();
        informationOutput();
    }

    public void InformationListDisplay() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("students"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            stuS = (ArrayList) ois.readObject();
            System.out.println("学号\t\t\t姓名\t\t\t性别\n" +
                    "------------------------------------");
            for (Student s : stuS) {
                System.out.println(s.getID() + "\t\t\t" + s.getName() + "\t\t\t" + s.getSex());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void informationOutput() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("students"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.writeObject(stuS);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
