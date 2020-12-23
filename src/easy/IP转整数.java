package easy;

import util.NumberUtil;

public class IP转整数 {

    public static void main(String[] args) {
        System.out.println(transfer("192.168.158.1"));
        System.out.println(transfer("0.0.0.0"));
    }

    public static int transfer(String ip) {
        String[] array = ip.split("\\.");
        String bit = "";
        for (String s : array) {
            int number = Integer.parseInt(s);
            bit = bit + transferIntToBit(number);
        }
        System.out.println(bit);
        return NumberUtil.scale2Decimal(bit,2);
    }

    public static String transferIntToBit(int i) {
        String result = "";
        for (int j = 0; j < 8; j++) {
            result = (i % 2) + result;
            i = i / 2;
        }
        return result;
    }
}

