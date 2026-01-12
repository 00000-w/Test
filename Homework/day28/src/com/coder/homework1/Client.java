package com.coder.homework1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1111);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        PrintWriter pw = new PrintWriter(os);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入1到100间的数字来猜数");
        while (true) {
            int x = scanner.nextInt();
           pw.println(x);
           pw.flush();
           String str = reader.readLine();
            System.out.println(str);
           if ("猜对了".equals(str))
               break;
        }
        pw.close();
        reader.close();
        socket.close();
    }
}
