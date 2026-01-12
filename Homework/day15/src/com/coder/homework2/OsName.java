package com.coder.homework2;

public class OsName {
    private OS osEnum;
    public static void main(String[] args) {
        /*获取用户操作系统名称，使用 switch 和枚举类型判断，如果是 window 操作系统，给用
        //户推荐 IE 浏览器，如果是 Linux 系统，给用户推荐 Chrome 浏览器*/
        String osName = System.getProperty("os.name");
        String os = osName.replaceAll("\\d", "").trim();
        OS osEnum = getOs(os);
        switch (osEnum) {
            case WINDOWS:
                System.out.println("推荐您使用IE浏览器");
                break;
            case LINUX:
                System.out.println("推荐您使用Chrome浏览器");
                break;
        }
    }

    public static OS getOs(String os) {
        if ("Windows".equals(os))
            return OS.WINDOWS;
        else if ("Linux".equals(os))
            return OS.LINUX;
        else
            return OS.OTHERS;
    }
}
