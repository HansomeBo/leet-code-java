package top;


public class MySqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        /*TODO 有时间继续分析吧*/
        long z = x;
        while (z * z > x) {
            z = (z + x / z) / 2;
        }
        return (int) z;
    }
}
