package com.coder.homework3;

import java.io.File;
import java.io.IOException;

public class FileCopyThread implements Runnable{
    private File src;
    private File dest;

    public FileCopyThread(File src, File dest) {
        this.src = src;
        this.dest = dest;
    }

    @Override
    public void run() {
        try {
            Copy.copyFolder(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
