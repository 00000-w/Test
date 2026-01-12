package com.coder.homework2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(4);
        students.add(new Student("李白", 98, 70, 60, 95));
        students.add(new Student("杜甫", 98, 80, 85, 90));
        students.add(new Student("白居易", 95, 85, 55, 80));
        students.add(new Student("李商隐", 90, 50, 58, 70));

        int chineseScore = 0;
        int mathScore = 0;
        int englishScore = 0;
        int geographyScore = 0;

        int flunk = 0;
        int newFlunk = 0;

        for (Student student : students) {
            System.out.println(student.getName() + "的总成绩为 " + student.allScoreSum() + " , 平均成绩为 " + student.average());
            chineseScore += student.getChinese();
            mathScore += student.getMath();
            englishScore += student.getEnglish();
            geographyScore += student.getGeography();

            if (student.getChinese() < 60 || student.getMath() < 60 || student.getEnglish() < 60 || student.getGeography() < 60)
                flunk += 1;
            if (student.getChinese() < 60 * 1.1 || student.getMath() < 60 * 1.1 || student.getEnglish() < 60 * 1.1 || student.getGeography() < 60 * 1.1)
                newFlunk += 1;
        }

        System.out.println();

        Map<String, Integer> map = new HashMap<>(4);
        map.put("语文", chineseScore);
        map.put("数学", mathScore);
        map.put("英语", englishScore);
        map.put("地理", geographyScore);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "总成绩为 " + entry.getValue() + ", 平均成绩为 " + (entry.getValue() * 1.0 / map.size()));
        }

        System.out.println();

        System.out.println("挂科人数为 " + flunk);
        System.out.println("不及格分数提升10%, 挂科人数为 " + newFlunk);

        System.out.println();

        System.out.println("成绩表: ");
        System.out.println("姓名\t\t语文\t数学\t英语\t地理");
        System.out.println("------------------------");
        for (Student student : students) {
            System.out.print(student.getName());
            if (student.getName().length() == 2)
                System.out.print("  ");
            System.out.println("\t" + student.getChinese() + "\t" + student.getMath() + "\t" + student.getEnglish() + "\t" + student.getGeography());
        }
    }
}
