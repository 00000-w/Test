import java.io.*;
import java.util.Scanner;

public class test {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        File allPeopleFile = new File("D:/签到表.txt");
        allPeople(allPeopleFile);

        File signInFile = new File("D:/2025年3月10日签到表.txt");
        signIn(signInFile);

        File absentFile = new File("D:/2025年3月10日缺席表.txt");
        absent(absentFile, allPeopleFile, signInFile);
        scanner.close();
    }

    public static void allPeople(File allPeopleFile) {

        try (FileWriter writer = new FileWriter(allPeopleFile, true)

        ) {
            System.out.println("请录入人员姓名（输入“'完成'结束录入）：");
            String next;
            while (true) {
                next = scanner.next();
                if ("完成".equals(next)) {

                    break;
                }
                writer.write(next + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void signIn(File signInFile) {
        System.out.println("请输入签到人员姓名（输入'完成'结束录入)：");

        try (FileWriter writer = new FileWriter(signInFile, true);

        ) {
            String next;

            while (true) {
                next = scanner.next();
                if ("完成".equals(next))
                    break;
                writer.write(next + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }

    public static void absent(File absentFile, File allPeopleFile, File signInFile) {
        System.out.println("缺席人员名单");
        try (BufferedReader reader1 = new BufferedReader(new FileReader(allPeopleFile));
             BufferedReader reader2 = new BufferedReader(new FileReader(signInFile));
             FileWriter writer = new FileWriter(absentFile, true)
        ) {
            String line1, line2;
            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                if (!line1.equals(line2)) {
                    writer.write(reader1.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
