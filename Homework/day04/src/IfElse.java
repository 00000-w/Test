public class IfElse {
    public static void main(String[] args) {
        //抛硬币
        //获取随机数
        //（0， 1）的小数
        double d = Math.random();
        d *= 2;
        if(d < 1) {
            System.out.println("正面");
        } else {
            System.out.println("反面");
        }
    }
}
