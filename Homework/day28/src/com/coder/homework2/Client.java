package com.coder.homework2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 1234);
        System.out.println("输入要上传的文件名：");
        Scanner scanner = new Scanner(System.in);
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        File file;
        String fileName;
        //1）客户端从键盘接收要上传的文件名，如果文件不存在，则提示用户文件不存在，直到用户输入的文件存在
        while (true) {
            fileName = scanner.nextLine();
            file = new File(fileName);
            if (!file.exists()) {
                System.out.println("文件不存在");
            } else
                break;
        }
        //2）客户端将要上传的文件名发送给服务器端，告知服务器，要上传文件


        pw.println(fileName);
        pw.flush();
        //3）服务器端收到客户端要上传的文件名后，决定是否接收文件，如果不接收，则直接告知客户端拒绝接收，整个流程停止

        String yn = reader.readLine();
        System.out.println(yn);
        if ("y".equals(yn)) {
            //4）如果服务器端同意接收文件，则从键盘录入要接收文件的目录，如果目录不存在，则创建目录，如果创建失败，则提示用户目录创建失败，直到创建成功，并告知客户端，
            //已同意接收文件，可以上传
            System.out.println(reader.readLine());
            //5）在客户端上传文件结束后，客户端显示上传文件成功，服务器端显示上传文件失败
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            byte[] bytes = new byte[1024];
            int x;
            while ((x = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, x);
            }
            bos.flush();
            System.out.println("文件上传成功");
            bis.close();
            bos.close();
            fis.close();
        }
        pw.close();
        socket.close();
    }
}
