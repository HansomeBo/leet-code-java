package util;

public class NumberUtil {

    public static String decimalToBinary(int n){
        int tmp = n;
        String result = "";
        while (tmp < 1){
            tmp = n % 2;
            System.out.println(tmp);
            result = result + tmp;
            n = n / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(50));
    }
}
