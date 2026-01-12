package com.coder.homework3;

import java.io.*;

public class Copy {
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

    public static void copyFile(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists())
            throw new IOException("源文件不存在" + srcFile.getAbsolutePath());

        if (destFile.isDirectory())
            throw new IOException("目标路径是一个目录，而不是文件" + destFile.getAbsolutePath());

        long totalBytes = srcFile.length();
        long copiedBytes = 0;

        try (
                FileInputStream fis = new FileInputStream(srcFile);
                FileOutputStream fos = new FileOutputStream(destFile);
                BufferedInputStream bis = new BufferedInputStream(fis);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
                copiedBytes += bytesRead;
                double progress = ((double) copiedBytes / totalBytes) * 100;
                System.out.printf("复制文件 %s 进度: %.2f%%\r", srcFile.getName(), progress);
            }
            System.out.println(srcFile.getName() + " 复制完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}