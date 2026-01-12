package com.coder.homework;

import java.io.*;
import java.util.*;

public class Main {
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
                if ("完成".equals(next))
                    break;
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
                if ("完成".equals(next)) {
                    scanner.close();
                    break;
                }
                writer.write(next + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.err.println("签到录入失败");
        }
    }

    public static void absent(File absentFile, File allPeopleFile, File signInFile) {
        System.out.println("缺席人员名单生成");
        List<String> allNames = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(allPeopleFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null)
                allNames.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> signInNames = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(signInFile))) {
            String line;
            while ((line = reader.readLine()) != null)
                signInNames.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(absentFile)) {
            for (String name : allNames) {
                if (!signInNames.contains(name))
                    writer.write(name + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
