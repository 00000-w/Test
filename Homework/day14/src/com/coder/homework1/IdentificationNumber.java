package com.coder.homework1;

import java.util.Scanner;

/*从键盘接收用户身份证号码，必须是 18 位长，前 17 位必须是数字，最后 1 位必须是数
字或大写 X（使用普通方法和正则表达式，分别验证），如果身份证号码正确，则只显示前 6
位和后 4 位，中间 8 位生日部分以*号替换。根据倒数第 2 位，判断性别，单数显示“先生”，
双数显示“女士”。*/
public class IdentificationNumber {
    public static void main(String[] args) {
        System.out.println("请输入您的身份证号");
        Scanner scanner = new Scanner(System.in);
        String identity = scanner.next();
        checkIdNum(identity);
    }
    //普通方法验证
/*    public static void checkIdNum(String identity) {
        if (identity.length() != 18) {
            System.out.println("身份证的号码是18位，请确认您的输入是否正确！");
            return;
        }
        for (int i = 0; i < 17; i++) {
            if (!Character.isDigit(identity.charAt(i))) {
                System.out.println("身份证输入错误（前17位为数字）");
                return;
            }
        }
        if (!Character.isDigit(identity.charAt(17)) && identity.charAt(17) != 'X') {
            System.out.println("身份证输入错误(最后一位为数字或大写X）");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer(identity);
        stringBuffer.replace(6, 14, "********");
        if (identity.charAt(16) % 2 == 0)
            System.out.print("女士,");
        else
            System.out.print("先生,");
        System.out.print("您的身份信息加密为:" + stringBuffer);

    }*/
    //正则表达式方法
    public static void checkIdNum(String identity) {
        String regex = "^[0-9]{17}([0-9]|X)$";
        StringBuilder stringBuilder = new StringBuilder(identity);
        if (!identity.matches(regex)) {
            System.out.println("请输入正确的身份证号");
            return;
        }
        if (identity.charAt(16) % 2 == 0)
            System.out.print("女士，");
        else
            System.out.print("先生，");
        stringBuilder.replace(6, 14, "********");
        System.out.print("您的身份信息加密为" + stringBuilder);
    }
}
