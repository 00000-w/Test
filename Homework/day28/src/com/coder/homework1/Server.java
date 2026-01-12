package com.coder.homework1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1111);
        Socket client = server.accept();
        Random random = new Random();
        int x = random.nextInt(100) + 1;
        OutputStream os = client.getOutputStream();
        InputStream is = client.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        PrintWriter pw = new PrintWriter(os);
        while (true) {
            String str = reader.readLine();
            if (x > Integer.parseInt(str)) {
                pw.println("猜小了");
                pw.flush();
            } else if (x < Integer.parseInt(str)) {
                pw.println("猜大了");
                pw.flush();
            } else {
                pw.println("猜对了");
                pw.flush();
                break;
            }
        }
        server.close();
        pw.close();
        reader.close();
    }

}
