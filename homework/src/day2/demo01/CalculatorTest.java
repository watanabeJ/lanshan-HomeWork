package day2.demo01;

import java.util.Scanner;

public class CalculatorTest {

        public static void main(String[] args) {
            System.out.println("请输入要计算的表达式");
            Calculator ca = new Calculator();
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            String a = Calculator.solve(s);
            System.out.println("计算结果为"+a);
        }

    }

