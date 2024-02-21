package com.bjpowernode.javase.实验九字符串;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringTest08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入随机验证码的长度：");
        try {
            int length = input.nextInt();
            System.out.println("请输入你想要指定验证码的内容(1、2和3只至少要指定一项，输入true或false):");
            System.out.println("1.是否包含数字(0-9):");
            boolean num = input.nextBoolean();
            System.out.println("2.是否包含小写字母:");
            boolean lowerCase = input.nextBoolean();
            System.out.println("3.是否包含大写字母:");
            boolean upperCase = input.nextBoolean();
            System.out.println("4.是否允许出现重复字符:");
            boolean repeatChar = input.nextBoolean();
            checkCode(length, num, lowerCase, upperCase, repeatChar);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("    非法输入！");
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            e.getMessage();
        } finally {
            input.close();
        }
    }

    public static void checkCode(int length, boolean num, boolean lowerCase, boolean upperCase, boolean repeatChar) throws InvalidParameterException {

        if (num && !lowerCase && !upperCase && !repeatChar ) {
            cycle(length, 1);
        } else if (!num && lowerCase && !upperCase && !repeatChar) {
            cycle(length, 2);
        } else if (!num && !lowerCase && upperCase && !repeatChar) {
            cycle(length, 3);
        } else if (num && lowerCase && !upperCase && !repeatChar) {
            cycle(length, 4);
        } else if (num && !lowerCase && upperCase && !repeatChar) {
            cycle(length, 5);
        } else if (num && !lowerCase && !upperCase && repeatChar) {
            cycle(length, 6);
        } else if (!num && lowerCase && upperCase && !repeatChar) {
            cycle(length, 7);
        } else if (!num && lowerCase && !upperCase && repeatChar) {
            cycle(length, 8);
        } else if (!num && !lowerCase && upperCase && repeatChar) {
            cycle(length, 9);
        } else if (num && lowerCase && upperCase && !repeatChar) {
            cycle(length, 10);
        } else if (num && lowerCase && !upperCase && repeatChar) {
            cycle(length, 11);
        } else if (num && !lowerCase && upperCase && repeatChar) {
            cycle(length, 12);
        } else if (!num && lowerCase && upperCase && repeatChar) {
            cycle(length, 13);
        } else if (num && lowerCase && upperCase && repeatChar) {
            cycle(length, 14);
        } else {
            throw new InvalidParameterException("非法参数的指定！");
        }
    }

    public static void cycle(int length, int flag) {
        int i = 0, j = 0;
        char[] checkCode = new char[length];
        while (i < length) {
            if (1 == flag) {
                char t = (char) (Math.random() * 10 + 48);
                for (j = 0; j < i; j++) {
                    if (t == checkCode[j]) {
                        break;
                    }
                }
                if (j == i) {
                    checkCode[i++] = t;
                }
            } else if (2 == flag) {
                char t = (char) (Math.random() * 26 + 97);
                for (j = 0; j < i; j++) {
                    if (t == checkCode[j]) {
                        break;
                    }
                }
                if (j == i) {
                    checkCode[i++] = t;
                }
            } else if (3 == flag) {
                char t = (char) (Math.random() * 26 + 65);
                for (j = 0; j < i; j++) {
                    if (t == checkCode[j]) {
                        break;
                    }
                }
                if (j == i) {
                    checkCode[i++] = t;
                }
            } else if (4 == flag) {
                char t = (char) (Math.random() * 75 + 48);
                for (j = 0; j < i; j++) {
                    if (t == checkCode[j]) {
                        break;
                    }
                }
                if (j == i && ((t >= '0' && t <= '9') || (t >= 'a' && t <= 'z'))) {
                    checkCode[i++] = t;
                }
            } else if (5 == flag) {
                char t = (char) (Math.random() * 43 + 48);
                for (j = 0; j < i; j++) {
                    if (t == checkCode[j]) {
                        break;
                    }
                }
                if (j == i && ((t >= '0' && t <= '9') || (t >= 'A' && t <= 'Z'))) {
                    checkCode[i++] = t;
                }
            } else if (6 == flag) {
                char t = (char) (Math.random() * 10 + 48);
                checkCode[i++] = t;
            } else if (7 == flag) {
                char t = (char) (Math.random() * 58 + 65);
                for (j = 0; j < i; j++) {
                    if (t == checkCode[j]) {
                        break;
                    }
                }
                if (j == i && ((t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z'))) {
                    checkCode[i++] = t;
                }
            } else if (8 == flag) {
                char t = (char) (Math.random() * 26 + 65);
                checkCode[i++] = t;
            } else if (9 == flag) {
                char t = (char) (Math.random() * 26 + 97);
                checkCode[i++] = t;
            } else if (10 == flag) {
                char t = (char) (Math.random() * 75 + 48);
                for (j = 0; j < i; j++) {
                    if (t == checkCode[j]) {
                        break;
                    }
                }
                if (j == i && ((t >= '0' && t <= '9') || (t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z'))) {
                    checkCode[i++] = t;
                }
            } else if (11 == flag) {
                char t = (char) (Math.random() * 75 + 48);
                if ((t >= '0' && t <= '9') || (t >= 'a' && t <= 'z')) {
                    checkCode[i++] = t;
                }
            } else if (12 == flag) {
                char t = (char) (Math.random() * 43 + 48);
                if ((t >= '0' && t <= '9') || (t >= 'A' && t <= 'Z')) {
                    checkCode[i++] = t;
                }
            } else if (13 == flag) {
                char t = (char) (Math.random() * 58 + 65);
                if ((t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z')) {
                    checkCode[i++] = t;
                }
            } else {
                char t = (char) (Math.random() * 75 + 48);
                if ((t >= '0' && t <= '9') || (t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z')) {
                    checkCode[i++] = t;
                }
            }
        }
        System.out.println("您的验证码为：" + new String(checkCode));
    }
}

class InvalidParameterException extends Exception {
    public InvalidParameterException() {
    }

    public InvalidParameterException(String message) {
        super(message);
    }
}