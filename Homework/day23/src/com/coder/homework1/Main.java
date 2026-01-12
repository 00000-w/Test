package com.coder.homework1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) throws IOException{
        getDisks();
    }

    public static void getDisks() throws IOException {
        File[] disks = File.listRoots();
        for (File disk : disks) {
            System.out.println(disk.getAbsolutePath());
            File[] files = disk.listFiles();
            if (files != null) {
                for (File file : files) {
                    getCreatTime(file);
                    if (file.isDirectory())
                        System.out.print("<DIR>\t");
                    else {
                        getFileLength(file);
                    }
                    getFileName(file);
                }
                System.out.println();
            }
            else
                System.out.println(disk + "盘符下没有文件");
        }
    }

    public static void getCreatTime(File file) throws IOException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd\tHH:mm");

        FileTime fileTime = (FileTime) Files.getAttribute(file.toPath(), "creationTime");
        Instant creationTime = fileTime.toInstant();
        LocalDateTime creatTime = creationTime.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.print(creatTime.format(formatter) + "\t");
    }

    public static void getFileLength(File file) {
        System.out.print(file.length() + "\t");
    }

    public static void getFileName(File file) {
        System.out.println(file.getName());
    }
}
