package com.coder.homework3;

import java.io.*;
import java.util.Date;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        /*try {

            FileInputStream fis = new FileInputStream("d:/student_teacher.properties");
            if (!new File("student_teacher.properties").exists()) {
                System.err.println("配置文件不存在");
                return;
            }

            Properties props = new Properties();
            props.load(fis);

            String studentName = props.getProperty("student.name");
            String studentGender= props.getProperty("student.gender");
            String teacherName = props.getProperty("teacher.name");
            int teacherAge = Integer.parseInt(props.getProperty("teacher.age"));

            Student student = new Student(studentName, studentGender);
            Teacher teacher = new Teacher(teacherName, teacherAge);

            try (ObjectOutputStream oosStudent = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
                oosStudent.writeObject(student);
            }

            FileOutputStream fosTeacher = new FileOutputStream("teacher.dat");
            DataOutputStream dosTeacher = new DataOutputStream(fosTeacher);
            teacher.teacherInformation(dosTeacher);
            dosTeacher.close();

            log("student.ser", "Serialized student object");
            log("teacher.dat", "Wrote teacher Information");

        } catch (IOException | NumberFormatException e) {
            System.err.println("操作失败: " + e.getMessage());
        }
    }

    public static void log(String fileName, String operation) throws IOException {
        File logFile = new File("operation_log.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
        long fileSize = new File(fileName).length();
        Date currentDate = new Date();

        writer.append("Operation: ").append(operation)
                .append(", File: ").append(fileName)
                .append(", Size: ").append(String.valueOf(fileSize)).append(" bytes")
                .append(", Time: ").append(currentDate.toString())
                .append("\n");
        writer.close();
    }*/

        try {
            // 1. 检查配置文件是否存在
            File configFile = new File("student_teacher.properties");
            if (!configFile.exists()) {
                System.err.println("错误：配置文件不存在，请检查 student_teacher.properties 是否在项目根目录下");
                return;
            }

            // 2. 加载配置
            Properties props = new Properties();
            try (FileInputStream fis = new FileInputStream(configFile)) {
                props.load(fis);
            }

            // 3. 读取配置项
            String studentName = props.getProperty("student.name");
            String studentGender = props.getProperty("student.gender");
            String teacherName = props.getProperty("teacher.name");
            int teacherAge = Integer.parseInt(props.getProperty("teacher.age"));

            // 4. 序列化学生对象（使用Externalizable）
            Student student = new Student(studentName, studentGender);
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
                oos.writeObject(student); // 正确调用方式
            }

            // 5. 存储教师信息（使用DataOutputStream）
            Teacher teacher = new Teacher(teacherName, teacherAge);
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("teacher.dat"))) {
                dos.writeUTF(teacher.getName());
                dos.writeInt(teacher.getAge());
            }

            // 6. 记录日志
            log("student.ser", "学生对象序列化");
            log("teacher.dat", "教师信息存储");

        } catch (IOException | NumberFormatException e) {
            System.err.println("操作失败: " + e.getMessage());
        }
    }

    // 日志方法
    public static void log(String fileName, String operation) throws IOException {
        File logFile = new File("operation_log.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            long fileSize = new File(fileName).length();
            String logEntry = String.format(
                    "[%s] 操作: %-15s | 文件: %-12s | 大小: %d字节%n",
                    new Date(), operation, fileName, fileSize
            );
            writer.write(logEntry);
        }
    }
}
