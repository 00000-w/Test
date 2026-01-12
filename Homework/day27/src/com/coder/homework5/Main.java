package com.coder.homework5;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        service.schedule(() -> {
            try (FileInputStream fis = new FileInputStream("d:/java/测试文件.txt");
            FileOutputStream fos = new FileOutputStream("d:/java/复制测试文件.txt");)  {
                    fis.transferTo(fos);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }, 2, TimeUnit.SECONDS);
        //2分钟太长，以2秒为例

        service.schedule(() -> {
            System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/M/dd-HH:mm")));
        }, 3, TimeUnit.SECONDS);
        //30秒太长，以3秒为例

        service.scheduleAtFixedRate(() -> {
            File file = new File("d:/java/复制测试文件.txt");
            if (file.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(file));
                ) {
                    String str;
                    while ((str = br.readLine()) != null) {
                        System.out.println(str);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("文件不存在");
            }
        }, 2, 3, TimeUnit.SECONDS);
        //1分钟太长，以3秒为例,30秒以3秒为例
        service.shutdown();
    }
}
