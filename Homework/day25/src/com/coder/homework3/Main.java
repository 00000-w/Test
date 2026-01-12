package com.coder.homework3;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new FileCopyThread(new File("C:/Users/Administrator/Desktop/大学/大学物理"), new File("D:/haha")));
        Thread t2 = new Thread(new FileCopyThread(new File("C:/Users/Administrator/Desktop/大学/2.1英语四六级"), new File("D:/haha")));
        Thread t3 = new Thread(new FileCopyThread(new File("C:/Users/Administrator/Desktop/大学/1.1.1高数"), new File("D:/haha")));
        t1.start();
        t2.start();
        t3.start();
    }
}
