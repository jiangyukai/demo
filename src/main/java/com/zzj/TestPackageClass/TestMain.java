package com.zzj.TestPackageClass;

/**
 * @类名 TestMain
 * @描述 测试java8新特性
 * @作者 yk
 * @日期 2018-12-19 9:39
 **/
public class TestMain {
    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        //类型生明
        MathOperation add = (int a,int b) -> a+b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println(testMain.operate(3,4,add));
        System.out.println(testMain.operate(3,4,subtraction));
        System.out.println(testMain.operate(3,4,multiplication));
        System.out.println(testMain.operate(3,4,division));

    }
    interface MathOperation{
        int operation(int a,int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
