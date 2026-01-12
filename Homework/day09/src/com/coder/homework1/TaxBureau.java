package com.coder.homework1;

/*税务局对车船使用税收税标准如下
(1)1.0 升(含)以下 360 元
(2)1.0 升以上至 1.6 升(含) 420 元
(3)1.6 升以上至 2.0 升(含) 540 元
(4)2.0 升以上至 2.5 升(含) 800 元
(5)2.5 升以上至 3.0 升(含) 1800 元
(6)3.0 升以上至 4.0 升(含) 2800 元
(7)4.0 升以上 3600 元*/
public class TaxBureau {
    private double L;
    private int money;

    public double getL() {
        return L;
    }
    public void setL(double l) {
        L = l;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    TaxBureau() {
    }

    public static int charge(double L) {
        if (L > 0 && L <= 1.0)
            return 360;
        else if (L <= 1.6)
            return 420;
        else if (L <= 2.0)
            return 540;
        else if (L <= 2.5)
            return 800;
        else if (L <= 3.0)
            return 1800;
        else if (L <= 4.0)
            return 2800;
        else if (L > 4.0)
            return 3600;
        else {
            System.out.println("非法升数");
            return -1;
        }
    }
}
