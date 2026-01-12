package com.coder.homework2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        File srcFile = new File("C:/Users/Administrator/Desktop/大学");
        File destFile = new File("D:/");
        copyFolder(srcFile, destFile);
    }

    public static void copyFolder(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists())
            throw new IOException("源文件夹不存在" + srcFile.getAbsolutePath());

        if (!destFile.exists())
            if (!destFile.mkdirs())
                throw new IOException("创建目标文件夹失败" + destFile.getAbsolutePath());

        File[] files = srcFile.listFiles();
        if (files != null) {
            for (File file : files) {
                File newFile = new File(destFile, file.getName());
                if (file.isDirectory())
                    copyFolder(file, newFile);
                else
                    copyFile(file, newFile);
            }
        }
    }

    public static void copyFile(File srcFile, File destFile) {
        try (
            FileReader reader = new FileReader(srcFile);
            FileWriter writer = new FileWriter(destFile);
        ) {
            reader.transferTo(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
