import java.util.Scanner;
/*
* 这节我犯了范围容错错误
*
* */
public class Homework2 {
    public static void main(String[] args) {
        //1.从键盘录入学生分数(百分制）
        //2.要求：用switch完成
        //4.0-59E,60-69D,70-79C,80-89B,90-100A
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生成绩：");
        int score = scanner.nextInt();
        if (score < 0 || score > 100) {
            System.out.println("请录入正确成绩");
        } else {
            score /= 10;
            switch (score) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.println("E");
                    break;
                case 6:
                    System.out.println("D");
                    break;
                case 7:
                    System.out.println("C");
                    break;
                case 8:
                    System.out.println("B");
                    break;
                case 9:
                case 10:
                    System.out.println("A");
                    break;
            }
        }
    }
}
