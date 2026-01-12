import java.util.Scanner;
public class Homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个小数");
        double d = scanner.nextDouble();
        //3.124235
        d = d * 100;
        //312.4235
        int x = (int)d;
        //314
        double y = x / 100d;
        System.out.println(y);
    }
}