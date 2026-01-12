package com.coder.homework2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        Socket client = server.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String fileName = reader.readLine();
        //2）客户端将要上传的文件名发送给服务器端，告知服务器，要上传文件
        System.out.println("客户端要上传文件" + fileName);
        //3）服务器端收到客户端要上传的文件名后，决定是否接收文件，如果不接收，则直接告知客户端拒绝接收，整个流程停止
        PrintWriter pw = new PrintWriter(client.getOutputStream());
        System.out.println("是否要接收文件(y/n)");
        Scanner scanner = new Scanner(System.in);
        String yn;
        while (true) {
            yn = scanner.nextLine();
            if ("y".equals(yn) || "n".equals(yn))
                break;
            System.out.println("无效选择");
        }
        if ("n".equals(yn)) {
            pw.println("客户端拒绝接收");
            pw.flush();
        }
        if ("y".equals(yn)) {
            //4）如果服务器端同意接收文件，则从键盘录入要接收文件的目录，如果目录不存在，则创建目录，如果创建失败，则提示用户目录创建失败，直到创建成功，并告知客户端，
            //已同意接收文件，可以上传
            pw.println("客户端接收文件");
            pw.flush();
            System.out.println("请录入要接收文件的目录");
            String dir = scanner.nextLine();
            File dirFile = new File(dir);
            while (!dirFile.exists()) {
                boolean b = dirFile.mkdirs();
                 if (b) {
                     pw.println("已同意接收文件，可以上传");
                     pw.flush();
                    break;
                } else {
                     pw.println("创建目录失败");
                     pw.flush();
                 }
            }
            //5）在客户端上传文件结束后，客户端显示上传文件成功，服务器端显示上传文件失败

            //正则表达式
            String filePath = fileName;
            Pattern pattern = Pattern.compile("[^/\\\\]+$");
            Matcher matcher = pattern.matcher(filePath);
            if (matcher.find())
                fileName = matcher.group();


            File file = new File(dirFile, fileName);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
            byte[] bytes = new byte[1024];
            int x;
            while ((x = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, x);
            }
            bos.flush();
            System.out.println("文件接收成功");
            bis.close();
            bos.close();
        }
        pw.close();
        reader.close();
        client.close();
        server.close();
    }
}
